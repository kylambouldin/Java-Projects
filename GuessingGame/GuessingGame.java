class GuessingGame
{
	public static void main ( String [] args ){
	java.util.Scanner input = new java.util.Scanner(System.in);
	{
		int r = (int) (Math.random() * 100 + 0.5) ;
		int guess;
		int numberofGuesses = 0;
		numberofGuesses += 1;
		System.out.println("Enter Guess between 0 and 100: "); 
		guess = input.nextInt();
		while (guess != r)
		{
			if (guess > r)
			{
				System.out.println("Guess Lower");
				numberofGuesses += 1;
				System.out.println("Enter Guess: "); 
				guess = input.nextInt();
			}
			if (guess < r)
			{
				System.out.println("Guess Higher");
				numberofGuesses += 1;
				System.out.println("Enter Guess: "); 
				guess = input.nextInt();
			}
			if (guess == r)
			{
				System.out.println("You Win!");
				System.out.println("You used " + numberofGuesses + " guesses");
				break;
			}
		}
	}
}
}