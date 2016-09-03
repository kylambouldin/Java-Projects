// Page 95

import java.io.*;
import java.text.DecimalFormat;
public class TempConversion{
	public static void main(String args []){
		BufferedReader reader;
		String value = " ", tempType = " ";
		float basicTemp = 0, tempCelsius = 0, tempFahrenheit = 0;
		int choice = 0;
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		reader = new BufferedReader(new InputStreamReader(System.in));
		value = ConsoleInput.inputString("\n Select an option: "
							+ "\n \t 1- Convert from Fahrenheit to Celsius"
							+ "\n \t 2- Convert from Celsius to Fahrenheit"
							+ "\n >>");
		
			choice = Integer.parseInt(value);
			tempType = (choice == 1) ? "Fahrenheit" : "celsius";
			value = ConsoleInput.inputString("\n Enter the temperature: (" 
									+ tempType + "): ");
			basicTemp = Float.parseFloat(value);
		
		System.out.println("\n	Temperature entered: (" 
								+ tempType + ") " 
								+ twoDigits.format(basicTemp));
								
		if(choice == 1) {
			tempCelsius = 5.0F/9.0F * (basicTemp - 32);
			System.out.println("\n	Temperature Celsius: "
									+ twoDigits.format(tempCelsius));
		}else{
			tempFahrenheit = (9.0F/5.0F) * basicTemp + 32;
			System.out.println("\n	Temperature Fahrenheit: "
									+ twoDigits.format(tempFahrenheit));
		}
	}
}