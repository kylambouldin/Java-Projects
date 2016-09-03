import java.io.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.math.*;

public class LoanCalculator{
	public static void main(String args []){
		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		
		
		String value = "", choice = "";
		double total1, total2,total3,interestAmount, principalAmount = 0, 
		numberofyears = 0, rateofInterest = 0;
		
		
		System.out.println("\n		Loan Calculator With Fixed Payment\n");
		
		while(true){
			try{
				value = ConsoleInput.inputString("\nType the Starting Amount:\t");
				principalAmount = Integer.parseInt(value);
				value = ConsoleInput.inputString("How many years?" + 
				"\n1 = .08\n2 = .17\n3 = .25\n4 = .33\n5 = .42\n6 = .50\n7 = .58\n8 = .67"
				+ "\n9 = .75\n10 = .83\n11 = .92 \n>>\t\t\t\t");
				numberofyears = Integer.parseInt(value);
				value = ConsoleInput.inputString("Percentage Rate of Interest: \t");
				rateofInterest = Integer.parseInt(value);
				rateofInterest /= 100;
				
				interestAmount = (principalAmount * numberofyears);
				total1 = 1+rateofInterest; //Interest Added
				total3 = Math.pow(total1, numberofyears);
				total2 = principalAmount*(total3);
				
				
				System.out.println("Total Amount: \t\t\t"
										+ twoDigits.format(total2) );
			}
			
			catch(ArithmeticException ae) {
				System.out.println("	Problem: " + ae.toString() );
				System.out.println("	Cannot enter 0 for the denominator.");
			}
			catch(NumberFormatException nfe) {
				System.out.println(	nfe.toString() );
			}
			finally{
				System.out.println("----------------------" +
								   "----------------------\n");
			}
			choice = ConsoleInput.inputString("\n Another? Y | Quit Q	>>");
			if (choice.equalsIgnoreCase("Q") ) {
				break;
			}
		}
	}
	public static double multiplyNumber(double principalAmount, double numberofyears){
		if (numberofyears == 0) {
			throw new ArithmeticException();
		}
		return (double) principalAmount*numberofyears;
	}
}