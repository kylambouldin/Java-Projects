import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Ball {
	int x;
	int y;
	int ballWidth;
	int ballHeight;
	boolean visible;
	int screenheight = 500;
	int screenwidth = 600;
	double dx;
	double dy;
	
	boolean left;
	boolean right;
	boolean up;
	boolean down;
	
	int ballColor;
	
	public Ball(){
		
	}
	public Ball(int x, int y){
		this.x = x;
		this.y = y;
		ballWidth = 10;
		ballHeight = 10;
		visible = true;
		dx = 1;
		dy = 1;
	}
	
	
	public int getBallNum(){
		return ballColor;
	}
	public void setBallNum(int n){
		ballColor = n;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public double getDx(){
		return dx;
	}
	public double getDy(){
		return dy;
	}
	public void setDx(double dx){
		this.dx = dx;
	}
	public void setDy(double dy){
		this.dy = dy;
	}
	public int getBallWidth(){
		return ballWidth;
	}
	public int getBallHeight(){
		return ballHeight;
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, ballWidth, ballHeight);
    }

	public boolean getRight(){
		return right;
	}
	public boolean getLeft(){
		return left;
	}
	public boolean getUp(){
		return up;
	}
	public boolean getDown(){
		return down;
	}
	public void move() {
		if (getDx() < 0){
			left = true;
			right = false;
			up = false;
			down = false;
		}
		else if (getDx() > 0){
			right = true;
			left = false;
			up = false;
			down = false;
		}
		
		if (getDy() < 0){
			left = false;
			right = false;
			up = true;
			down = false;
		}
		else if (getDy() > 0){
			right = false;
			left = false;
			up = false;
			down = true;
		}
		
    	x += getDx();
        y += getDy();

        if (x < 1) {
            dx *=-1;
        }
        if (y < 1) {
        	setDy(1);
            dy *=1;
        }
        if ((y+ballHeight) > screenheight-25){
        	setDx(1);
        	y = screenheight-25-ballHeight;
        }
        if ((x+ballWidth) > screenwidth-50){
        	setDx(getDx()*-1);
        }
    }

}
