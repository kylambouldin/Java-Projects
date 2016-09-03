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
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class WormJPanel extends JPanel implements ActionListener {

	Random generator = new Random();
	private boolean ingame;
	private Timer timer;
	public WormCharacter player;
	public Points oldLoc;
	public Points startLoc;
	public ArrayList<Food> foodPieces;
	public ArrayList<Points> path;
	public int level;
	//public ArrayList<Points> followers;
	//int idnum = 0;
	int numFoodItems = 9; // displays one more
	int numFollowers = 0;
	WormMap map;
	public int width;
	public int length;
	String seconds = "60";
	
	JLabel countDown = new JLabel(seconds, SwingConstants.CENTER);
	java.util.Timer timer2 = new java.util.Timer();
	Task0 task = new Task0(60000,level);
	
	String mapNames[] = {"map1.txt", "map2.txt", "map3.txt","map4.txt","map5.txt"
						,"map6.txt","map7.txt","map8.txt","map9.txt","map10.txt"};
	
	
	public WormJPanel(){
	}
	
	public WormJPanel(int x, int y,int levelNum){
		width = x;
		length = y;
		level = levelNum;
		//System.out.println("wormPanelLevel:" + level);
		
		addKeyListener(new TAdapter());
	    setFocusable(true);
	    setBackground(Color.WHITE);
	    setDoubleBuffered(true);
	    ingame = true;
		
	    timer = new Timer(5, this);
	    timer.start();
	    
	    player = new WormCharacter(width/2,length/2,10,10, width, length); // starts player in middle of screen
	    oldLoc = new Points(player.getX(),player.getY());//aka startLoc
	    path = new ArrayList<Points>();
	    //followers = new ArrayList<Points>();
	    
	    map = new WormMap(width,length);
	    map.LoadMap(level);
	    map.generateFood(numFoodItems);
	    foodPieces = map.getFood();

	    setSeconds(task.getN());
	    System.out.println("num1: " + task.getN());
	    CountDownTimer();
	}
	

	public double distance(Points x, Points x2) {
		double firstPart = Math.pow(x2.getX() - x.getX(), 2);
		double secondPart = Math.pow(x2.getY() - x.getY(), 2);
		double answer = Math.sqrt(firstPart + secondPart);
		return answer;
	}
	//oldLoc = new Points(player.getX(),player.getY());
	public void updateLoc(WormCharacter player){
		Points curLoc = new Points();
		curLoc.setX(player.getCurrentX());
		curLoc.setY(player.getCurrentY());
		if (distance(curLoc, oldLoc) >= 10){
			path.add(curLoc);
			
			
			oldLoc.setX(curLoc.getX());
			oldLoc.setY(curLoc.getY());
			//oldloc becomes the curloc..
		}
		
		if(path.size() > numFollowers){
			path.remove(0);
		}
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
/*	private void printPath(){
		for(int x=0; x<path.size();x++){
			System.out.print("(" + path.get(x).getX()+",");
			System.out.println(path.get(x).getY()+")");
		}
	}*/
	
	public void setSeconds(String sec){
		seconds = sec;
	}
	private void updateTimer(){
		setSeconds(task.getN());
		countDown.setText(seconds);
		//System.out.println("num2: " + task.getN());
		//System.out.println("sec: " + seconds);
		//countDown.setBounds(250, 250, 50, 50);
		//System.out.println("Seconds: " + seconds);
	}
	
	private void CountDownTimer(){
		timer2.scheduleAtFixedRate(task, 10, 1000);
		countDown.setBounds(200, 200, 50, 50);
		add(countDown);
		}
	
	private boolean checkForWin(){
		if (foodPieces.size() == 0){
			//System.out.println("YOU WIN");
			return true;
		}
		else {return false;}
	}
	
	public void checkCollisions() {
        Rectangle r1 = player.getBounds();
        
        for(int r=0;r<path.size()-2;r++){ //for(int r=0;r<path.size()-1;r++)
        	Points p = (Points) path.get(r);
        	Rectangle r3 = p.getBounds();
/*        	System.out.print(r);
        	System.out.print(" path:(" + p.getX() + "," + p.getY() + ")");
        	System.out.print(" player:(" + player.getCurrentX() + "," + player.getCurrentY() + ")");
        	System.out.print(" intersects():" + r1.intersects(r3));
        	System.out.println();
*/        	
        	if  (r1.intersects(r3)){
        		player.setVisible(false);
        		setVisible(false);
        		new End(0,level,task);
        		break;
//        		System.out.println("GAMEOVER");
//        		System.exit(0);
        	}
        }
        for (int j = 0; j<foodPieces.size(); j++) {
            Food f = (Food) foodPieces.get(j);
            Rectangle r2 = f.getBounds();
            if (r1.intersects(r2)) {
            	numFollowers++;
            	f.setIsVisible(false);
            	foodPieces.remove(j);
            	break;
	        }
        }
        for(int k=0;k<map.getlength();k++){
    		for(int b=0;b<map.getWidth();b++){
    			if (map.getCell(k,b) == true){
    				Rectangle r4 = map.getBounds(k,b);
    				if (r1.intersects(r4)){
    					player.setVisible(false);
    					setVisible(false);
    	        		new End(0,level,task);
    	        		break;

//        				System.out.println("GAMEOVER");
//        				System.exit(0);
        			}
    			}
    		}
        }
	}
	
	public void paint(Graphics g) {
		countDown.setBounds(200, 200, 50, 50);
    	super.paint(g);
        if (ingame) {
        	/////////////////
        	Graphics2D g2d = (Graphics2D)g;
        	g2d.drawLine(0,length, width, length);
        	
        	if (player.getVisible()){
        		g2d.fillOval(player.getX(), player.getY(), player.getWidth(), player.getLength());
        	}
        	for (int i = 0; i < foodPieces.size(); i++) {
		            Food f = (Food)foodPieces.get(i);
		            if (f.isVisible()){
		            	g2d.drawImage(f.getImage(), f.getX(), f.getY(), f.getWidth(), f.getHeight(), this);
		            	//g2d.drawOval(f.getX(), f.getY(), f.getWidth(), f.getHeight());
		            }
        	}

        	for(int j = 0;j<path.size();j++){
        		Points p= (Points)path.get(j);
        		g2d.fillOval(p.getX(),p.getY(),10,10);
        	}
        	for(int k=0;k<map.getlength();k++){
        		for(int b=0;b<map.getWidth();b++){
        			if (map.getCell(k,b) == true){
        				g2d.fillRect(k, b, 10, 10);
        			}
        		}
        	}
        	
		Toolkit.getDefaultToolkit().sync();
        g.dispose();}
	 }//end paint 
	
	public void actionPerformed(ActionEvent e) {
		if(player.getVisible()){
			player.move();
			updateLoc(player);
			checkCollisions();
			updateTimer();
			if (checkForWin()){
				player.setVisible(false);
				setVisible(false);
				new End(1,level,task);
			}
		repaint();
		}
	 }
	 
	 private class TAdapter extends KeyAdapter {
	        //public void keyReleased(KeyEvent e) {
	          //  player.keyReleased(e);
	        //}
	        public void keyPressed(KeyEvent e) {
	            player.keyPressed(e);
	        }
	    }
	
	
	
}
