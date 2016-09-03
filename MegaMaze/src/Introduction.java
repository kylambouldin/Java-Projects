import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Introduction extends JFrame {
	public Introduction(){
		
		setTitle("Intro");
		String INTRO = 
	    	"<html><h1><center>Welcome to the game</center></h1>" +
	    	"<center><br>You control the actions of the<br>"+
	    	"<strong>valient Gnusto Frotz</strong>, <br>"+
	    	"a warrior who is lost in the woods<br>" +
	    	"looking for his beautiful princess.<br>" +
	    	"Explore the maze and kill all the monsters <br>to win the game!</center>";
		
		JPanel panel = new JPanel(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(300, 300);
	    setLocationRelativeTo(null);
	    setTitle("MegaMaze");
	    setResizable(false);
	    setVisible(true);
	    
	    JLabel label = new JLabel(INTRO);
	    label.setBounds(0, 0, 100, 500);
	   
	    JButton enter = new JButton("Start");
	    enter.setBounds(200, 250, 80, 30);		
	    enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	new MegaMaze();
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
	    public static void main(String[] args) {
	    	new Introduction();
	    }
}
