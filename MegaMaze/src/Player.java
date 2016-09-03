import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import java.util.Random;
import java.awt.Rectangle;
	
public class Player {

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


	
	
	private String player = "knight.jpg";

	private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;

    public Player() {
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
  		
        ImageIcon ii = new ImageIcon(this.getClass().getResource(player));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = 5;
        y = 5;
    }

  	public Player(int hp, int str, int skl, int ac, String n, String t, String pn){
  		hitPoints = hp;
  		strength = str;
  		skill = skl;
  		armorClass = ac;
  		name = n;
  		type = t;
  		pronoun = pn;
  		weaponObject = new Weapon();
  		ImageIcon ii = new ImageIcon(this.getClass().getResource(player));
  		image = ii.getImage();
        width = 50;
        height = 48;
        visible = true;
        x = 5;
        y = 5;
        dy=0;
        dx=0;
  	}

	  	
	  	
/*	  	public Player(int hp, int str, int skl, int ac, String t){
	  		hitPoints = hp;
	  		strength = str;
	  		skill = skl;
	  		armorClass = ac;
	  		name = "no name";
	  		type = t;
	  		pronoun = "no name";
	  		weaponObject = new Weapon();
	  		ImageIcon ii = new ImageIcon(this.getClass().getResource(player));
	  		image = ii.getImage();
	        width = image.getWidth(null);
	        height = image.getHeight(null);
	        visible = true;
	        x = 5;
	        y = 5;
	  	}
*/
	  	
	  	public int getCurrentX(){
	  		return x;
	  	}
	  	public int getCurrentY(){
	  		return y;
	  	}
	  	
	  	
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
	  	
	  	
	  	public void setarmorClass(int AC){
	  		armorClass = AC;
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
	  	
	  public String getPlayerInfo(Player player){
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
	    
	    
	    
	    public void move() {
	    	x += getdx();
	        y += getdy();

	        if (x < 1) {
	            x = 1;
	        }

	        if (y < 1) {
	            y = 1;
	        }
	        if ((x+width) > 500){
	        	x = 500-width;
	        }
	        if ((y+height) > 500){
	        	y = 500-height;
	        }
	    }
	    public void setdx(int setdx){
	    	dx = setdx;
	    }
	    public int getdx(){
	    	return dx;
	    }
	    
	   public void setdy(int setdy){
		   dy = setdy;
	   }
	   public int getdy(){
		   return dy;
	   }

	   public void setX(int setx){
		   x = setx;
	   }
	   public int getX() {
	        return x;
	    }
	   public void setY(int sety){
		   y = sety;
	   }
	    public int getY() {
	        return y;
	    }

	    public Image getImage() {
	        return image;
	    }
	    
	    public void setVisible(boolean visible) {
	        this.visible = visible;
	    }

	    public boolean isVisible() {
	        return visible;
	    }

	    public Rectangle getBounds() {
	        return new Rectangle(x, y, width, height);
	    }


	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            dx = -2;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 2;
	        }

	        if (key == KeyEvent.VK_UP) {
	            dy = -2;
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            dy = 2;
	        }
	    }

	    public void keyReleased(KeyEvent e) {
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_UP) {
	            dy = 0;
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            dy = 0;
	        }
	    }
	}
