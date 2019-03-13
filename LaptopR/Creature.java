package LaptopR;

public class Creature {
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private Room room;
	private int maxHealth;
	
	public Creature(String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.room = null;
		this.maxHealth = hitPoints;
	}
	
	public void attack(Creature creature) {
		System.out.println(this.name+" attacks "+creature.name+" dealing "+damage+" damage.  "+creature.getName()+"'s health ["+creature.hitPoints+"/"+creature.maxHealth+"]");
	}
	
	public void takeDamage(int damage) {
		if(damage <= hitPoints) {
			hitPoints = hitPoints - damage;
		}
		else {
			hitPoints = 0;
		}
	}
	
	public boolean isAlive() {
		if(hitPoints > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Setters n getters
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public int getHitPoints() {
		return this.hitPoints;
	}
	public int getDamage() {
		return this.damage;
	}
	public Room getRoom() {
		return this.room;
	}
	public void setHitPoints(int a) {
		this.hitPoints = a;
	}
	public void setDamage(int a) {
		this.damage = a;
	}
	public void setRoom(Room a) {
		this.room = a;
	}
	
	
	@Override
	public String toString() {
		String a = "";
		a += String.format("\nCreature Name: %15s \ndescription:\"%20s\" \nhitPoints: %03d \ndamage: %02d", name, description, hitPoints, damage);
		return a;
	}
}
