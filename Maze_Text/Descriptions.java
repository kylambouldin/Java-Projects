// Name, e-mail, purpose

import java.util.*;

public class Descriptions {
	
    private String roomAdjectives[] = { "dark", "bright", "dirty", "stinky", 
    				"carpeted", "haunted", "red", "orange", "yellow", "green",
					"blue", "purple", "brown", "gray", "large", "small", 
					"wood floored" };
    private String roomTypes[] = {"hallway", "bedroom", "dining room", 
    				"living room", "office", "laboratory", "kitchen", "attic",
					"storage room", "bathroom", "throne room", "jail cell",
					"foyer", "parlor", "stable", "greenhouse", "basement",
					"cellar" };
    private String monsterTypes[] = { "troll", "orc", "goblin", "dragon",
			        "grue", "bandit", "pirate", "grue", "vampire", "ghoul",
			        "worm","dementor", "evil mage", "Java textbook",
			        "Prof. Luebke", "Prof. Bloomfield" };
	private String monsterNames[] = {"Bob", "MaryAnne", "Dustin", "Mr. Bui", "Rodrigo"};
	
    // These weapons are of Okianawan and Japanese origin
    private String weaponNames[] = { "bo staff", "jo staff", "sai", 
    				"pair of nunchucks", "kama", "katana", "wakizashi", 
    				"tanto", "tonfa", "naginata", "yari" };
    private String pronoun[] = {"his", "its", "her", "the"};


    private Random rand = new Random();
	
    public Descriptions() {
    }
	
	
    public String getNextRoomAdjective() {
		int n = rand.nextInt(roomAdjectives.length);
		return roomAdjectives[n];
    }

    public String getNextRoomType() {
		int n = rand.nextInt(roomTypes.length);
		return roomTypes[n];
    }

    public String getNextMonsterType() {
		int n  = rand.nextInt(monsterTypes.length);
		return monsterTypes[n];
    }

    public String getNextWeaponName() {
		int n = rand.nextInt(weaponNames.length);
		return weaponNames[n];
    }
    public String getNextPronoun(){
    	int n = rand.nextInt(pronoun.length);
    	return pronoun[n];
    }
	public String getNextMonsterName(){
		int n = rand.nextInt(monsterNames.length);
		return monsterNames[n];
	}
}

//	4.	Next, complete the getNextRoomAdjective() method. It currently returns null, but should 
	//return one of the adjectives in the roomAdjectives array, chosen at random. Thus, you need 
	//to generate an appropriate random number (via the nextInt() method in the Random class), 
	//then return that element in the roomAdjectives array.
	
//	5.	Similarly, the getNextRoomType() method should do the same for the roomTypes array. 
	//Note that the two arrays may be of different sizes, so be sure not to mix them up in your code.
//	6.	Similarly for the getNextMonsterName() and getNextWeaponName() methods.