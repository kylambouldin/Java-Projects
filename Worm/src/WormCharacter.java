import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class WormCharacter {
	private int x;
	private int y;
	private int length;
	private int width;
	private int dx;
    private int dy;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int difficulty = 1;
    private boolean isVisible;
    public int totalheight;
    public int screenlength;
    public int screenwidth;
	WormCharacter(){
	}
	
	//player = new WormCharacter(width/2,length/2,10,10, width, length);
	WormCharacter(int inx, int iny, int inw, int inl, int sw, int sl){
		x = inx;
		y = iny;
		width = inw;
		length = inl;
		isVisible = true;
		screenwidth = sw;
		screenlength = sl;
	}

	
  	public boolean getVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getCurrentX(){
  		return x;
  	}
  	public int getCurrentY(){
  		return y;
  	}
  	
	public int getScreenLength() {
		return length;
	}
	public void setScreenLength(int length) {
		this.length = length;
	}
	public int getScreenWidth() {
		return width;
	}
	public void setScreenWidth(int width) {
		this.width = width;
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
	
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, length);
    }
	
	public void move() {
    	x += getDx();
        y += getDy();

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
        
        //width X length
        if ((y+length) > screenlength){
        	y = screenlength-length;
        }
        if ((x+width) > screenwidth){
        	x = screenwidth-width;
        }
    }
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && !right) {
        	left = true;
        	right = false;
        	up = false;
        	down = false;
            dx = -difficulty;
            dy =0;
        }

        if (key == KeyEvent.VK_RIGHT && left !=true) {
        	left = false;
        	right = true;
        	up = false;
        	down = false;
            dx = difficulty;
            dy = 0;
        }

        if (key == KeyEvent.VK_UP && down!=true) {
        	left = false;
        	right = false;
        	up = true;
        	down = false;
            dy = -difficulty;
            dx = 0;
        }

        if (key == KeyEvent.VK_DOWN && up != true) {
        	left = false;
        	right = false;
        	up = false;
        	down = true;
            dy = difficulty;
            dx = 0;
        }
    }

 /*   public void keyReleased(KeyEvent e) {
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
    }*/
}

