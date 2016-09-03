import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Food {
	private int x;
	private int y;
	private int height;
	private int width;
	private boolean isvisible;
	private Image foodImage;
	private String foodTypeName;
	private String foodTypeFiles[] = {"apple.jpg","banana.gif","cookie.png","cupcake_17916c.jpg",
									  "logo_cherry.gif","tomato_sm.gif","watermelon_simple.jpg"};

	public Food(){
	}
	public Food(int setx, int sety, int foodnum){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(foodTypeFiles[foodnum]));
		foodImage = ii.getImage();
		foodTypeName = foodTypeFiles[foodnum];
		isvisible = true;
		x =setx;
		y = sety;
		height = 10;
		width = 10;
	}
	
	public void setImage(int x){
		foodTypeName = foodTypeFiles[x];
		ImageIcon ii = new ImageIcon(this.getClass().getResource(foodTypeFiles[x]));
		foodImage = ii.getImage();
	}
	
	public String getFoodTypeName() {
		return foodTypeName;
	}
	public void setFoodTypeName(String foodTypeName) {
		this.foodTypeName = foodTypeName;
	}
	public Image getImage(){
		return foodImage;
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
	
	public void setIsVisible(boolean isvisible){
		this.isvisible = isvisible;
	}
	
	public boolean isVisible(){
		return isvisible;
	}
	
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
	
}

