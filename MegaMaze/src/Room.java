public class Room{
	Room roomToNorth = null;
	Room roomToEast = null;
	Room roomToSouth = null;
	Room roomToWest = null;
	String description = "A nondescript room";
	Creature monster = null;
	Weapon item = null;
	int x = 0;
	int y = 0;
		
	public Room() {
	}
	
	public Room(String desc){
		description = desc;
	}
	
	public Room(String desc, int row, int collum){
		description = desc;
		x = row;
		y = collum;
	}
	
	public Room(String desc, Creature occupant, Weapon weap){
		description = desc;
		monster = occupant;
		item = weap;
	}
	
//get/set pairs of accessor/mutator methods for all the attributes.	


	public void setRow(int row){
		x = row;
	}
	public int getRow(){
		return x;
	}
	
	public void setCol(int collum){
		y= collum;
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

}//end class