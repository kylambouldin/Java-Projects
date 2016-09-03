import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End extends JFrame {
	int level;
	int didwin;
	public End(){
	}
	public End(int x,int oldLevel){//Task0 task
		didwin = x;
		level = oldLevel;
		

		//System.out.println("EndLevel: " + level);
		
		setTitle("End");
		String endings[] = {"<html><h1><center>YOU LOSE:(</center></h1>",
							"<html><h1><center>YOU WIN!</center></h1>"};
		// 0 = lose, 1 = win
/*		if (x == 0){ //lose
			task.exit();
		}
		else if(x == 1){ //win
			task.setTarg(-1);
		}
	*/	
		JPanel panel = new JPanel(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(350, 150);
	    setLocationRelativeTo(null);
	    setTitle("End");
	    setResizable(false);
	    setVisible(true);
	    
	    JLabel label = new JLabel(endings[x]);
	    label.setBounds(0, 0, 100, 500);
	   
	    JButton again = new JButton("Play Again");
	    again.setBounds(200, 250, 80, 30);		
	    again.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	new Introduction();
            	setVisible(false);
            }
        });
	    
	    JButton quit = new JButton("Quit");
	    quit.setBounds(250, 250, 80, 30);		
	    quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	System.exit(0);
            }
        });
	    
	    JButton next = new JButton("Next Level");
	    next.setBounds(300, 250, 80, 30);		
	    next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	setVisible(false);
            }
        });
	    
	    panel.add(label);
	    panel.add(again);
	    panel.add(quit);
	    if (didwin == 1){panel.add(next);}
	    add(panel);
	    requestFocusInWindow(true);
	    setVisible(true);
	    //pack();
	    
	}//end intro()
	    public static void main(String[] args) {
	    	new Introduction();
	    }
}
