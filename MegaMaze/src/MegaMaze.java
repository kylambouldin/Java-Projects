import javax.swing.JFrame;

public class MegaMaze extends JFrame {


    public MegaMaze() {
		
    	add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setTitle("MegaMaze");
        setResizable(false);
        setVisible(true);
    }
}