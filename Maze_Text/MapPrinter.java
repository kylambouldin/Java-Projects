public class MapPrinter {
		
	private static String mapOutline = "";
		
    static void printSimpleMap(Map map, Room theRoom) {
    	
    	Room currentLocation = theRoom;
    	int x = 0; //rows
		int y = 0; // cols
		
		while (x < map.getHeight()){
			while (y < map.getWidth()){
				if (map.getRoom(x,y) == theRoom){
					System.out.print("X");
					y++;
				}
				else if (map.getRoom(x,y).getWeapon() != null && map.getRoom(x,y).getMonster() != null){
					System.out.print("B");
					y++;
				}
				else if (map.getRoom(x,y).getWeapon() != null){
					System.out.print("W");
					y++;
				}
				else if(map.getRoom(x,y).getMonster() != null){
					System.out.print("M");
					y++;
				}
				else{
					System.out.print(" ");
					y++;
				}
			}//end second while
			System.out.print("\n");
			x++;
			y = 0;
		}//end first while
		
    }//end printSimpleMap
    
    //printSimpleMap (Map map, Room theRoom):
//	‚ñ™	This method should go through the entire Map, and print out a single character for each room. 
	//The following characters should be printed:
//	‚ñ™	'X' for the current location of the player. This location is specified by the second parameter 
	//(theRoom). Note that the Room class now has a getCol() method, which returns the numerical column 
	//of the Room within the map, and similarly a getRow() method. Thus, to see if you are in the current 
	//room where the character is, you compare the current row with getRow(), and the current column with 
	//getCol().
//	‚ñ™	'W' if there is a weapon in this room, but no monster. You will want to use the getItem()
	//method from the Room class, which returns null if there is no item present.
//	‚ñ™	'M' (for monster) if there is a creature in this room, but no weapon. You will want to use 
	//the getMonster() method from the Room class, which returns null if there is no creature present.
//	‚ñ™	'B' if there is both a creature and a weapon in the room
//	‚ñ™	' ' (space) if there is neither a weapon nor a creature in the room. You may also want to 
	//use a lower case 'o' for an empty room as well, as this may be easier to read.
//How to start: Your printSimpleMap() method will need nested for loops.
//	1.	Write a for loop that iterates (traverses) through a row (0 up to height)
	//	1.	Write a for loop that traverses through a column (0 up to width)
		
		
		//	1.	Inside the inner for loop, print out the specific character via the System.out.print() 
		//method (as all the rooms in a given row need to be on the same line). To do this, you must have 
		//several if statements to check the various conditions of the room. 
		//e.g. if (rooms[r][c].getWeapon()¬†!= null)
	//	2.	After you go through all the columns of a single row, you move to the next line via 
		//the System.out.println() method.

    static void printMap(Map map, Room theRoom) {
    	    	Room currentLocation = theRoom;
    	int x = 0; //rows
		int y = 0; // cols
		
		while (x < map.getHeight()){
			while (y < map.getWidth()){
				if (map.getRoom(x,y) == theRoom){
					if (map.getRoom(x,y).getRoomToEast() != null){
						System.out.print("\033[34mX-"); //blue
					}
					else{
						System.out.print("\033[34mX\033[30m|");
					}
					y++;
				}
				else if (map.getRoom(x,y).getWeapon() != null && map.getRoom(x,y).getMonster() != null){
					if (map.getRoom(x,y).getRoomToEast() != null){
						System.out.print("\033[35mB-");
					}
					else{
						System.out.print("\033[35mB\033[30m|");
					}
					y++;
				}
				else if (map.getRoom(x,y).getWeapon() != null){
					if (map.getRoom(x,y).getRoomToEast() != null){
						System.out.print("\033[32mW-");
					}
					else{
						System.out.print("\033[32mW\033[30m|");
					}
					y++;
				}
				else if(map.getRoom(x,y).getMonster() != null){
					if (map.getRoom(x,y).getRoomToEast() != null){
						System.out.print("\033[31mM-");
					}
					else{
						System.out.print("\033[31mM\033[30m|");
					}
					y++;
				}
				else{
					if (map.getRoom(x,y).getRoomToEast() != null){
						System.out.print("\033[30mo-");
					}
					else{
						System.out.print("\033[30mo\033[30m|");
					}
					y++;
				}
			}//end second while
			
			System.out.print("\n");
			int r = x;
			int c = 0;
				while (r < map.getHeight()){
					while (c < map.getWidth()){
						if (map.getRoom(r,c).getRoomToSouth() != null){
							System.out.print("\033[30m| ");
							c++;
						}
						else{
							System.out.print("\033[30m  ");
							c++;
						}
					}//end 2nd while
					r = map.getHeight();
					c=0;
				}//end 1st while
			System.out.print("\n");
			x++;
			y = 0;
		}//end first while
    }//end printMap
    	
//printMap (Map map, Room theRoom):
//	‚ñ™	The printSimpleMap() method is useful, but it does not tell us which rooms are connected 
	//to each other. In particular, from any given room, you can not necessarily go between them,
	//as there may not be doors present. Thus, we are going to enhance our printSimpleMap() method 
	//to add door information.
//	‚ñ™	To print a more detailed map, you will print lines that connect the rooms. 
	//If there is a doorway between two rooms next to each other (i.e. a east-west doorway), 
	//then we will print a '-' (dash) between the rooms. If there is a doorway between two rooms 
	//on top of each other (i.e. a north-south doorway), then we will print a '|' (vertical bar) 
	//between those two rooms.
	
//	‚ñ™	Copy-and-paste the code from your printSimpleMap() to your printMap() method

//	‚ñ™	To print the dashes for the east-west doors, you will want to use the getRoomToEast() 
	//method, which will return null if there is no doorway present. We are assuming that if 
	//there is a doorway going one way, then there is a doorway going the other way. Thus, 
	//after printing the character for each room, you will either print a space 
	//(if there is no doorway) or a dash (if there is a doorway). Thus, the code (so far) 
	//is the same as the printSimpleMap() method, with the addition of a character after each room, 
	//depending on whether there is a door to the east of a given room. It will be easiest to 
	//make sure this is working before you continue to the north-south doors.

//To print the north-south doorways, you will most likely need to use the getRoomToSouth() method, 
//which also returns null if there is no doorway present. Again, we are assuming that all doorways 
//go in both directions.
//	‚ñ™	After the for loop that prints out a line of rooms, you will need a separate for loop to 
	//print out a line of spaces (if there is no doorway) or vertical bars (if there is a doorway). 
	//This for loop is still within the outer for loop, but separate from the inner for loop used above.
//	‚ñ™	Note that between each doorway character (space or vertical bar) there is an additional 
	//space (so that it lines up with the east-west doorway). Thus, in this for loop, you either 
	//print out two spaces (if there is no north-south door) or a vertical bar and a space 
	//(if there is a north-south door). The extra space is so that the north-south doors 
	//line up with the rooms above and below (because of the east-west doors, the rooms are 
	//now every other spot).




    private static final int MAZE_HEIGHT = 4;
    private static final int MAZE_WIDTH	= 4;
    private static final int MAZE_PERCENT_WEAPON = 25;
    private static final int MAZE_PERCENT_MONSTER = 25;
    private static final int RANDOM_SEED = 3;

    public static void main (String args[]) {
		Map maze = new Map(MAZE_HEIGHT, MAZE_WIDTH, RANDOM_SEED);
		maze.populate(MAZE_PERCENT_WEAPON, MAZE_PERCENT_MONSTER);
		maze.generateMaze();
	
//		MapPrinter.printSimpleMap (maze, maze.getRoom(0,0));
		System.out.println();
		MapPrinter.printMap (maze, maze.getRoom(0,0));
    }

}
