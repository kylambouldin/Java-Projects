public class Parser{

		public static final int NORTH = 1;
		public static final int EAST = 2;
		public static final int SOUTH = 3;
		public static final int WEST = 4;
		public static final int ATTACK = 5;
		public static final int LOOK = 6;
		public static final int GET = 7;
		public static final int QUIT = 8;
		public static final int DO_NOT_UNDERSTAND = -1;
		
		
//boolean askYesNoQuestion(String prompt): The parser should print prompt, check stdin for 
//"yes", "y", "no", or "n" answers, and return true or false for yes or no answers, respectively. 
//This method should not care about capitalization, so "YES" and "yes" are both valid inputs. 
//If the method does not understand the input, it should print "Please answer yes or no.", 
//and wait for user input again.

		public static boolean askYesNoQuestion(String prompt){
			prompt = ConsoleInput.inputString(prompt + ": ");
			while (true){
	 			if (prompt.equalsIgnoreCase("yes") || prompt.equalsIgnoreCase("y")){
	 				return true;
	 			}
	 			else if (prompt.equalsIgnoreCase("no") || prompt.equalsIgnoreCase("n")){
	 				return false;
	 			}
	 			else{
					prompt = ConsoleInput.inputString("Please answer yes or no: ");
	 			}
	 		}
	 	}



//public static void printCommands(): This method will print out the available commands 
//(north, east, look, attack, etc.) for the parse() method. 
//This can print out each of the individual commands, or it can just print out a summary. 
//See the sample execution run below (lines 6-8) for an example of how this method might work.

	public static void printCommands(){
		System.out.println("Valid commands are any of the four directions (north, south, east, west)"
		+ ",look, attack, get, or quit."
		+ "\nYou can abbreviate any command by its first letter");
	}


//int parse(): This method does a few things:
	//Prompt the user for input (this can be a simple "enter next command")
	//Read in that input from the stdin Scanner.
	//Compare the read in input to a series of acceptable strings for each of the above constants. 
	//If the input contains the user's typed command "north" or "n", the parse() 
	//method should return the integer constant NORTH. If the user types "attack", 
	//the method should return ATTACK, if the user types "look" the method returns LOOK, 
	//"get" for GET, and so on. We don't care about case, 
	//so you should use the equalsIgnoreCase() method instead of the equals() methods. 
	//Note that if the first letter of the user's input line matches, then you should still 
	//return the appropriate value (so "l" is valid for "look", as is "large" and "LAB"). 
	//If the user input does not match any known command, the parse() method should return
	//DO_NOT_UNDERSTAND.
	
	public static int parse(){
		String command = ConsoleInput.inputString("Enter next command: ");
		if (command.equalsIgnoreCase("north") || command.equalsIgnoreCase("n")){
			return NORTH;
		}
		else if (command.equalsIgnoreCase("south") || command.equalsIgnoreCase("s")){
			return SOUTH;
		}
		else if (command.equalsIgnoreCase("east") || command.equalsIgnoreCase("e")){
			return EAST;
		}
		else if (command.equalsIgnoreCase("west") || command.equalsIgnoreCase("w")){
			return WEST;
		}
		else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")){
			return QUIT;
		}
		else if (command.equalsIgnoreCase("look") || command.equalsIgnoreCase("l")){
			return LOOK;
		}
		else if (command.equalsIgnoreCase("attack") || command.equalsIgnoreCase("a")){
			return ATTACK;
		}
		else if (command.equalsIgnoreCase("get") || command.equalsIgnoreCase("g")){
			return GET;
		}
		else{
			return DO_NOT_UNDERSTAND;
		}
	}

} //close class