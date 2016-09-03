import javax.swing.JFrame;

public class Breakout extends JFrame {
	public int width;
	public int height;
	
	public Breakout(){
		BOJPanel panel = new BOJPanel(500,500);
		add(panel);
		
	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setTitle("Breakout");
        setResizable(true);
        setVisible(true);
	}
	public Breakout(int x, int y,int levelNum){
		//System.out.println("wormLevel:" + levelNum);
		width = x;
		height = y;
		BOJPanel panel = new BOJPanel(width,height);
		add(panel);
		
	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setTitle("Worm");
        setResizable(true);
        setVisible(true);
	}

	
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}