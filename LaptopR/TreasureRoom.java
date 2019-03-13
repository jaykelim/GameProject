package LaptopR;

public class TreasureRoom extends Room{
	private String treasure;
	
	public TreasureRoom(int roomIndex, String description, Monster monster, String treasure) {
		super(roomIndex, description, monster);
		this.treasure = treasure;
	}
	
	public void enter(Player player) {
		System.out.println("Player name: "+player.getName());
		System.out.println("This treasure room is "+this.description+", and has "+this.monster);
		if(monster.isAlive()) {
			Battle battle = new Battle(player, this.monster);
	        battle.run();
	        if(player.isAlive()) {
	        	System.out.println("You explored the treasure room and found the hidden treasure!");
	        }
		}
		else {
			System.out.println("The monster has already been defeated.");
		}
	}
	
}
