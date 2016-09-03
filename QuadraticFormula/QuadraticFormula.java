class QuadraticFormula
{
	public static void main(String [] args)
	{
		int a;
		int b;
		int c;
		double root;
		double answer1;
		double answer2;
		System.out.print("Please enter a: "); 
		a = ConsoleInput.inputInt();
		System.out.print("Please enter b: "); 
		b = ConsoleInput.inputInt();
		System.out.print("Please enter c: "); 
		c = ConsoleInput.inputInt();
		System.out.println("Your equation is " + a + "*x^2+" + b + "*x+" + c + "=0");
		root = (Math.pow(b, 2.0) - (4.0*a*c));
		if (root > 0) 
		{
			System.out.println("Solutions are real");
			answer1 = (-b + Math.pow(root, .5))/(2.0*a);
			answer2 = (-b - Math.pow(root, .5))/(2.0*a);
			System.out.println("Your roots are: ");
			System.out.println(answer1);
			System.out.println(answer2);
		}
		if (root < 0)
		{
			System.out.println("Solutions are imaginary");
			root = root*-1;
			answer1 = (Math.pow(root, .5));
			answer2 = (Math.pow(root, .5));
			System.out.println("Your roots are: ");
			System.out.println((-b/(2.0*a)) + "+" + answer1/(2.0*a) + "i");
			System.out.println((-b/(2.0*a)) + "-" + answer2/(2.0*a) + "i");
		}
	}
}


//	1.	CHALLENGE: check if the solutions are real or imaginary
//	2.	CHALLENGE2: print both solutions even if imaginary
	

