import java.io.*;

//Using a loop, you will continuously prompt the user to enter a name
//After the user inputs the name, you will append it to a list of names
//If the user ever inputs nothing, then you will break out of the loop or end the loop
//You should prompt the user to enter a filename to be used
//Create a new file to write out to, using the filename provided by the user
//Your program should traverse the list of names and write out to file, every name in the file
//Close your file

public class RAFWriteDemo {

    public static void main(String [] args)
    {
    	try	//try out the following code, if there is an error, then "catch" it below
    	{
    		RandomAccessFile file = new RandomAccessFile("myFile.txt", "rw");	//notice the "rw", which says we are opening the file for reading and for writing
	    	
	    	String str = "first words";
	    	String str2 = "second set of words";
	    	
	    	//writeUTF() first writes to file 2 bytes, which is the size of the string in bytes
	    	//THEN writeUTF() actually writes to file the string in bytes
	    	file.writeUTF(str);	
	    		
	    	file.writeUTF(str2);
	    	
	    	file.close();	//close the file when we are done
    	}
    	catch(IOException e)
    	{
    		System.out.println(e.toString());
    	}
    	
    }
    
}