import java.util.Random;

//hit points (int): the amount of damage a creature can take before it dies. 
	//A creature's hit points are reduced when an opponent scores a hit: 
	//when the warrior successfully attacks the monster, it decreases the monster's 
	//hit points, and if the monster takes a bite out of the warrior, 
	//the warrior's hit points go down. If hit points reach or drops below zero, 
	//the creature dies.
//strength (int): the maximum damage a creature can inflict. 
	//The strength represents the maximum number of hit points that will be deducted 
	//from the opponent if the creature scores a hit.
//skill (int): the likelihood of a creature scoring a hit. 
	//This is an integer between 0 and 25. The higher the skill, 
	//the more likely the creature is to score a hit.
//armor class (int): the armor class or AC of a creature represents how hard it 
	//is to damage. It is an integer between 0 and 20. The higher the AC, 
	//the less likely an opponent is to score a hit.
//name (String): the name of the creature (e.g., "Frodo" or "Aaron Bloomfield").
//type (String): a word or phrase describing the race or class of the creature 
	//(e.g., "hobbit" or "mighty warrior").
//pronoun (String): the appropriate possessive pronoun to use for this creature 
	//(e.g., "his", "her", "its").
//weapon (Weapon): a reference to the Weapon object wielded by the creature.

public class Creature{
	private int hitPoints;
	private int strength;
	private int skill;
	private int armorClass;
	private String name;
	private String type;
	private String pronoun;
	private Weapon weaponObject;
	private boolean isAlive;
	private boolean angry;
	private boolean tryToAttack;
	private int calcHitDamage;
	private String HitString;
	private String HitString2;
	private String infoString;


//The Creature class should have the following methods:
//Constructors: Creature(): the default constructor should initialize hit points to 50,
//strength to 15, skill to 15, armor class to 5, name to "Somebody", type to "nondescript 
//creature", pronoun to "its", and weapon to a new Weapon 
//created with the Weapon() default constructor.

	public Creature(){
		hitPoints = 50;
		strength = 15;
		skill = 15;
		armorClass = 5;
		name = "Somebody";
		type = "nondescript";
		pronoun = "its";
		weaponObject = new Weapon();
		isAlive = (true);
		tryToAttack = (true);
		calcHitDamage = 0;
		angry = (false);
		HitString = "No name";
		HitString2 = "no name";
	}
	

	
	//Creature(int hp, int str, int skl, int ac, String name, String type, String pronoun): 
//a specific constructor that lets the programmer specify all the attributes of a 
//creature except the weapon, which is still set a new Weapon object created with the 
//Weapon() default constructor.
	public Creature(int hp, int str, int skl, int ac, String n, String t, String pn){
		hitPoints = hp;
		strength = str;
		skill = skl;
		armorClass = ac;
		name = n;
		type = t;
		pronoun = pn;
		weaponObject = new Weapon();
	}
	
//	Creature player = new Creature(WARRIOR_HP, WARRIOR_STR, WARRIOR_SKILL, 
//				       WARRIOR_AC, WARRIOR_NAME, WARRIOR_TYPE, 
//				       WARRIOR_PRONOUN);
	
	
	public Creature(int hp, int str, int skl, int ac, String t){
		hitPoints = hp;
		strength = str;
		skill = skl;
		armorClass = ac;
		name = "no name";
		type = t;
		pronoun = "no name";
		weaponObject = new Weapon();
	}
	

//Accessors/Mutators:
	//All the attributes are declared private, so you should create accessor and 
	//mutator methods for each attribute. The name of the accessor/mutator should 
	//follow the standard Java naming conventions (i.e. getHitPoints(), 
	//setDamageModifier(), getName(), etc.).
	
	public void sethitPoints(int hp){
		hitPoints = hp;
	}
	public int gethitPoints(){
		return hitPoints;
	}
	
	
	
	public void setstrength(int str){
		strength = str;
	}
	public int getstrength(){
		return strength;
	}
	
	

	public void setskill(int skl){
		skill = skl;
	}
	public int getskill(){
		return skill;
	}
	
	
	public void setarmorClass(int armorClass){
		armorClass = armorClass;
	}
	public int getarmorClass(){
		return armorClass;
	}
	
	
	public void setname(String n){
		name = n;
	}
	public String getname(){
		return name;
	}
	
	
	
	public void settype(String t){
		type = t;
	}
	public String gettype(){
		return type;
	}
	
	
	
	public void setpronoun(String p){
		pronoun = p;
	}
	public String getpronoun(){
		return pronoun;
	}
	
	public void setWeaponObject(Weapon newWeapon){
		weaponObject = newWeapon;
		
	}
	public String getWeaponObject(){
		return weaponObject.getnameOfWeapon();
	}
	
	//boolean isAlive(): returns true if the creature is alive 
	//(that is, if its hit points are greater than zero) and false otherwise.
	
	public boolean isAlive(){
		boolean ia;
		if (gethitPoints() > 0){
			 ia = (true);
		}
		else{
			ia = (false);
		}
		return ia;
	}	

//boolean tryToAttack(int targetAC): uses the Random class (see below) to get a random number 
//between 0 and skill, where skill is the skill of the creature. Returns true if the resulting 
//random number is greater than or equal to the targetAC parameter 
//(which represents the opponent's armor class) and false otherwise.
	
	public boolean tryToAttack(int targetAC){
		Random r = new Random();
		int randNum = r.nextInt(getskill());
		if (randNum >= targetAC){
			tryToAttack = (true);
		}
		else{
			tryToAttack = (false);
		}
		return tryToAttack;
	}


//int calcHitDamage(): computes the damage done if the creature scores a hit. 
//This is a function of the creature's strength, adjusted to account for the weapon being wielded 
//(i.e. a sword does more damage than bare hands). 
//Generates a random number between zero and strength (where strength is the strength of the 
//creature) and adjusts it by adding the damage modifier of the weapon being wielded, 
//then returns this adjusted number.

	public int calcHitDamage(){
		Random r = new Random();
		int randint = r.nextInt(getstrength());
		return randint;
	}
	


//void takeDamage(int amount): decrements the creature's hit points by amount.

	public void takeDamage(int amount){
		int current = gethitPoints();
		current -= amount;
		int newamount = current -= amount;
		sethitPoints(newamount);
	}



//warrior.takeDamage(monster.calcHitDamage());


//String constructHitString(Creature opponent): returns a string of the form:
//"<name> the <type> <weapon hit verb> <opponent name> the <opponent type> with <pronoun> 
//<weapon name>". For example, 
//"Frodo the hobbit slashes Aaron Bloomfield the mighty warrior with his sword".

public String constructHitString(Creature opponent){
	HitString =  getname() + " the " + gettype() +  " " + weaponObject.gethitVerb() + " " + opponent.getname() 
	+ " the " + opponent.gettype() + " with " + getpronoun() + " " +  weaponObject.getFullName();
	return HitString;
}

public String constructMissString(Creature opponent){
	HitString2 =  getname() + " the " + gettype() +  " " + weaponObject.getmissVerb() + " " + opponent.getname() 
	+ " the " + opponent.gettype() + " with " + getpronoun() + " " +  weaponObject.getFullName();
	return HitString2;
}


//String constructMissString(Creature opponent): 
//like constructHitString() but using the weapon's miss verb. 
//For example, "Gnash the orc misses Frodo the hobbit with its spear".
	
public String getCreatureInfo(Creature player){
	infoString = "\n Hit Points: " + player.gethitPoints()
		+ "\n Strength: " + player.getstrength()
		+ "\n Skill: " + player.getskill()
		+ "\n Armor Class: "  + player.getarmorClass()
		+ "\n Name: "  + player.getname()
		+ "\n Type: "  + player.gettype()
		+ "\n Pronoun: "  + player.getpronoun()
		+ "\n Weapon: " + player.getWeaponObject();
		return infoString;
}


	
public void setAngry(boolean ga){
		angry = ga;
	}
	public boolean getAngry(){
		return angry;
	}

}


	
	
	
