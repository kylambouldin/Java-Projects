import java.util.*;

public class Game
{
	// Constants:
	private static final int WARRIOR_HP 		= 50;
	private static final int WARRIOR_STR 		= 10;
	private static final int WARRIOR_SKILL 		= 15;
	private static final int WARRIOR_AC 		= 5;
	private static final String WARRIOR_NAME 	= "Gnusto Frotz";
	private static final String WARRIOR_TYPE 	= "valiant warrior";
	private static final String WARRIOR_PRONOUN	= "his";
	
	private static final int MONSTER_HP 		= 50;
	private static final int MONSTER_STR 		= 15;
	private static final int MONSTER_SKILL 		= 10;
	private static final int MONSTER_AC 		= 7;
	private static final String MONSTER_NAME 	= "Schmoo";
	private static final String MONSTER_TYPE 	= "gruesome ghost";
	private static final String MONSTER_PRONOUN	= "its";
	
	private static final int GRUE_HP 			= 100;
	private static final int GRUE_STR 			= 20;
	private static final int GRUE_SKILL 		= 15;
	private static final int GRUE_AC 			= 10;
	private static final String GRUE_NAME 		= "Grue";
	private static final String GRUE_TYPE 		= "boss ghost";
	private static final String GRUE_PRONOUN	= "his";
	
	private static final int CLAWS_DAMAGE_MOD 	= 3;
	private static final String CLAWS_NAME 		= "claws";
	private static final String CLAWS_HIT 		= "slashes";
	private static final String CLAWS_MISS 		= "swipes at but misses";

	private static final int SWORD_DAMAGE_MOD 	= 5;
	private static final String SWORD_NAME 		= "sword";
	private static final String SWORD_HIT 		= "stabs";
	private static final String SWORD_MISS 		= "swings at but misses";
	
	private static final int WAND_DAMAGE_MOD	= 30;
	private static final String WAND_NAME		= "magic wand";
	private static final String WAND_HIT		= "blasts a fireball at";
	private static final String WAND_MISS		= "aims at but misses";
	
	private static final String INTRO = 
	"Welcome to the game.  You control the actions of the valient Gnusto \n"+
	"Frotz, a warrior who has stumbled into a spooky haunted house.  You \n"+
	"can use commands such as 'north' or simply 'n' to move.\n"+
	"You can use 'attack' to attack a monster with a single blow.  You\n"+
	"can also use 'look' to examine the room you are in, and 'get <thing>'\n"+
	"to pick up an item named <thing>. Finally, you can type <quit> when \n"+
	"you are done playing.\n";
	
	private static Room currentRoom;
	
	public static Room getCurrentRoom() { return currentRoom; }
	public static void setCurrentRoom(Room newRoom) 
	{
		currentRoom = newRoom; 
	}
	
	public static void main(String args[]) 
	{
		// create the weapons, creatures, and rooms
		Weapon claws = new Weapon(CLAWS_DAMAGE_MOD, CLAWS_NAME, 
								  CLAWS_HIT, CLAWS_MISS);
		Weapon sword = new Weapon(SWORD_DAMAGE_MOD, SWORD_NAME,
								  SWORD_HIT, SWORD_MISS);
		Weapon wand = new Weapon(WAND_DAMAGE_MOD, WAND_NAME, WAND_HIT,
								 WAND_MISS);

		Creature player = new Creature(WARRIOR_HP, WARRIOR_STR, WARRIOR_SKILL, 
									   WARRIOR_AC, WARRIOR_NAME, WARRIOR_TYPE, 
									   WARRIOR_PRONOUN);
		Creature monster = new Creature(MONSTER_HP, MONSTER_STR, MONSTER_SKILL,
										MONSTER_AC, MONSTER_NAME, MONSTER_TYPE,
										MONSTER_PRONOUN);
		monster.setWeaponObject(claws);
		
		Creature grue = new Creature(GRUE_HP, GRUE_STR, GRUE_SKILL, GRUE_AC, 
									 GRUE_NAME, GRUE_TYPE, GRUE_PRONOUN);
		
		Room kitchen = new Room("This is the spooky kitchen of the "+
							    "haunted house", null, null);
		Room diningRoom = new Room("This is the tattered dining hall of the "+
								   "haunted mansion", monster, sword);
		Room parlor = new Room("This is the decrepit parlor. The once-rich "+
							   "tapesties and mouldering furniture\n"+
							   "fill you with a sense of foreboding.");
		Room pit = new Room("Oh no!  You've fallen in a pit.  There is no\n"+
		                    "way out.  You might as well quit.\n");
		Room hallway = new Room("This is a long creepy hallway from the "+
								"parlor to the bedrooms.");
		Room bedroom = new Room("This is the haunted bedroom.  A stench of "+
		                        "evil pervades the air.", grue, wand);
		
		// connect the rooms together
		kitchen.setRoomToEast(diningRoom);
		diningRoom.setRoomToWest(kitchen);
		diningRoom.setRoomToNorth(parlor);
		parlor.setRoomToSouth(diningRoom);
		parlor.setRoomToNorth(pit);
		parlor.setRoomToEast(hallway);
		hallway.setRoomToWest(parlor);
		hallway.setRoomToEast(bedroom);
		bedroom.setRoomToWest(hallway);
				
		// place the player and print introduction
		setCurrentRoom(kitchen);
		System.out.print(INTRO);
		
		Scanner stdin = new Scanner(System.in);
		
		// main loop
		while (true)
		{
			Room newRoom = currentRoom.enterRoom(player);
			if (newRoom == null) 
			{
				System.out.println("Thank you for playing!  Goodbye.");
				return;
			}
			else
			{
				currentRoom = newRoom;
			}
		}
	}
	
}