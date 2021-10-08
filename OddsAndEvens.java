import java.util.*;

public class OddsAndEvens {
	public static  void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name = askName(input); // waarom werkt dit alleen maar als askName static is?
		String choice = askOddEven(name, input);
		printChoice(choice, name);
		playGame(name, choice, input);
		
	}
	
	public static String askName(Scanner input) {
		System.out.println("Let's play a game called \"Odds and Evens\"");
		System.out.println("What is your name?");
		return input.nextLine();		
	}
	
	public static String askOddEven(String name, Scanner input) {
		System.out.println("Hi " + name + ", wich do you choose? (O)dds or (E)vens?");
		return input.nextLine();
	}
	
	public static void printChoice(String choice, String name) {
		if (choice.equalsIgnoreCase("O")) {
			System.out.println(name + " has picked Odds! The computer will be Evens.");
		} else if (choice.equalsIgnoreCase("E")) {
			System.out.println(name + " has picked Evens! The computer will be Odds.");
		} 
		System.out.println("----------------------------------------------------");
	}
	
	public static void playGame(String name, String choice, Scanner input) {
		System.out.println("How many \"fingers\" do you put out?");
		int fingersPlayer = input.nextInt();
		
		Random rand = new Random();
		int fingersBank = rand.nextInt(6);
		System.out.println("The computer plays " + fingersBank + " \"fingers\"");
		System.out.println("----------------------------------------------------");
		
		int totalFingers = fingersBank + fingersPlayer;
		System.out.println(fingersPlayer + " + " + fingersBank + " = " + totalFingers);
		
		boolean even = totalFingers % 2 == 0;
		if (even) {
			System.out.println(totalFingers + " is even!");
		} else {
			System.out.println(totalFingers + " is odd!");
		}
		System.out.println("----------------------------------------------------");
		
		boolean userChosesEven = choice.equalsIgnoreCase("e");
		if ((even && userChosesEven) || (!even && !userChosesEven)) {
			if (even) {
				System.out.println("You won, you choos even!");
			} else {
				System.out.println("You won, you choos odd!");
			} 
			}else {
				if (even) {
					System.out.println("You lost, computer choos even!");
				} else {
					System.out.println("You lost, computer choos odd!");
				}
		}
	}
}
