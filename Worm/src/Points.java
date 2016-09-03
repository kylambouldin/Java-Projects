import java.awt.Rectangle;
public class Points {
	private int x = 0;
	private int y = 0;
	private int height = 10;
	private int width = 10;
    private boolean isVisible;


	Points(){
	}
	
	Points(int inx, int iny){
		x = inx;
		y = iny;
		height = 10;
		width = 10;
	}
	
	public void setIsVisible(boolean isvisible){
		this.isVisible = isvisible;
	}
	
	public boolean isVisible(){
		return isVisible;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
	
}

