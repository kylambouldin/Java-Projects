import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Introduction extends JFrame {
	public int width = 500;
	public int length = 475; //length - 25 because of intro
	public Worm game;
	public WormMap testMap;
	int numOfObstacles = 1;//displays one less
	int level = 0;


	public Introduction(){
		
		setTitle("Intro");
		String INTRO = 
	    	"<html><h1><center>Welcome to the Game</center></h1>" +
	    	"<center><br>You control the actions of the< small worm<br>"+
	    	"He is trapped in a garden and is looking for food.<br>" +
	    	"The more he eats, the longer he grows<br>" +
	    	"Watch out for walls, and don't run into yourself</center>";
		
		JPanel panel = new JPanel(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(350, 300);
	    setLocationRelativeTo(null);
	    setTitle("Worm");
	    setResizable(true);
	    setVisible(true);
	    
	    JLabel label = new JLabel(INTRO);
	    label.setBounds(0, 0, 100, 500);
	   
	    JButton enter = new JButton("Start");
	    enter.setBounds(200, 250, 80, 30);		
	    enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	game = new Worm(width, length,level);
            	setVisible(false);
            }
        });
	    
	    panel.add(label);
	    panel.add(enter);
	    add(panel);
	    requestFocusInWindow(true);
	    setVisible(true);
	    //pack();
	    
	}//end intro()
	

	public void setWidth(int width) {
		this.width = width;
	}

	public void mapMaker(){
		for (int r=0;r<=6;r++){
			testMap = new WormMap(width,length);
			testMap.randomMap(numOfObstacles*r);
			testMap.WriteMap(r);
		}
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setLevel(int l){
		level = l;
	}
	
	
	public static void main(String[] args) {
	    Introduction intro =  new Introduction();
	    intro.mapMaker();
	}
}