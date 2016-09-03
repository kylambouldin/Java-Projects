import java.util.*;

public class MapGame
{

	private static boolean princessCaptured = false;
    // Constants:
    private static int MAZE_HEIGHT		= 2; // start small to 
    private static int MAZE_WIDTH			= 2; // simplify debugging
	
    private static final int MAZE_PERCENT_WEAPON= 25;
    private static final int MAZE_PERCENT_MONSTER=25;
	
    private static final int MONSTER_MAX_HP 	= 50;
    private static final int MONSTER_MAX_STR 	= 15;
    private static final int MONSTER_MAX_SKILL 	= 10;
    private static final int MONSTER_MAX_AC 	= 7;

    private static final int WEAPON_MAX_MOD		= 15;

    private static final int WARRIOR_HP 		= 150;
    private static final int WARRIOR_STR 		= 10;
    private static final int WARRIOR_SKILL 		= 15;
    private static final int WARRIOR_AC 		= 5;
    private static final String WARRIOR_NAME 	= "Gnusto Frotz";
    private static final String WARRIOR_TYPE 	= "valiant warrior";
    private static final String WARRIOR_PRONOUN	= "his";
	
    private static final String INTRO = 
	"\033[30m\n\nWelcome to the game.  You control the actions of the valient Gnusto \n"+
	"Frotz, a warrior who is lost in the woods looking for his beautiful princess."
	+ "\nUse commands such as 'north' or simply 'n' to move. \nYou can use 'attack' to " + 
	"attack a monster with a single blow.  \nYou can also use 'look' to examine the room "
	+ "you are in, and 'get' to pick up a weapon. \nExplore the maze and kill all the "+
	"monsters to win the game! To quit type <quit>\n\n\n" +
	"********************************\n" +
	
	"You walk up to a white house and hear a scream coming from the top floor.\n" +
	"It sounds like the princess voice, so you run inside the house. \n" +
	"Once you enter, the door slams shut behind you...\n\n";
	
	
	
    private static Room currentRoom;
    
    public static Room getCurrentRoom() { return currentRoom; }
    public static void setCurrentRoom(Room newRoom) { currentRoom = newRoom; }
	
    public static void main(String args[]) 
    {
	// create the player
	Creature player = new Creature(WARRIOR_HP, WARRIOR_STR, WARRIOR_SKILL, 
				       WARRIOR_AC, WARRIOR_NAME, WARRIOR_TYPE, 
				       WARRIOR_PRONOUN);
		
	// create and populate the rooms of the maze
	
	System.out.print(INTRO);
	
	while (princessCaptured == false){
	Map maze = new Map(MAZE_HEIGHT, MAZE_WIDTH);
		
	maze.setMaxMonsterStrength(MONSTER_MAX_STR);
	maze.setMaxMonsterSkill(MONSTER_MAX_SKILL);
	maze.setMaxMonsterHitPoints(MONSTER_MAX_HP);
	maze.setMaxMonsterArmorClass(MONSTER_MAX_AC);
	maze.setMaxWeaponDamageMod(WEAPON_MAX_MOD);
		
	maze.populate(MAZE_PERCENT_WEAPON, MAZE_PERCENT_MONSTER);
	
	// connect all the rooms to their neighbors - use while debugging
//	maze.connectAllRooms();
		
	// connect all rooms in a maze - erase the above line and uncomment 
	// the below line when you are ready to start coding and debugging 
	// the maze generation algorithm
	maze.generateMaze();
		
						
	// place the player and print introduction
	setCurrentRoom(maze.getRoom(0,0));
		
	Scanner stdin = new Scanner(System.in);
	//MapPrinter.printMap (maze, maze.getRoom(0,0));
		
	// main loop
	while (maze.allMonstersDead() == false)
	    {
	    
	    MapPrinter.printMap(maze,getCurrentRoom());
		Room newRoom = currentRoom.enterRoom(player);
		if (newRoom == null) 
		    {
			System.out.println("\033[30mThank you for playing!  Goodbye.");
			return;
		    }
		else
		    {
			setCurrentRoom(newRoom);
		    }
	    }//end while
	if (maze.allMonstersDead() == true && MAZE_HEIGHT <= 4){
		System.out.println("\033[30m\nYou see stairs ahead and run up to the next floor");
		System.out.println("\033[30m\n~NEXT LEVEL~\n");
		MAZE_HEIGHT ++;
		MAZE_WIDTH ++;
    }
    else if (maze.allMonstersDead() == true && MAZE_HEIGHT == 5){
    	princessCaptured = true;
    }
    
    }//end while

   if (princessCaptured == true){
   	System.out.println("\033[30mAll monsters are dead!  You go and rescue the princess!\n"+
			   "Congratulations and goodbye.");
	}//end if
	} //end static
}//end class
