package LaptopR;
import java.util.Scanner;

public class Battle {
	private Player player;
	private Monster monster;
	
	public Battle(Player a, Monster b) {
		this.player = a;
		this.monster = b;
	}
	
	
	
	public void run() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Battle begins: "+player.getName()+" vs. "+monster.getName());
		int turnCounter = 1;
		while(player.isAlive() && this.monster.isAlive()) {
			System.out.println(player.getName()+" HP: "+player.getHitPoints()+", " +this.monster.getName()+" HP: "+this.monster.getHitPoints()+"\n");
			char inPut = 'x';
			System.out.println("Player Turn "+turnCounter +": Do you want to (a) to attack or (h) to heal");

			while(inPut != 'a' && inPut != 'A' && inPut != 'h' && inPut != 'H') {
				System.out.print(">");
				inPut = scnr.next().charAt(0);
				if(inPut!= 'a' && inPut != 'A' && inPut != 'h'&& inPut != 'H') {
					System.out.println("Invalid input, please enter (a) to attack or (h) to heal.");
				}
				
			}
			
			if(inPut == 'a' || inPut == 'A') {
				this.monster.takeDamage(player.getDamage());
				player.attack(this.monster);
				
				if(!this.monster.isAlive()) {
					System.out.println("Congratulations you have defeated "+monster.getName());
					;
				}
				
			}
			else if(inPut == 'h' || inPut == 'H') {
				player.heal();
			}
			if(this.monster.isAlive() && player.isAlive()) {
				
				this.monster.enrage();
				
				player.takeDamage(this.monster.getDamage());
				this.monster.attack(player);
				
				if(!player.isAlive()) {
					System.out.println(player.getName()+" has been defeated.");
				}
			}
			//System.out.println("\n============================= END OF TURN "+turnCounter+" =============================\n");
			turnCounter++;
			
			
		}
		//scnr.close();
	}
}


