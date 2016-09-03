import java.text.DecimalFormat;

public class TipAdder{
	public static void main (String [] args){
	java.util.Scanner input = new java.util.Scanner(System.in);
		Double mealPrice,
			percentToTip,
			tipAmount,
			totalMealPrice;
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		mealPrice = ConsoleInput.inputDouble("Price of the meal: "); 
		percentToTip = ConsoleInput.inputDouble("Enter Tip Percent "); 
		percentToTip /= 100;
		
		tipAmount = mealPrice * percentToTip;
		totalMealPrice = tipAmount + mealPrice;
		System.out.println("\n ----$$$ Tip Adder $$$ ----- \n");
		System.out.println("\n Cost of Meal:\t$" + mealPrice);
		System.out.println(percentToTip*100 + "% tip is: \t $" + twoDigits.format(tipAmount));
		System.out.println("-----------------------------");
		System.out.println("The total bill: \t$" + twoDigits.format(totalMealPrice) + "\n");
		}
	}