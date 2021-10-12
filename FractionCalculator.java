import java.util.*;

public class FractionCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		intro();
		boolean quit = false;
		
		while (!quit) {
			String operation = getOperation(input);
			if (operation.equalsIgnoreCase("q")) {
				quit = true;
			} else {
				Fraction breukEen = getFraction(input);
				Fraction breukTwee = getFraction(input);
				
				// do the math
				if(operation.equals("+")) {
					Fraction breukSom = breukEen.add(breukTwee);
					breukSom.toLowestTerms();
					System.out.println(breukEen.toString() + " " + operation + " " + breukTwee.toString() + ""+ breukSom.toString());
				} else if (operation.equals("-")) {
					Fraction breukSom = breukEen.subtract(breukTwee);
					breukSom.toLowestTerms();
					System.out.println(breukEen.toString() + " " + operation + " " + breukTwee.toString() + " = "+ breukSom.toString());
				} else if(operation.equals("*")) {
					Fraction breukSom = breukEen.multiply(breukTwee);
					breukSom.toLowestTerms();
					System.out.println(breukEen.toString() + " " + operation + " " + breukTwee.toString() + " = "+ breukSom.toString());
				} else if(operation.equals("/")) {
					Fraction breukSom = breukEen.divide(breukTwee);
					breukSom.toLowestTerms();
					System.out.println(breukEen.toString() + " " + operation + " " + breukTwee.toString() + " = "+ breukSom.toString());
				} else {
					boolean equal = breukEen.equals(breukTwee);
					System.out.println(breukEen.toString() + " " + operation + " " + breukTwee.toString() + " is "+ equal);
				}
				
				// waarom kan ik breukSom hier niet gebruiken? dan hoef ik al die SYso niet te herhalen
				
			}
			}
			
			
		
		
		
	}
	
	public static void intro() {
		System.out.println("This program is a fraction calculator");
		System.out.println("It wil add, subtract, multiply and divide fractions until you type Q to quit.");
		System.out.println("Please enter a fraction in the form a/b, wheare a and b are integers.");
		System.out.println("---------------------------------------------------------------------------------------------------");
	}
	
	
	public static boolean validFraction(String fraction) {
		boolean valid = false;
		int nummer;
		try {
			// is fraction integer?
			nummer = Integer.parseInt(fraction);
			valid = true;
		} catch (NumberFormatException ex) {
			// first check for fraction is a fraction? had it a / and not only a '/'
			if (fraction.contains("/") && !fraction.equals("/")) {
				// splits de invoer rond / 
				String[] numbers = fraction.split("/");
				
				// is ingevoerde nummerator een int?
				try {
					int nummerator = Integer.parseInt(numbers[0]);
					// is de ingevoerde denummerator ook een int?
					try {
						int denummerator = Integer.parseInt(numbers[1]);
						valid = true;
					} catch (NumberFormatException exce) {
						valid = false;
					}
				} catch (NumberFormatException exc) {
					valid = false;
				}
			} else {
				valid = false;
			}
		}
		
		return valid;
	}
	
	
 	public static String getOperation(Scanner input) {
		boolean correctInput = false;
		String operator = "";
		System.out.println("Please enter an operation (+,-,/,*,= or Q to quit)");
		
		
		while (!correctInput) {
			operator = input.nextLine();
			if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*") || operator.equals("=") || operator.equalsIgnoreCase("q")) {
				correctInput = true;
			} else {
				System.out.println("Invalid input (+,-,/,*,= or Q to quit):");
			}
		}
		
		return operator;		
	}
	
	public static boolean validFraction1(String fraction) {
		// check of het integer is
		try {
			int numerator = Integer.parseInt(fraction);
			return true;
		} catch (NumberFormatException ex) {
			// checkt op int/int mag met - teken, weet niet hoe ik dat bij denum kan doen
			// waarvoor staan de \\ er in en de + op het einde? 
			if (fraction.matches("-{0,1}[0-9]+\\/[0-9]+")) { 
				String[] numbers = fraction.split("/");
				if(numbers[1].equals("0")) { // als denum 0 is 
					return false;
				} else {
					return true; // denum geen 0 wel int/int 
				} 
			} else {
				return false;
			}
		}
	}
	
	public static Fraction getFraction(Scanner input) {
		System.out.println("Please enter a fraction (a/b) or interger (a)");
		boolean valid = false;
		String fraction = "";
		
		// check valid fraction
		while (!valid) {
			fraction = input.nextLine();
			
			if (validFraction(fraction)) {
				valid = true;
			} else {
				System.out.println("Invalid fraction. Please enter (a/b) of (a), where a and b are integers and b is not zero:");
			}
		}
		
		int nummerator = 0;
		int denummerator = 0;
		// check fraction is integer
		try {
			nummerator = Integer.parseInt(fraction);
			denummerator =  1;
		} catch (NumberFormatException ex) {
			// stop breuk in array haal / weg 
			String[] numbers = {fraction.substring(0, fraction.indexOf("/")), fraction.substring(fraction.indexOf("/") + 1)};
			// maak van de Strings integers
			nummerator = Integer.parseInt(numbers[0]);
			denummerator = Integer.parseInt(numbers[1]);
		}
		
		return new Fraction(nummerator, denummerator);
		
	}
}
