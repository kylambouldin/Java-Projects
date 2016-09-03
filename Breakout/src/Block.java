import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Block {
	int x;
	int y;
	private boolean visible;
	private int width;
    private int height;
    public int num;
    public SpecialItem item;
    Random generator = new Random();
    
    public Color theColor;
    
	public Color[] colors = { Color.black, Color.magenta, Color.red, Color.pink
			, Color.cyan, Color.blue,Color.yellow,Color.orange,Color.green};
    

    public Block(){
    	visible = true;
    }
    
	public Block(int x, int y,int i){
		this.x = x;
		this.y = y;
		visible = true;
		width = 50;
		height = 10;
		if (i == 0){
			item = null;
		}
		if (i == 1){
			item = new SpecialItem(x,y,generator.nextInt(4));
		}
		}
	
	public SpecialItem getItem(){
		return item;
	}
	public boolean specialBlockTrue(){
		if (item != null){
			return true;
		}
		else
			return false;
	}
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
	
	public void setColorNum(int x){
		theColor = colors[x];
	}
	
	public Color getColorNum(){
		return theColor;
	}
	
	public int getNum(){
		return num;
	}
	public void setNum(int n){
		num = n;
	}
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
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
	public void setVisible(boolean b) {
		visible = b;
    }
		
}
