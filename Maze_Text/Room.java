import java.io.*;
import sun.audio.*;

//The Room class should use variables to represent the following attributes:
//Room roomToNorth: contains a reference to the Room object reached by going north from this room, or null if no such Room exists.
//Room roomToEast: contains a reference to the Room object reached by going east from this room, or null if no such Room exists.
//Room roomToSouth: contains a reference to the Room object reached by going south from this room, or null if no such Room exists.
//Room roomToWest: contains a reference to the Room object reached by going west from this room, or null if no such Room exists.
//String description: a String containing a textual description of the room, e.g. "This is the kitchen."
//Creature monster: a reference to the Creature object inhabiting this room, or null if the room is empty of monsters.
//Weapon item: a reference to the Weapon object in this room, or null if the room has no weapon lying in it.

public class Room{
	Room roomToNorth;
	Room roomToEast;
	Room roomToSouth;
	Room roomToWest;
	String description;
	Creature monster;
	Weapon item;
	int x;
	int y;
	
//Room(): A default constructor that sets description to "A nondescript room." and monster and item to null.
//Room(String desc): A specific constructor that sets description to desc and monster and item to null.
//Room(String desc, Creature occupant, Weapon weap): a specific constructor that sets the description, monster, and item fields.
	
	public Room(){
	Room roomToNorth = null;
	Room roomToEast = null;
	Room roomToSouth = null;
	Room roomToWest = null;
	description = "A nondescript room";
	monster = null;
	item = null;
	}
	
		public Room(String desc){
	roomToNorth = null;
	roomToEast = null;
	roomToSouth = null;
	roomToWest = null;
	description = desc;
	monster = null;
	item = null;
	}
	
	
	
	public Room(String desc, int row, int collum){
	roomToNorth = null;
	roomToEast = null;
	roomToSouth = null;
	roomToWest = null;
	description = desc;
	x = row;
	y = collum;
	monster = null;
	item = null;
	}
	
	public Room(String desc, Creature occupant, Weapon weap){
	roomToNorth = roomToNorth;
	roomToEast = roomToEast;
	roomToSouth = roomToSouth;
	roomToWest = roomToWest;
	description = desc;
	monster = occupant;
	item = weap;
	}
	
//get/set pairs of accessor/mutator methods for all the attributes.	


public void setRow(int row){
		int x = row;
	}
public int getRow(){
		return x;
	}
	
public void setCol(int collum){
		int y= collum;
	}
public int getCol(){
		return y;
	}




public void setRoomToNorth(Room newRoom){
		roomToNorth = newRoom;
	}
	public Room getRoomToNorth(){
		return roomToNorth;
	}


public void setRoomToEast(Room newRoom){
		roomToEast = newRoom;
	}
	public Room getRoomToEast(){
		return roomToEast;
	}


public void setRoomToSouth(Room newRoom){
		roomToSouth = newRoom;
	}
	public Room getRoomToSouth(){
		return roomToSouth;
	}
	
public void setRoomToWest(Room newRoom){
		roomToWest = newRoom;
	}
	public Room getRoomToWest(){
		return roomToWest;
	}
	
public void setDescription(String desc){
		description = desc;
	}
	public String getDescription(){
		
		return description;
	}
	
public void setMonster(Creature occupant){
		monster = occupant;
	}
	public Creature getMonster(){
		return monster;
	}
	
	
public void setWeapon(Weapon weap){
		item = weap;
	}
	public Weapon getWeapon(){
		return item;
	}
	
	

//void printDescription(): This method prints description to System.out, 
	//then prints a line describing the exits of the room. This line should take the form, 
	//"You may exit to the north" or "You may exit to the east, south, and west". 
	//If a room has no exits the line should read, "There are no exits". 
	//If there is a weapon or a creature in the room, it should print these out as well. 
	//Note that you are welcome to print the exits on separate lines (one line says, 
	//"There is an exit to the north", the next line says, "there is an exit to the south", etc.)
	
	void printDescription(){
		
		System.out.println("\n");

		//sound
		
		System.out.println("\033[30mYou are in a " + getDescription());
		if (roomToNorth != null){
			System.out.println("\033[30mThere is an exit to the north");
		}
		
		if (roomToSouth != null){
			System.out.println("\033[30mThere is an exit to the south");
		}
		if (roomToEast != null){
			System.out.println("\033[30mThere is an exit to the east");
		}
		if (roomToWest != null){
			System.out.println("\033[30mThere is an exit to the west");
		}
		if (getWeapon() != null){
			System.out.println("There is a " +  getWeapon().getnameOfWeapon()
			+ " with " + getWeapon().getdamageModifier() + " damage");
		}
		if (getMonster() != null){
			System.out.println("\033[30mThere is a monster with " + getMonster().gethitPoints() + " hp");
		}
	}
	
	
//Room enterRoom(Creature player): This method is called when the player enters a room, 
	//and handles all user input and actions until the player leaves that room 
	//(at which point enterRoom() returns a reference to the Room object that the player enters next) 
	//or quits (at which point enterRoom() returns null). The method should first call printDescription() 
	//to describe the room to the user, then enter a while loop that repeatedly:
	
	Room enterRoom(Creature player){
		
		printDescription();
	
	// 1. Calls Parser.parse() to process the next line from the keyboard.
	
		while(true){
			int result = Parser.parse();
//		JavaAudioPlaySoundExample.getSound("/Users/kyla/Java/bleep_1.au");
	// 2. Uses an if statement on the result of parse() to run the appropriate code for the action that 
	//the user typed. Note that these values are all defined in the Parser class, so you need to call 
	//them Parser.NORTH instead of NORTH.
		//Parser.NORTH: Check to see if the roomToNorth field is null. If so, print 
		//"There is no exit to the north". Otherwise, print "You walk to the north" and 
		//return roomToNorth as the return value from this method. Note that you are not 
		//returning a new Room object -- you are returning the value of the roomToNorth.
		//Similarly for Parser.EAST, Parser.SOUTH, and Parser.WEST.
		
		if ( result == Parser.NORTH && roomToNorth != null ){
				System.out.println("You walk to the North");
				return roomToNorth;	
		}
				
		else if ( result == Parser.SOUTH && roomToSouth != null ){
				System.out.println("You walk to the south");
				return roomToSouth;	
		}
		
		else if ( result == Parser.EAST && roomToEast != null ){
				System.out.println("You walk to the East");
				return roomToEast;	
		}
				
		else if ( result == Parser.WEST && roomToWest != null ){
				System.out.println("You walk to the West");
				return roomToWest;	
		}
		
		else if (result == Parser.NORTH && roomToNorth == null ||
				result == Parser.SOUTH && roomToSouth == null ||
				result == Parser.EAST && roomToEast == null ||
				result == Parser.WEST && roomToWest == null)
				{
					System.out.println("No room in that direction");
				}
			
		//Parser.LOOK: calls printDescription() to describe the room again.
		
		else if ( result == Parser.LOOK ){
				printDescription();
		}
		
		
		//Parser.GET: Check to see if the item field is null. If so, print "There is nothing to get". Otherwise:
			//If the player does not already have a weapon (i.e., player.getWeapon.getName() 
			//is "bare hands"), then set the player.weapon field to the weapon in this room, and set the 
			//weapon in this room to null. Print a message like "You pick up the <weapon name>". 
			//Note that when a monster is initially created, it has a default weapon ("bare hands") created.
			//If the player is already holding a weapon (other than the default "bare hands" weapon) 
			//then the player should "drop" it first (i.e., swap the reference stored in player.weapon 
			//with that stored in this.weapon and print out an appropriate message). In other words, 
			//the this.weapon field should be set to the contents of player.weapon, and vice-versa. 
			//You will need to use a temporary Weapon variable to perform this swap.
			
		if ( result == Parser.GET ){
			if (item == null){
				System.out.println("There is nothing to get");
			}
			else if (player.getWeaponObject() == "bare hands"){
				player.setWeaponObject(item);
				System.out.println("You picked up the " + player.getWeaponObject());
				setWeapon(null);
			}
			else if (player.getWeaponObject() != null){
				player.setWeaponObject(item);
				System.out.println("You picked up the " + player.getWeaponObject());
				setWeapon(null);
			}
		}
				
											

		//Parser.ATTACK: Check to see if the monster field is null. If so, print 
			//"There is nothing to attack". Otherwise, have the player try to attack the 
			//monster using the various methods in the Creature class (e.g., tryToAttack(), takeDamage(), 
			//constructHitString(), etc.) -- see the CombatSimulation.java from HW J6 for an 
			//example of how to do this.. Whether or not the attack succeeds in causing damage, 

			//set the monster's Angry field to true to indicate that the monster will now attack the player. 
			//If the monster is no longer alive after the attack, print a message to indicate that the 
			//player is victorious and set the monster field to null.
			
		if ( result == Parser.ATTACK ){
			if (monster == null){
				System.out.println("There is nothing to attack");
			}
			
			
			else if (monster != null){
				if (monster.isAlive() && player.isAlive()){
					
					
					if (player.tryToAttack(monster.getarmorClass())== true){
						monster.takeDamage(player.calcHitDamage());
						System.out.println(player.constructHitString(monster));
//						System.out.println("Monster HP: " + monster.gethitPoints());
//						System.out.println("Player HP: " + player.gethitPoints());
						monster.setAngry(true);
					}//end if
					else {
						System.out.println(player.constructMissString(monster));
//						System.out.println("Monster HP: " + monster.gethitPoints());
//						System.out.println("Player HP: " + player.gethitPoints());
						monster.setAngry(true);
					}//end else
					if (monster.getAngry() == true){
						if (monster.tryToAttack(player.getarmorClass()) == true){
							player.takeDamage(monster.calcHitDamage());
							System.out.println(monster.constructHitString(player));
//							System.out.println("Monster HP: " + monster.gethitPoints());
//							System.out.println("Player HP: " + player.gethitPoints());
							monster.setAngry(false);
						}//end if
						else {
							System.out.println(monster.constructMissString(player));
//							System.out.println("Monster HP: " + monster.gethitPoints());
//							System.out.println("Player HP: " + player.gethitPoints());
							monster.setAngry(false);
						}//end else
					}//end if monster get angry
				}//end if monster alive and player alive
				if (player.isAlive() == false){
						System.out.println("You died");
						return null;
				}//end if	
				else if (monster.isAlive() == false){
						System.out.println("\n" + monster.getname() + " is dead");
						setMonster(null);
						printDescription();
				}//end else if
		    }//end monster != null
		}//end if result == parser.attack
				

//Parser.QUIT: return null from the enterRoom() method.
		
		else if ( result == Parser.QUIT ){
				return null;
		}
		else if ( result == Parser.DO_NOT_UNDERSTAND ){
				System.out.println ("You entered an unknown command");
		}
		
//			else{
//				System.out.println ("Your parse() method returned an invalid value.\nTHIS IS A BUG IN YOUR PROGRAM.");
//			}


	

	}//end while loop
	}//end enter class
	
	
	
}//end class