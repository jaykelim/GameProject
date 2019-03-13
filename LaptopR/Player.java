package LaptopR;

public class Player extends Creature {
	private int healAmount;
	private int maxHealth;
	public Player(String name, String description, int hitPoints, int damage, int healAmount) {
		super(name, description, hitPoints, damage);
		this.healAmount = healAmount;
		this.maxHealth = hitPoints;
	}
	
	
	
	public void heal() {
		int hitPtotal = this.healAmount+this.getHitPoints();
		if(hitPtotal>maxHealth) {
			
			int healAmt = this.maxHealth-this.getHitPoints();
			this.setHitPoints(maxHealth);
			System.out.println(this.getName()+" is healed by "+this.healAmount+".   "+this.getName()+"'s health ["+this.getHitPoints()+"/"+this.maxHealth+"]");
			System.out.println(this.getName()+" is fully restored.");
		}
		else {
			this.setHitPoints(this.getHitPoints()+this.healAmount);
			System.out.println(this.getName()+" is healed by "+this.healAmount+".   "+this.getName()+"'s health ["+this.getHitPoints()+"/"+this.maxHealth+"]");
			System.out.println(this.getName()+"'s current HitPoints: "+this.getHitPoints());
		}
		
	}
}
