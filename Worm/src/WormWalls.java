import java.awt.Rectangle;

public class WormWalls {
	int x1;
	int y1;
	int x2;
	int y2;
	private boolean visible;
	private int width;
    private int height;
	
    public WormWalls(){
    	visible = true;
    }
    
	public WormWalls(int startX, int startY, int startWidth,int startHeight){
		x1 = startX;
		y1 = startY;
		visible = true;
		width = startWidth;
		height = startHeight;
		}
	
	public Rectangle getBounds() {
        return new Rectangle(x1, y1, width, height);
    }
	
	public int getx1(){
		return x1;
	}

	public int gety1(){
		return y1;
	}

	public int getx2(){
		return x2;
	}

	public int gety2(){
		return y2;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public boolean isVisible() {
		return visible;
    }
		
}
