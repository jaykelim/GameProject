package LaptopR;

public class Room {
	protected int roomIndex;
	protected String description;
	protected Monster monster;
	
	
	public Room(int roomIndex, String description, Monster monster) {
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}
	
	public boolean isComplete() {
		if(monster.isAlive()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Monster getMonster() {
		return this.monster;
	}
	
	public void enter(Player player) {
		System.out.println("This room is \""+this.description+"\", and has: "+this.monster);
		if(this.monster.isAlive()) {
			Battle battle = new Battle(player, this.monster);
	        battle.run();
		}
		else {
			System.out.println("The monster has already been defeated.");
		}
	}
	
	@Override
	public String toString() {
		String a = "";
		a += String.format("Room index %2d, description \"%20s\", monster name %20s", roomIndex, description, monster.getName());
		return a;
	}
}
