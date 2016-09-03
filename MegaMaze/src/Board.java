import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

public class Board extends JPanel implements ActionListener {
	
	private Map map;
	private Player player;
	private Room theRoom;
	private Timer timer;
    private boolean ingame;
    private ArrayList<Wall> walls;
    private ArrayList<Pictures> monsters;
    private ArrayList<Pictures> weapons;

    String words = 
		"<html>You walk up to a white house and hear a scream coming from the top floor.<br>" +
    	"It sounds like the princess voice, so you run inside the house.<br>" +
    	"Once you enter, the door slams shut behind you...<br>";
    
    JButton get = new JButton("Get");
    JButton attack = new JButton("Attack");    
    JButton look = new JButton("Look");
    JLabel status = new JLabel(words, SwingConstants.CENTER);
    
	private int MAZE_HEIGHT = 2;
	private int MAZE_WIDTH = 2;
	private final int MAZE_PERCENT_WEAPON	= 25;
    private final int MAZE_PERCENT_MONSTER	= 25;
    private final int MONSTER_MAX_HP		= 50;
    private final int MONSTER_MAX_STR 		= 15;
    private final int MONSTER_MAX_SKILL 	= 10;
    private final int MONSTER_MAX_AC 		= 7;
    private final int WEAPON_MAX_MOD		= 15;
    private  final int WARRIOR_HP 			= 100;
    private  final int WARRIOR_STR 			= 10;
    private  final int WARRIOR_SKILL 		= 15;
    private  final int WARRIOR_AC 			= 5;
    private  final String WARRIOR_NAME 		= "Gnusto Frotz";
    private  final String WARRIOR_TYPE 		= "valiant warrior";
    private  final String WARRIOR_PRONOUN	= "his";
    private boolean princessCaptured = false;

    public Board(){
		addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        ingame = true;
        
    	map = new Map(MAZE_HEIGHT,MAZE_WIDTH);
		map.setMaxMonsterStrength(MONSTER_MAX_STR);
		map.setMaxMonsterSkill(MONSTER_MAX_SKILL);
		map.setMaxMonsterHitPoints(MONSTER_MAX_HP);
		map.setMaxMonsterArmorClass(MONSTER_MAX_AC);
		map.setMaxWeaponDamageMod(WEAPON_MAX_MOD);
		map.populate(MAZE_PERCENT_WEAPON, MAZE_PERCENT_MONSTER);
		map.generateMaze();
		
		player = new Player(WARRIOR_HP, WARRIOR_STR, WARRIOR_SKILL, 
			       WARRIOR_AC, WARRIOR_NAME, WARRIOR_TYPE, 
			       WARRIOR_PRONOUN);
        
		theRoom = null;
		
		
        timer = new Timer(5, this);
        timer.start();
        printTextVersion();
        generateWalls();
        generateButtons();
    }
	
/*	public Board(Map newMap, Player newPlayer){
		addKeyListener(new TAdapter());
		setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        ingame = true;
        timer = new Timer(25, this);
        timer.start();
     
		map = newMap;
		generateWalls();
		theRoom = getRoom();
		player = newPlayer;
		printTextVersion();
		
	}*/
	
	public void newMapLevel(){
		map = new Map(MAZE_HEIGHT,MAZE_WIDTH);
		map.setMaxMonsterStrength(MONSTER_MAX_STR);
		map.setMaxMonsterSkill(MONSTER_MAX_SKILL);
		map.setMaxMonsterHitPoints(MONSTER_MAX_HP);
		map.setMaxMonsterArmorClass(MONSTER_MAX_AC);
		map.setMaxWeaponDamageMod(WEAPON_MAX_MOD);
		map.populate(MAZE_PERCENT_WEAPON, MAZE_PERCENT_MONSTER);
		map.generateMaze();
	}
	
	private void resetGame(){
		words = "<html>You see stairs ahead and run up to the next floor<br>" +
		"<center><strong>~NEXT LEVEL~</strong></center>";
		status.setText(words);
		
		MAZE_HEIGHT ++;
		MAZE_WIDTH ++;
		newMapLevel();
		generateWalls();
	}
	
	private boolean checkGameOver(){
		return map.allMonstersDead();
    
		/*
        else if (map.allMonstersDead() == true && MAZE_HEIGHT == 4){
        	princessCaptured = true;
        }

       if (princessCaptured == true){
    	   	words = ("All monsters are dead!  You go and rescue the princess!\n"+
    			   "Congratulations and goodbye.");
    	   	status.setText(words);
    	}
    	
    	*/
	}

	public void setMap(Map theMap){
    	map = theMap;
    	generateWalls();
	}
    
    public Map getMap(){
		return map;
	}
	
	public void setRoom(Room room){
    	theRoom = room;
    }
    
    public Room getRoom(){
		return theRoom;
	}
    
    public void Look(Room room){
    	words = ("You are in a " + room.getDescription());
    	status.setText(words);
    }
    
    public void Attack(Room room){
    	if (room.getMonster() == null){
		}
		
		else if (room.getMonster() != null){
			if (room.getMonster().isAlive() && player.isAlive()){
				
				if (player.tryToAttack(room.getMonster().getarmorClass())== true){
					room.getMonster().takeDamage(player.calcHitDamage());
					room.getMonster().setAngry(true);
				}//end if
				else {
					words = (player.constructMissString(room.getMonster()));
			    	status.setText(words);
					room.getMonster().setAngry(true);
				}//end else
				if (room.getMonster().getAngry() == true){
					if (room.getMonster().tryToAttack(player.getarmorClass()) == true){
						player.takeDamage(room.getMonster().calcHitDamage());
						words = (room.getMonster().constructHitString(player));
				    	status.setText(words);
						room.getMonster().setAngry(false);
					}//end if
					else {
						words = (room.getMonster().constructMissString(player));
				    	status.setText(words);
						room.getMonster().setAngry(false);
					}//end else
				}//end if monster get angry
			}//end if monster alive and player alive
			if (player.isAlive() == false){
				words = ("You Died");
		    	status.setText(words);
			}//end if	
			else if (room.getMonster().isAlive() == false){
				words = ("\n" + room.getMonster().getname() + " is dead");
		    	status.setText(words);
		    	room.getMonster().setVisible(false);
		    	int monsterID = room.getMonster().getCreatureID();
		    	monsters.get(monsterID).setVisible(false);
				room.setMonster(null);
			}//end else if
	    }//end monster != null
    }
    
    
    public void pickUpWeapon(Room currentRoom){
		if (currentRoom.getWeapon() == null){
		}
		else{
			words = ("You picked up the" + player.getWeaponObject());
	    	status.setText(words);
			player.setWeaponObject(currentRoom.getWeapon());
			currentRoom.setWeapon(null);
			generateWalls();
		}
    }
	
    private void generateButtons(){
    	status.setBounds(50, 575, 600, 100);
		add(status);
		
    	get.setBounds(550, 100, 80, 30);
        get.setEnabled(false);
        get.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                pickUpWeapon(theRoom);
            }
        });
        
        attack.setBounds(550, 200, 80, 30);
        attack.setEnabled(false);
        attack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Attack(theRoom);
            }
        });
        
        look.setBounds(550, 300, 80, 30);
        look.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	Look(theRoom);
            }
        });
        add(get);
		add(attack);
        add(look);
    }
    private void generateWalls(){
    	walls = new ArrayList<Wall>();
    	monsters = new ArrayList<Pictures>();
		weapons = new ArrayList<Pictures>();
		
		int monsterID = 0;
		int weaponID = 0;
		for(int x = 0; x<map.getWidth();x++){
			for (int y = 0; y < map.getHeight(); y++){
				if (map.getRoom(y,x).getRoomToEast() == null){
					Wall eastwall = new Wall((x+1)*100, y*100, 4,100);
					walls.add(eastwall);
				}
				if (map.getRoom(y,x).getRoomToSouth()==null){
					Wall southwall = new Wall(x*100, (y+1)*100, 100,4);
					walls.add(southwall);
				}
				if (map.getRoom(y,x).getWeapon() != null){
					Weapon weapon = map.getRoom(y,x).getWeapon();
					weapon.setWeaponID(weaponID);
					weaponID++;
					Pictures sword = new Pictures("sword.jpg",x*100+10,y*100+10);
					weapons.add(sword);
				}
				if(map.getRoom(y,x).getMonster() != null){
					Creature monster = map.getRoom(y,x).getMonster();
					monster.setCreatureID(monsterID);
					monsterID++;
		     		Pictures giant = new Pictures("monster.jpg",x*100+10,y*100+10);
		     		monsters.add(giant);
				}
			}//end for
		}//end for
    }

    
    public void paint(Graphics g) {
    	status.setBounds(50, 575, 600, 100);
    	get.setBounds(550, 100, 80, 30);
    	attack.setBounds(550, 200, 80, 30);
    	look.setBounds(550, 300, 80, 30);
    	
    	super.paint(g);
        
        if (ingame) {
        	
        	Graphics2D g2d = (Graphics2D)g;
    
			for (int i = 0; i < walls.size(); i++) {
	            Wall w = (Wall)walls.get(i);
	            if (w.isVisible()){
	                g2d.drawRect(w.getx1(), w.gety1(), w.getWidth(), w.getHeight());
	            }
			}
			for (int r = 0; r < weapons.size(); r++) {
	            Pictures p = (Pictures)weapons.get(r);
	            if (p.isVisible()){
	                g2d.drawImage(p.getImage(),p.getX(),p.getY(),this);
	            }
			}
			for (int k = 0; k < monsters.size(); k++) {
	            Pictures pi = (Pictures)monsters.get(k);
	            if (pi.isVisible()){
	                g2d.drawImage(pi.getImage(),pi.getX(),pi.getY(),this);
	            }
			}
			if (player.isVisible()) {
				g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
			}
			g2d.drawRect(50,575,600,100);
        }
//        add(get);
//		add(attack);
//        add(look);
        
		Toolkit.getDefaultToolkit().sync();
        g.dispose();

		requestFocusInWindow(true);
	 }//end paint
	 
	 public void actionPerformed(ActionEvent e) {
		 playerStatus();
		 checkCollisions();
		 if(checkGameOver()){
			 resetGame();
		 }
		 
		 
		 player.move();
		 
	     repaint();
	    
	 }
		public void printTextVersion(){
			Room currentLocation = theRoom;
	    	int x = 0; //rows
			int y = 0; // cols
			
			while (x < map.getHeight()){
				while (y < map.getWidth()){
					if (map.getRoom(x,y) == theRoom){
						if (map.getRoom(x,y).getRoomToEast() != null){
							System.out.print("X-"); //blue
						}
						else{
							System.out.print("X|");
						}
						y++;
					}
					else if (map.getRoom(x,y).getWeapon() != null && map.getRoom(x,y).getMonster() != null){
						if (map.getRoom(x,y).getRoomToEast() != null){
							System.out.print("B-");
						}
						else{
							System.out.print("B|");
						}
						y++;
					}
					else if (map.getRoom(x,y).getWeapon() != null){
						if (map.getRoom(x,y).getRoomToEast() != null){
							System.out.print("W-");
						}
						else{
							System.out.print("W|");
						}
						y++;
					}
					else if(map.getRoom(x,y).getMonster() != null){
						if (map.getRoom(x,y).getRoomToEast() != null){
							System.out.print("M-");
						}
						else{
							System.out.print("M|");
						}
						y++;
					}
					else{
						if (map.getRoom(x,y).getRoomToEast() != null){
							System.out.print("o-");
						}
						else{
							System.out.print("o|");
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
								System.out.print("| ");
								c++;
							}
							else{
								System.out.print("  ");
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
	    }//end printMap}
	 public void playerStatus(){
		int col = player.getCurrentX()/100;
		int row = player.getCurrentY()/100;
		setRoom(map.getRoom(row,col));
	 }
	 public void checkCollisions() {
        Rectangle r1 = player.getBounds();

        for (int j = 0; j<walls.size(); j++) {
            Wall w = (Wall) walls.get(j);
            Rectangle r2 = w.getBounds();
          
            if (r1.intersects(r2)) {
                player.setdx(player.getdx()*-1);
                player.setdy(player.getdy()*-1);
                break;
            }
        }
        
        if (theRoom.getWeapon() != null){
        	get.setEnabled(true);
        }
        else{get.setEnabled(false);}
        
        if (theRoom.getMonster() != null){
        	attack.setEnabled(true);
        }
        else{attack.setEnabled(false);}
	 } 
	 
	 
	 private class TAdapter extends KeyAdapter {
	        public void keyReleased(KeyEvent e) {
	            player.keyReleased(e);
	        }
	        public void keyPressed(KeyEvent e) {
	            player.keyPressed(e);
	        }
	    }


}
