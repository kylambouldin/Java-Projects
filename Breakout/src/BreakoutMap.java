import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;

public class BreakoutMap {

	public boolean block[][];
	public String filename;
	public int width;
	public int height = 100;
	public int mapNum;
	public int level;
	Random generator = new Random();
	public 	String mapNames[] = {"map1.txt", "map2.txt", "map3.txt","map4.txt","map5.txt"
			,"map6.txt","map7.txt","map8.txt","map9.txt","map10.txt"};
	
	public BreakoutMap(){
		
		//			testMap = new BreakoutMap(width,length);
		//testMap.randomMap(numOfObstacles*r);
		//testMap.WriteMap(r);
		
	}

	public BreakoutMap(int w){
		block = new boolean[width][height];//row by col
		for(int x=0;x<width;x++){
			for (int y=0;y<height;y++){
				block[x][y] = false;
			}
		}
		width = w;
		
		System.out.println(block[0][0]);
		
	}
	
	
	public BreakoutMap(int w, int level){
		block = new boolean[width][height];	
		for(int x=0;x<width;x++){
			for (int y=0;y<height;y++){
				block[x][y] = false;
			}
		}
		width = w;
		this.level = level;
	}
	
	
	public void generateMap(){
		for (int x = 0; x <width;x++){
			for (int y=0;y <height;y++){
				System.out.println(x +"," + y);
				block[x][y] = true;
			}
		}
	}
	public boolean getBlock(int x,int y) {
		return block[x][y];
	}

	public void setBlock(int x, int y, boolean str) {
		block[x][y] = str;
	}

	public void WriteMap(int mapNum){
		this.mapNum = mapNum;
		try{
    		RandomAccessFile file = new RandomAccessFile(mapNames[mapNum], "rw");	
    		//notice the "rw", which says we are opening the file for reading and for writing
    		
    		for (int x=0;x<10;x++){
    			for (int y=0;y<width;y++){
    				if (block [x][y] == true){
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
	    		setBlock(x,y,true);
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
		
	
}
