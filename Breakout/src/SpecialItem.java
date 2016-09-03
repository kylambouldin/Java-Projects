import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class SpecialItem {
	private int x;
	private int y;
	private int dy;
	private int height;
	private int width;
	private boolean isvisible;
	private Image ItemImage;
	private String ItemName;
	public int itemNum;
	private String ItemFiles[] = {"pointup.jpg","paddleup.jpg","pointup.jpg","paddleup.jpg",
									  "pointup.jpg","paddleup.jpg","pointup.jpg"};

	public SpecialItem(){
	}
	public SpecialItem(int setx, int sety, int itemNum){
		this.itemNum = itemNum;
		ImageIcon ii = new ImageIcon(this.getClass().getResource(ItemFiles[itemNum]));
		ItemImage = ii.getImage();
		ItemName = ItemFiles[itemNum];
		isvisible = false;
		x =setx;
		y = sety;
		height = 10;
		width = 10;
		dy = 2;
	}
	
	public int getItemNum(){
		return itemNum;
	}
	public int getDy(){
		return dy;
	}
	public void move(){
		y+= getDy();
	}
	public void setImage(int x){
		ItemName = ItemFiles[x];
		ImageIcon ii = new ImageIcon(this.getClass().getResource(ItemFiles[x]));
		ItemImage = ii.getImage();
	}
	
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String in) {
		this.ItemName = in;
	}
	public Image getImage(){
		return ItemImage;
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
