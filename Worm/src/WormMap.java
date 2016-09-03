import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class WormMap {
	public boolean cells[][];
	public String filename;
    private int width;
    private int length;
//	private String str;
//	private boolean b;
	Random generator = new Random();
	
	public ArrayList<Food> foodPieces;
	int mapNum;
	String mapNames[] = {"map1.txt", "map2.txt", "map3.txt","map4.txt","map5.txt"
			,"map6.txt","map7.txt","map8.txt","map9.txt","map10.txt"};

	
	public WormMap(){
		cells = new boolean[length][width];	
		for(int x=0;x<length;x++){
			for (int y=0;y<width;y++){
				cells[x][y] = false;
			}
		}
	}
	
	public WormMap(int w, int l){
		width = w;
		length = l;
		cells = new boolean[length][width];
		for(int x=0;x<length;x++){
			for (int y=0;y<width;y++){
				cells[x][y] = false;
			}
		}
	}
	
	
	public void generateFood(int numFoodItems){
		foodPieces = new ArrayList<Food>();
		for(int x=0;x<=numFoodItems;x++){
			Food nom = new Food(generator.nextInt(width - 10),generator.nextInt(length - 10),generator.nextInt(7));
			foodPieces.add(nom);
		}
	}
	
	public ArrayList<Food> getFood(){
		return foodPieces;
	}
	public void randomMap(int maxtrue){
		for (int x = 0; x <maxtrue;x++){
			cells[generator.nextInt(length)][generator.nextInt(width)] = true;
		}
	}
	
	public boolean getCell(int x,int y) {
		return cells[x][y];
	}

	public void setCells(int x, int y, boolean str) {
		cells[x][y] = str;
	}
	

	public void printMap(){
		for (int x=0;x<length;x++){
			for (int y=0;y<width;y++)
				System.out.println(cells[x][y]);
		}
	}
	
	public void WriteMap(int mapNum){
		this.mapNum = mapNum;
		try{
    		RandomAccessFile file = new RandomAccessFile(mapNames[mapNum], "rw");	
    		//notice the "rw", which says we are opening the file for reading and for writing
    		
    		for (int x=0;x<length;x++){
    			for (int y=0;y<width;y++){
    				if (cells [x][y] == true){
    					file.writeInt(x);
    					file.writeInt(y);
    				}	
    			}
    		}
    		file.close();
		}
    	catch(IOException e){
    		System.out.println(e.toString());
    	}
	}
	
	public void LoadMap(int mapNum){
		try
    	{
    		RandomAccessFile file = new RandomAccessFile(mapNames[mapNum], "r");	
    		//notice the "r", which says we are opening the file for reading
    		for (int g=0;g<file.length()/4/2;g++){
	    		int x = file.readInt();
	    		int y = file.readInt();
	    		setCells(x,y,true);
    		}
    		
    		/*for (int x=0;x<width;x++){
		    			for (int y=0;y<length;y++){
		    				String s = file.readUTF();
		    				System.out.println(s);
		    		        b = Boolean.parseBoolean(s);
		    				setCells(x,y,b);
		    			}
		    		}*/
	    	
	    	file.close();
    	}
    	catch(IOException e)
    	{
    		System.out.println("load");
    		System.out.println(e.toString());
    	}    
    }
		

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getlength() {
		return length;
	}

	public void setlength(int length) {
		this.length = length;
	}
	
	
	public Rectangle getBounds(int x, int y) {
        return new Rectangle(x, y, 10, 10);
    }
}