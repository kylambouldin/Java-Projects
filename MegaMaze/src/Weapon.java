//damage modifier(int): an integer added to the damage inflicted when the creature scores a hit.
//name(String): the name of the weapon
//hit verb(String): a verb to describe the action of the weapon when it scores a hit
//miss verb(String): a verb to describe the action of the weapon when it misses

public class Weapon{
	private int damageModifier;
	private String nameOfWeapon;
	private String hitVerb;
	private String missVerb;
	private int weaponID;

//Weapon(): the default constructor should initialize the damage modifier to 0, 
	//the name to "bare hands", the hit verb to "strikes" and the miss verb to "misses".
//Weapon(int modifier, String name, String hit, String miss): this specific constructor 
	//should initialize all the attributes to the specified values.
	
	public Weapon(){
		damageModifier = 0;
		nameOfWeapon = "bare hands";
		hitVerb = "strikes";
		missVerb = "misses";
		
	}
	
		public Weapon(int DM, String NOW){
		damageModifier = DM;
		nameOfWeapon = NOW;
		hitVerb = "strikes";
		missVerb = "misses";
	}
	
	public Weapon(int DM, String NOW, String HV, String MV){
		damageModifier = DM;
		nameOfWeapon = NOW;
		hitVerb = HV;
		missVerb = MV;
	}
	
//Accessors/Mutators:
//All the attributes are declared private, so you should create accessor and mutator 
	//methods for each attribute. The name of the accessor/mutator should follow the standard 
	//Java naming conventions (i.e. getHitPoints(), setDamageModifier(), getName(), etc.).
		
	
	public void setWeaponID(int number){
		weaponID = number;
	}
	public int getWeaponID(){
		return weaponID;
	}
	public void setdamageModifier(int DM){
		damageModifier = DM;
	}
	public int getdamageModifier(){
		return damageModifier;
	}
	
	
	
	public void setnameOfWeapon(String NOW){
		nameOfWeapon = NOW;
	}
	public String getnameOfWeapon(){
		return nameOfWeapon;
	}
	
	
	
	public void sethitVerb(String HV){
		hitVerb = HV;
	}
	public String gethitVerb(){
		return hitVerb;
	}
	
	
	
	public void setmissVerb(String MV){
		missVerb = MV;
	}
	public String getmissVerb(){
		return missVerb;
	}
	
	public String getFullName() 
{
	String modifier = "";
	if ( damageModifier < 0 )
		modifier = "cursed";
	else if ( damageModifier < 3 )
		modifier = "normal";
	else if ( damageModifier < 6 )
		modifier = "shiny";
	else if ( damageModifier < 9 )
		modifier = "high quality";
	else if ( damageModifier < 12 )
		modifier = "elite";
	else
		modifier = "magical";
	return modifier + " " + getnameOfWeapon();
}
	
	
}
	
	
	
	
	