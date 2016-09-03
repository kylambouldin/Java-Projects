import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.applet.AudioClip;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.io.File; 

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
//import BOJPanel.TAdapter;


public class BOJPanel extends JPanel implements ActionListener {
	public Ball ball;
	public Ball ball2;
	public Paddle player;
	public boolean ingame;
	public int width;
	public int height;
	public Timer timer;
	public BreakoutMap map;
	public int level = 0;
	private int sp = 5;
	Random generator = new Random();
	
	boolean fall;
	SpecialItem fallItem;
	
	public String stringPoints;
	public int points;
	
	public ArrayList<Block> blocks;
	
	JLabel score = new JLabel(stringPoints, SwingConstants.CENTER);
	
	public Color[] colors = { Color.black, Color.magenta, Color.red, Color.pink
			, Color.cyan, Color.blue,Color.yellow,Color.orange,Color.green};
	
	public boolean explosion;
	public Image explosionpic;
	public int explosionx;
	public int explosiony;
	
	public int numOfBlocks = 0;
	
	
	public BOJPanel(){
	}
	
	public BOJPanel(int x, int y){
		addKeyListener(new TAdapter());
	    setFocusable(true);
	    setBackground(Color.WHITE);
	    setDoubleBuffered(true);
		
	    timer = new Timer(5, this);
	    timer.start();
	
		width = x;
		height = y;
		ball = new Ball(250,200);
		ball2 = new Ball(150,200);
		player = new Paddle(250,450);
		//map = new BreakoutMap(width,height);
	    //map.LoadMap(level);
		ingame = true;
		
		points = 0;
		
		blocks = new ArrayList<Block>();
		generateBlocks();
		add(score);
		score.setBounds(200, 200, 50, 50);
		
	}

	public void checkCollisions(){
		 Rectangle pr1 = player.getBounds();
		 Rectangle r2 = ball.getBounds();
		 Rectangle r5 = ball2.getBounds();
		 int middlepr1 = player.getX() + player.getWidth();
		 int middler2 = ball.getX() + ball.getBallWidth();
		/* if (pr1.intersects(r2) && player.getDx() != 0){
			 new SoundClipTest(4);
			 ball.setDy((ball.getDy()*-2));
		 }
		 if (pr1.intersects(r5) && player.getDx() != 0){
			 new SoundClipTest(4);
			 ball2.setDy((ball2.getDy()*-2));
		 }*/
		 if (pr1.intersects(r2) && player.getLeft() && ball.getRight()){
			 new SoundClipTest(4);
			 ball.setBallNum(generator.nextInt(9));
			 ball.setDy((ball.getDy()*-2));
			 ball.setDx((ball.getDx()*-2));
		 }
		 else if (pr1.intersects(r2) && player.getDx() != 0){
			 new SoundClipTest(4);
			 ball.setBallNum(generator.nextInt(9));
			 ball.setDy((ball.getDy()*-2));
			 //ball.setDx((ball.getDx()*-1));
		 }
		 else if (pr1.intersects(r2)){
			 new SoundClipTest(4);
			 ball.setBallNum(generator.nextInt(9));
			 ball.setDy(ball.getDy()*-1);
		 }
		 else if (pr1.intersects(r5)){
			 new SoundClipTest(4);
			 ball.setBallNum(generator.nextInt(9));
			 ball2.setDy(ball2.getDy()*-1); 
		 }
		 
		 for (int k=0;k<blocks.size();k++){
			 Block b = (Block) blocks.get(k);
			 Rectangle r3 = b.getBounds();
			 if (r2.intersects(r3)){//ball and  block
				 new SoundClipTest(3);
				 ball.setBallNum(generator.nextInt(9));
				 if (ball.getUp()){
					 ball.setDy(-1);
				 }
				 ball.setDy(ball.getDy()*-1);
				 points++;
				 numOfBlocks++;
				 updateScore();
				 score.setText(stringPoints);
			 if (r5.intersects(r3)){//ball and  block
				 new SoundClipTest(3);
				 ball.setBallNum(generator.nextInt(9));
				 ball2.setDy(1);
				 ball2.setDy(ball2.getDy()*-1);
				 points++;
				 numOfBlocks++;
				 updateScore();
				 score.setText(stringPoints);
			 }
				 if (b.specialBlockTrue()){
					 setFallItem(b.getItem());
					 fallItem.setIsVisible(true);
					 setFall(true);
				 }
				if (numOfBlocks == 4 ){
					player.setWidth(player.getWidth()-10);
					numOfBlocks =0;
					}
				 b.setVisible(false);
				 blocks.remove(k);
				 break;
			 }
		 }
		if (ball.getY() > (player.getY())){
			player.setVisible(false);
			setVisible(false);
			//new SoundClipTest(0);
			new End(0,level);
		}
		
		if (ball2.getY() > (player.getY())){
			player.setVisible(false);
			setVisible(false);
			//new SoundClipTest(0);
			new End(0,level);
		}
		
		 if(fallItem != null){
			 Rectangle r4 = fallItem.getBounds();
			 if (pr1.intersects(r4)){
				 if(fallItem.getItemNum() == 0){
					 points++;
				 }
				 else if (fallItem.getItemNum() == 1){
					 player.setWidth(player.getWidth() + 5);
				 }
					 fallItem.setIsVisible(false);
					 points++;
					 updateScore();
					 score.setText(stringPoints);
			 }
		 }
	}
	
	public void updateScore(){
		stringPoints = Integer.toString(points);
	}
	
	
	public void setFallItem(SpecialItem s){
		fallItem = s;
	}
	public void setFall(boolean t){
		fall = t;
	}
	public boolean getFall(){
		return fall;
	}
	public void generateBlocks(){
		int k= 0;
		int c =0;
		for (int x=0;x <90;x+= 9){  //< 50 <col... block length = 50     (60)/6 = num of col
			for (int y=10; y<20;y+=2){ // y < 10.. <--- the number of rows....block height = 10
				Block b = new Block((x+(x+1)*sp) ,(y+(y+1)*sp),generator.nextInt(2));
				b.setColorNum(c);
				b.setNum(k);
				blocks.add(b);
				k++;
				if (c == colors.length-1){
					c =0;
				}
				c++;
			}
		}
	}
	
	public boolean checkForWin(){
		if (blocks.size() == 0){
			return true;
		}
		return false;
	}

	public void paint(Graphics g) {
		score.setBounds(200, 200, 50, 50);
    	super.paint(g);
        if (ingame) {
        	Graphics2D g2d = (Graphics2D)g;

        	g2d.setPaint(Color.black);
        	g2d.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        	
        	g2d.setPaint(colors[ball.getBallNum()]);
        	g2d.fillOval(ball.getX(), ball.getY(), ball.getBallWidth(), ball.getBallHeight());
        	//g2d.fillOval(ball2.getX(), ball2.getY(), ball2.getBallWidth(), ball2.getBallHeight());
        	
        	for(int j=0;j<blocks.size();j++){
        		Block b = blocks.get(j);
        		if(b.isVisible()){ 
    				g2d.setPaint(b.getColorNum());  //[generator.nextInt(0)]
    				g2d.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
        		}
        	}
        	if (fallItem != null && fallItem.isVisible()){
        		g2d.drawImage(fallItem.getImage(), fallItem.getX(), fallItem.getY(), this);
        	}
		Toolkit.getDefaultToolkit().sync();
        g.dispose();}
	 }//end paint 
	
	public void actionPerformed(ActionEvent e) {
		if(player.getVisible()){
			player.move();
			ball.move();
//			ball2.move();
			checkCollisions();
			if (getFall()){
				fallItem.move();
		}
	//		updateTimer();
			if (checkForWin()){
				player.setVisible(false);
				setVisible(false);
			new End(1,level);
			}
		repaint();
		}
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