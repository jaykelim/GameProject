package LaptopR;

public class Game {
	
	//Player // Reads PlayerInfo, seperate by newlines.
	TextFileHandler f1 = new TextFileHandler();
	String PlayerTextInput = f1.readFile("PlayerInfo.txt");
	String [] pArray = PlayerTextInput.split("\n");
	String pName = pArray[0];
	String pDesc = pArray[1];
	int pHP = Integer.parseInt(pArray[2]);
	int pDMG = Integer.parseInt(pArray[3]);
	int pHeal = Integer.parseInt(pArray[4]);
	Player player = new Player(pName, pDesc, pHP, pDMG, pHeal);
	
	
	//Monsters
	Monster orc = new Monster("Orc", "Covered with green blood", 20, 5, 0);
	Monster skel = new Monster("Skeleton", "Funny how it moves", 40, 10, 10);
	Monster fdrag = new Monster("Fire Dragon", "Spout fire with each breath", 100, 20, 40);
	
	//Rooms
	Room r1 = new Room(0, "A room with an unbearable smell", orc);
	Room r2 = new Room(1, "Dark and cold", skel);
	TreasureRoom r3 = new TreasureRoom(2, "Spout fire with each breath", fdrag, "Shiny Dragon Scale");
	
	Room [] dungeon = {r1, r2, r3};
	
	public void play() {
		String b = pName;
		f1.appendToFile("GameLog.txt", "\n");
		f1.appendToFile("GameLog.txt", b+" has started a game");
		System.out.println("Welcome to the game "+pName);
		for(int i =0; i<dungeon.length; i++) {
			int roomNum = i+1;
			if(i!=2) {
			System.out.println("================= "+pName+" has entered Room "+roomNum+" =================");
			f1.appendToFile("GameLog.txt", pName+" has entered Room "+roomNum);
			}
			if(i==2) {
				System.out.println("================= "+pName+" has found and entered a Treasure Room in Room "+roomNum+" =================");
				f1.appendToFile("GameLog.txt", pName+" has entered the Treasure Room in Room "+roomNum);
			}
			dungeon[i].enter(player);
			if(!player.isAlive()) {
				System.out.println("GAME OVER");
				f1.appendToFile("GameLog.txt", pName+" has died in Room "+roomNum);
				f1.appendToFile("GameLog.txt", "Game Over");
				break;
			}
			else{
				
				System.out.println(pName+" has completed room "+roomNum);
				f1.appendToFile("GameLog.txt", pName+" has defeated Room "+roomNum);
				if(i == dungeon.length-1) {
					System.out.println("Congratulations, you have completed all the rooms");
					f1.appendToFile("GameLog.txt", pName+" has defeated all the rooms");
				}
				
				}
			}
		}
	
	
	public static void main (String[] args) {
		Game newgame = new Game();
		newgame.play();
		
	
	}
}
