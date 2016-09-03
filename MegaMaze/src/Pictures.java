import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Pictures {

	private String picture;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
	
    public Pictures(){
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(picture));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
    }
 
    public Pictures(String file,int givenx,int giveny){
    	picture = file;
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(picture));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = givenx;
        y = giveny;
    }
    
    public void setX(int inputx){
    	x = inputx;
    }
    public int getX() {
        return x;
    }
    public void setY(int inputy){
    	y = inputy;
    }

    public int getY() {
        return y;
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}
