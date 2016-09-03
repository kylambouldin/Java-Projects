import java.util.*;

public class Map {

    private Room[][] rooms;
    private boolean[][] visited;
    private int maxMonsterStrength = 20;//accessor and mutator methods
    private int maxMonsterSkill = 20;//accessor and mutator methods
    private int maxMonsterHitPoints = 20;//accessor and mutator methods
    private int maxMonsterArmorClass = 20;//accessor and mutator methods
    
    
    private int height; //you should provide an accessor (i.e. getHeight()) but no mutator.
    private int row;
    private int x;// rows/height
    
    
    private int width; //accessor but not a mutator.
    private int col;
	private int y;// cols/width
    
    private int maxWeaponDamageMod = 5;//accessor and mutator methods
    
   	private Descriptions desc = new Descriptions(); //this object will be used in the constructor, 
   		//below. Note that it should not be static.
   		
	private Random rand = new Random(); //this will be used to generate random numbers throughout 
		//the Map class code.
	
//Map(int rows, int cols): a specific constructor that should create the rooms[][] array 
	//with the specified number of rows and columns
	//then generate a Room object for each slot in the two-dimensional array. 
	
	//The Room should be created using the constructor that takes in a single String parameter. 
	//For this parameter, you should generate a random description, using your desc object, 
	//of the form "<adjective> <room type>". 
	
	//After each room is created, its row and column should be set to its i and j indices 
	//using setRowCol(). Also, the visited array should be initialized to the same size as 
	//the rooms array, with each value set to false, and the width and height fields should 
	//be updated appropriately.
	
	public Map(){
		maxMonsterStrength = 20;
    	maxMonsterSkill = 20;
   		maxMonsterHitPoints = 20;
   		maxMonsterArmorClass = 20;
   		maxWeaponDamageMod = 5;
	}
	
	public Map(int rows, int cols){
		height = rows;
		width = cols;
		x = 0; //rows
		y = 0; // cols
		rooms = new Room[rows][cols];
		while (x < height){
			while (y < width){
				//public Room(String desc, int row, int collum){
				rooms[x][y] = new Room((desc.getNextRoomAdjective() + " " + desc.getNextRoomType()), x, y);
//				System.out.println("x = " + x);
//				System.out.println("y = " + y);
//				System.out.println(rooms[x][y].getDescription());
//				System.out.println(rooms[x][y]);
				y++;
//				System.out.println(getRoom(x,y) + "\n");
			}
			x++;
			y = 0;
		}
		visited = new boolean[rows][cols];
		//After each room is created, its row and column should be set to its i and j 
		//indices using setRowCol(). Also, the visited array should be initialized to the
		//same size as the rooms array, with each value set to false, and the width and 
		//height fields should be updated appropriately.
	}
	
	
//Map(int rows, int cols, int seed): this specific constructor works the exact same as the 
	//previous one, with the one addition that the rand instance variable is initialized to
	//a new Random object with the passed seed as the parameter to the Random constructor. 
	//This will ensure that when this constructor is called, the exact same map is produced 
	//for each value of seed.
	
	
	public Map(int rows, int cols, int seed){
		height = rows;
		width = cols;
		x = 0; //rows
		y = 0; // cols
		rooms = new Room[rows][cols];
		while (x < height){
			while (y < width){
				rooms[x][y] = new Room(desc.getNextRoomAdjective() + " " + desc.getNextRoomType(), x, y);
				y++;
			}
			x++;
			y = 0;
		}
		visited = new boolean[rows][cols];
		
		rand = new Random(seed);
	}
	
	
	
//create accessor and mutator methods for each attribute.	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	
	//private int maxMonsterStrength = 20;//accessor and mutator methods
    //private int maxMonsterSkill = 20;//accessor and mutator methods
    //private int maxMonsterHitPoints = 20;//accessor and mutator methods
    //private int maxMonsterArmorClass = 20;//accessor and mutator methods
    //private int maxWeaponDamageMod = 5;//accessor and mutator methods
    
    public void setMaxMonsterStrength(int MMS){
		maxMonsterStrength = MMS;
	}
	public int getMaxMonsterStrength(){
		return maxMonsterStrength;
	}
	
	
	    public void setMaxMonsterSkill(int MMS){
		maxMonsterSkill = MMS;
	}
	public int getMaxMonsterSkill(){
		return maxMonsterSkill;
	}
	
	
	    public void setMaxMonsterHitPoints(int MMHP){
		maxMonsterHitPoints = MMHP;
	}
	public int getMaxMonsterHitPoints(){
		return maxMonsterHitPoints;
	}
	
	
	    public void setMaxMonsterArmorClass(int MMAC){
		maxMonsterArmorClass = MMAC;
	}
	public int getMaxMonsterArmorClass(){
		return maxMonsterArmorClass;
	}
	
	
	    public void setMaxWeaponDamageMod(int MWDM){
		maxWeaponDamageMod = MWDM;
	}
	public int getMaxWeaponDamageMod(){
		return maxWeaponDamageMod;
	}
	
	

    public Vector<Room> getUnvisitedNeighbors (Room room) {
		Vector<Room> v = new Vector<Room>();
		int x = room.getRow();
		int y = room.getCol();
		if ( isValidRoom(x-1,y) && !visited[x-1][y] )
		    v.add (rooms[x-1][y]);
		if ( isValidRoom(x,y-1) && !visited[x][y-1] )
		    v.add (rooms[x][y-1]);
		if ( isValidRoom(x+1,y) && !visited[x+1][y] )
		    v.add (rooms[x+1][y]);
		if ( isValidRoom(x,y+1) && !visited[x][y+1] )
		    v.add (rooms[x][y+1]);
		return v;
    }

    public static boolean connectRooms (Room r1, Room r2) {
		// this variable will hold true or false if this method connected
		// two adjacent rooms
		boolean didARoomConnection = false;
		if ( (r1.getRow() == r2.getRow()+1) &&
		     (r1.getCol() == r2.getCol()) ) {
		    // r1 is south of r2
		    r1.setRoomToNorth(r2);
		    r2.setRoomToSouth(r1);
		    didARoomConnection = true;
		} else if ( (r1.getRow() == r2.getRow()-1) &&
			    (r1.getCol() == r2.getCol()) ) {
		    // r1 is north of r2
		    r2.setRoomToNorth(r1);
		    r1.setRoomToSouth(r2);
		    didARoomConnection = true;
		} else if ( (r1.getRow() == r2.getRow()) &&
			    (r1.getCol() == r2.getCol()+1) ) {
		    // r1 is east of r2
		    r2.setRoomToEast(r1);
		    r1.setRoomToWest(r2);
		    didARoomConnection = true;
		} else if ( (r1.getRow() == r2.getRow()) &&
			    (r1.getCol() == r2.getCol()-1) ) {
		    // r1 is east of r2
		    r1.setRoomToEast(r2);
		    r2.setRoomToWest(r1);
		    didARoomConnection = true;
		}
		return didARoomConnection;
    }

	void connectAllRooms() {
		for ( int c1 = 0; c1 < width; c1++ ){
			for ( int c2 = 0; c2 < width; c2++ ){
				for ( int r1 = 0; r1 < height; r1++ ){
					for ( int r2 = 0; r2 < height; r2++ ){
						connectRooms (getRoom(c1,r1), getRoom(c2,r2));
					}
				}
			}
		}
	}

	boolean isValidRoom (int x1, int y1) {
//		System.out.println("Height: " + getHeight());
//		System.out.println("Width: " + getWidth());
		if (x1 >= 0 && y1 >= 0 && x1+1 <= height && y1+1 <= width){
			return true;
		}
		else{
			return false;
		}
    }
    
//Room getRoom(int r, int c): returns the Room reference stored in array slot rooms[r][c], 
//or null if the user passes invalid values for r and c.
    Room getRoom (int x, int y) {
    	if (isValidRoom(x, y) == true){
    		return rooms[x][y];
    	}
    	else{
	    	return null;
	    }
    }
    
    //setCurrentRoom(maze.getRoom(1,1));
    
    
//boolean allMonstersDead(): this method searches the entire Map, and returns true if 
//there are no more monsters left (remember that if a monster is dead, then the getMonster() 
//method for that Room will return null). If there is one or more monsters in the Map, 
//then this method returns false.
    boolean allMonstersDead(){
    	x = 0;
    	y = 0;
    	int numberOfMonsters = 0;
    	while (x < height){
			while (y < width){
				if (rooms[x][y].getMonster() != null){ //if there is a monster
					numberOfMonsters += 1;
				}
				y++;
			}
			x++;
			y = 0;
		}
		if (numberOfMonsters > 0){
			return false;
		}
		else if (numberOfMonsters == 0){
			return true;
		}
		else{
			return false;
		}
    }//end allMonstersDead()
    
    
    ////maze.allMonstersDead() == false
    
//void populate(int percentWeapon, int percentMonster): visits each of the rooms and 
//generates a random integer between 0 and 100 using the Random.nextInt() method. 

//If the resulting random number is less than the specified percentWeapon parameter, 
//a random Weapon is created and assigned to the room using the Room.setItem() method. 

//A second random number is generated and tested similarly to decide whether to create 
//a random Monster object according to the percentMonster probability.

	//To create the random monster and/or random creature, you will need to use random 
	//numbers between 0 and the values stored in the instance variables. For example, 
	//the number of hit points for a randomly generated monster is a number between 1 and 
	//maxMonsterHitPoints, which you can generate by calling 1+rand.nextInt(maxMonsterHitPoints). 
	//The reason for adding 1 is so that you don't get a skill (or armor class, etc.) of 0, 
	//as that can cause other parts of your code to have issues. Recall from HW J6 the specific 
	//constructor for the Creature class: Creature(int hp, int str, int skl, int ac, String name, 
	//String type, String pronoun). Each of the first four values (hp, str, skl, ac) are 
	//random numbers between 0 and the maximum value stored in the appropriate instance variable 
	//(maxMonsterHitPoints, maxMonsterStrength, maxMonsterSkill, and maxMonsterArmorClass, 
	//respectively). name can be anything (all your monsters can be named Fred, for example), 
	//type is a the random creature type from the desc.getNextMonsterName() method, and pronoun 
	//can just be "its".    
    
void populate(int percentWeapon, int percentMonster){
	int x = 0;
	int y = 0;
	while (x < height){
		while (y < width){
			int randNum = rand.nextInt(100);
			int randNum2 = rand.nextInt(100);

			if (randNum < percentWeapon){
				rooms[x][y].setWeapon(new Weapon(1+rand.nextInt(getMaxWeaponDamageMod()), desc.getNextWeaponName()));
			}
			else if (randNum > percentWeapon){
				rooms[x][y].setWeapon(null);
			}
			if (randNum2 < percentMonster){
				rooms[x][y].setMonster(new Creature(1+rand.nextInt(getMaxMonsterStrength()), 
				1+rand.nextInt(getMaxMonsterSkill()), 1+rand.nextInt(getMaxMonsterHitPoints()),
				1+rand.nextInt(getMaxMonsterArmorClass()), desc.getNextMonsterName(), 
				desc.getNextMonsterType(), desc.getNextPronoun()));
			}	
			
			else if (randNum2 > percentMonster){
				rooms[x][y].setMonster(null);
			}
			else{
				rooms[x][y].setWeapon(null);
				rooms[x][y].setMonster(null);
			}
			y++;
		
		}
		x++;
		y = 0;
	}
			
}

//void generateMaze(): constructs a maze by connecting the rooms in the rooms[][] array 
//using a simple algorithm. Described in English, the basic idea of the algorithm is to 
//visit each of the rooms in the array, connect the room to a random neighbor, then visit 
//that neighbor and repeat, connecting to one of its neighbors, and so on. However, the 
//algorithm does not allow connecting a room to a neighbor that has already been visited. 
//If the algorithm gets "stuck", meaning that all of the neighbors of the current room have 
//been visited, then it backtracks to the previously visited room. This notion of backtracking 
//is implemented using a Vector: as each room is visited, it is added to end of the Vector, 
//when the current room has no more valid neighbors, it is removed from the end of the Vector 
//and the room which is now at the end of the (now shorter) Vector becomes the current room.


//Create a Vector variable named v
//Add the Room object at rooms[0][0] to v.
//Mark this room as visited by setting visited[0][0] to true.
//While the vector is not empty (i.e., while (v.size() > 0)), do the following:
	//Set a local variable currentRoom to the Room at the end of the vector 
	//(i.e., Room currentRoom = (Room) v.get(v.size()-1))
	//Check whether currentRoom has any valid neighbors that are not yet visited. 
	//A room [r][c] is not visited if visited[r][c] == false.	
	//If there are still valid neighbors that are not yet visited:
		//Randomly choose one of those neighbors (repeatedly pick a neighbor at random until 
		//the chosen neighbor is valid and not visited). Let us call the chosen neighbor N. 
		//This is done as described in the getUnvisitedNeighbors() method, above.
		
		//Connect currentRoom to N by calling the appropriate method to add an exit from 
		//currentRoom to N (for example, currentRoom.setRoomToEast(N), if the neighbor to the 
		//east was chosen as N) .
		//Also connect N to currentRoom (for example, N.setRoomToWest(currentRoom)).
		
		//Add N to the vector v (i.e., v.add(N)). Note that this means that the next time through
		//the loop, N will become the new currentRoom.
		
		//Update the visited array appropriately: the location in the visited array that 
		//corresponds to the location of the new room N should be set to true.
		
	//Otherwise (all valid neighbors have been visited), remove the room at the 
	//end of the vector (i.e., v.remove(v.size()-1)). Note that this means that the next 
	//time through the loop, currentRoom will be set to a previous value
	//-- this is how we implement the "backtracking" discussed above

void generateMaze(){ 
	Vector<Room> v = new Vector<Room>();
	v.add (rooms[0][0]);
	visited[0][0] = (true);
	
	while (v.size() > 0){
		Room currentRoom = (Room)v.get(v.size()-1);
		Vector<Room> unvNeigh = getUnvisitedNeighbors(currentRoom);
		
//		System.out.println("v: " + v.size());
//		System.out.println("unvNeigh: " + unvNeigh.size());
		
		if (unvNeigh.size() != 0){
			int r = rand.nextInt(unvNeigh.size());
			Room temp = (Room)unvNeigh.get(r);
			
			
//			System.out.println("CR: " + currentRoom.getRow() + "," + currentRoom.getCol());
			for (int e = 0; e <= unvNeigh.size()-1; e++){
//				Room G = (Room)unvNeigh.get(e);
//				System.out.println("UVR:" + G.getRow() + "," + G.getCol());
			}
			
//			System.out.println("R: " + r);
//			Room W = (Room)unvNeigh.get(r);
//			System.out.println("Temp: " + W.getRow()+ "," + W.getCol());
		
			while (visited[temp.getRow()][temp.getCol()] == false) {
				
				Room N = (Room)unvNeigh.get(r);
				
				if (currentRoom.getCol() < N.getCol()){
				
					currentRoom.setRoomToEast(N);
					N.setRoomToWest(currentRoom);
					v.add(N);
					
					visited[temp.getRow()][temp.getCol()] = true;
				}
				else if (currentRoom.getCol() > N.getCol()){
					currentRoom.setRoomToWest(N);
					N.setRoomToEast(currentRoom);
					v.add(N);
					
					visited[temp.getRow()][temp.getCol()] = true;
				}
				else if (currentRoom.getRow() < N.getRow()){
					currentRoom.setRoomToSouth(N);
					N.setRoomToNorth(currentRoom);
					v.add(N);
				
					visited[temp.getRow()][temp.getCol()] = true;
				}
				
				else if (currentRoom.getRow() > N.getRow()){
					currentRoom.setRoomToNorth(N);
					N.setRoomToSouth(currentRoom);
					v.add(N);
				
					visited[temp.getRow()][temp.getCol()] = true;
				}
			
			}			
		}//end if

		else if (unvNeigh.size() == 0 && v.size() <= getHeight() * getWidth()){
			v.remove(v.size()-1);
		}
	}//end while

}//end generateMaze()
    

}//end class
