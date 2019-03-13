package LaptopR;

public class Monster extends Creature {
	
	private boolean isEnraged = false;
	private int enrageThreshold;
	
	public Monster(String name, String description, int hitPoints, int damage, int enrageThreshold) {
		super(name, description, hitPoints, damage);
		this.enrageThreshold = enrageThreshold;
	}
	
	
	public boolean canEnrage() {
		if(this.getHitPoints()<this.enrageThreshold) {
			return true;
		}
		else {
			return false;
		}
	}
	public void enrage() {
		if(this.isEnraged == false) {
			if(canEnrage()) {
			
					this.setDamage(this.getDamage()*2);
					this.isEnraged = true;
					System.out.println(this.getName()+" has become enraged. "+this.getName()+"'s damage has increased to "+this.getDamage()+".");
		
			
			}
			
		}
	}
}
