import javax.swing.JFrame;

public class Worm extends JFrame {
	public int width;
	public int length;
	public int numOfOb;
	public Worm(){
		WormJPanel panel = new WormJPanel(500,500,numOfOb);
		add(panel);
		
	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, length);
        setLocationRelativeTo(null);
        setTitle("Worm");
        setResizable(true);
        setVisible(true);
	}
	public Worm(int x, int y,int levelNum){
		//System.out.println("wormLevel:" + levelNum);
		width = x;
		length = y;
		WormJPanel panel = new WormJPanel(width,length,levelNum);
		add(panel);
		
	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, length);
        setLocationRelativeTo(null);
        setTitle("Worm");
        setResizable(true);
        setVisible(true);
	}

	public int getNumOfOb() {
		return numOfOb;
	}
	public void setNumOfOb(int numOfOb) {
		this.numOfOb = numOfOb;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}