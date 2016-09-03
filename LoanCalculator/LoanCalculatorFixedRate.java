import java.io.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.math.*;

public class LoanCalculatorFixedRate{
	public static void main(String args []){
		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		
		
		String value = "", choice = "";
		double total1, total2,total3,total4, total5,interestAmount, principalAmount, 
		numberofyears, rateofInterest, fixedRate, x,z,interestTotal;
		
		
		System.out.println("\n		Loan Calculator With Fixed Payment\n");
		
		while(true){
			try{
				value = ConsoleInput.inputString("\nType the Starting Amount:\t");
				principalAmount = Double.parseDouble(value);
				value = ConsoleInput.inputString("How many years?" + 
				"\n1 = .08\n2 = .17\n3 = .25\n4 = .33\n5 = .42\n6 = .50\n7 = .58\n8 = .67"
				+ "\n9 = .75\n10 = .83\n11 = .92 \n>>\t\t\t\t");
				numberofyears = Double.parseDouble(value);
				value = ConsoleInput.inputString("Percentage Rate of Interest: \t");
				rateofInterest = Double.parseDouble(value);
				rateofInterest = rateofInterest/100.00;
				value = ConsoleInput.inputString("Fixed Monthy Payment Rate:  \t");
				fixedRate = Double.parseDouble(value);
				
				interestAmount = (principalAmount * numberofyears);
				total1 = 1+rateofInterest; //Interest Added
				total2 = Math.pow(total1, numberofyears);
				total3 = principalAmount*(total2);
				total4 = fixedRate * (numberofyears * 12);
				total5 = total2 - total4;
				x = numberofyears * 12;
				z = principalAmount;
				interestTotal = (total3-principalAmount);
				
				System.out.println("Month" + "\t" + "Money Left");
				for (int i = 1; i <= x; i++){
					z -= fixedRate;
					
					System.out.println(i +"\t $"+ z);
				}
				System.out.println("Rate of Interest: \t\t"  + rateofInterest +"%");
				System.out.println("LoanAmount: \t\t\t$" + twoDigits.format(principalAmount));
				System.out.println("Year/s: \t\t\t$" + twoDigits.format(numberofyears));
				System.out.println("Money for " +  numberofyears + " years: \t\t$" 
																+ twoDigits.format(total3));
				System.out.println("Overall Payed amount: \t\t$" + twoDigits.format(total4));
				System.out.println("Interest Total for " + numberofyears+" years: \t$" 
																+ twoDigits.format(interestTotal));
				System.out.println("\n");
				System.out.println("Still Need To Pay: \t\t$"
										+ twoDigits.format(total3-total4));
			}
			
//			catch(IOException ieo){
//				System.out.println(ieo.toString() );
//			}
			catch(ArithmeticException ae) {
				System.out.println("Problem: " + ae.toString() );
				System.out.println("Cannot enter 0 for the denominator.");
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