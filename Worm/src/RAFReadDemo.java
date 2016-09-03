import java.io.*;

//Prompt the user to enter a filename
//Open the file for reading
//Read all of the contents of the file into a list
//Prompt the user to enter a name that they wish to search for
//Use a loop to traverse the list of names, and check if the name is found in the list
//You should output to the user whether or not the name is found in the list

public class RAFReadDemo {

	public static void main(String [] args)
    {
    	try //try out the following code, if there is an error, then "catch" it below
    	{
    		RandomAccessFile file = new RandomAccessFile("myFile.txt", "r");	//notice the "r", which says we are opening the file for reading
	    	
	    	String str = file.readUTF();	//read the first string that was originally written to file
	    	
	    	System.out.println(str);
	    	
	    	String str2 = file.readUTF();	//read the next string that was written to file
	    									//NOTE: the file pointer has advanced to the next thing
	    	
	    	System.out.println(str2);
	    	
			file.seek(0);					//reset the file pointer to the beginning;
			
			String str3 = file.readUTF();	//read the string from wherever I'm located in the file
			
			System.out.println(str3);
	    	
	    	file.close();
    	}
    	catch(IOException e)
    	{
    		System.out.println(e.toString());
    	}    
    }
}