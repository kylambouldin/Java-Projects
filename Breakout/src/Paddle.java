import java.awt.Rectangle;
import java.awt.event.KeyEvent;



public class Paddle {
	public boolean visible;
	public int x;
	public int y;
	public int dx;
	public int width;
	public int height;
	public int screenwidth = 600;
	
	public boolean left;
	public boolean right;
	

	public Paddle(){
		
	}
	public Paddle(int x,int y){
		this.x =x;
		this.y = y;
		width = 100;
		height = 10;
		visible = true;
		dx = 0;
	}
	
	public int getDx(){
		return dx;
	}
	public void setDx(int dx){
		this.dx = dx;
	}
	public void setVisible(boolean v){
		visible = v;
	}
	
	public boolean getVisible(){
		return visible;	
	}
	
	public void move() {
    	x += getDx();

        if (x < 1) {
            x = 1;
        }


        if ((x+width) > screenwidth - 55){
        	x = screenwidth - 55 - width;
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
	
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	public void setWidth(int w){
		width = w;
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
	
	public boolean getRight(){
		return right;
	}
	public boolean getLeft(){
		return left;
	}


	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	left = true;
        	right = false;
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	right = true;
        	left = false;
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    }
}

