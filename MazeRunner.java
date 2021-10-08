import java.util.*;

public class MazeRunner {

	public static void main(String[] args) {
		Maze myMap = new Maze();
		intro(myMap);
		
		gamePlay(myMap);
		
		
	}

public static void gamePlay(Maze myMap) {
				
		boolean canImove = false;
		boolean didIwin = false;
		
		while (!didIwin) {
			
			while (!canImove) {
				String move = userMove();
				if (move.equalsIgnoreCase("r")) {
					if (myMap.canIMoveRight()) {
						myMap.moveRight();
						canImove = true;
					} else {
						System.out.println("Sorry, you've hit a wall");
					}
				} else if (move.equalsIgnoreCase("l")) {
					if (myMap.canIMoveLeft()) {
						myMap.moveLeft();
						canImove = true;
					} else {
						System.out.println("Sorry, you've hit a wall");
					}
				} else if (move.equalsIgnoreCase("d")) {
					if (myMap.canIMoveDown()) {
						myMap.moveDown();
						canImove = true;
					} else {
						System.out.println("Sorry, you've hit a wall");
					}
				} else if (move.equalsIgnoreCase("u")) {
					if (myMap.canIMoveUp()) {
						myMap.moveUp();
						canImove = true;
					} else {
						System.out.println("Sorry, you've hit a wall");
					}
				}
				
				if (canImove) {
					myMap.printMap();
					canImove = false;
						if (myMap.didIWin()) {
								System.out.println("Congrats you've won!");
								didIwin = true;
				} 
				}
			}
		}
		
			
		
	}
	// Welcome the user to Maze Runner and show them the current state of the Maze. 
	// Separate this intro out into a separate method called "intro()".
	public static void intro(Maze map) {
		System.out.println("Welcome to Maze Runner!");
		System.out.println("Here is your current position:");
		map.printMap();
	}
	
	//  a way to enter in which direction they would like to move, Right (R), Left (L), 
	// Up (U) or Down (D). return a string indicating which direction the user chooses to move in. 
	// This method should guarantee that the user selection is only one of the given options, 
		// and continue to reprompt the user until they enter a desired direction.
	
	public static String userMove() {
		Scanner input = new Scanner(System.in);
		boolean correctInput = false;
		String choice = "";
		
		while (!correctInput){
			System.out.println("Where would you like to move? (R, L, U, D)");
			
			choice = input.nextLine().trim();
			if (choice.equalsIgnoreCase("R")){
				correctInput = true;
				return choice;
			} else if (choice.equalsIgnoreCase("L")){
				correctInput = true;
				return choice;
			} else if (choice.equalsIgnoreCase("U")){
				correctInput = true;
				return choice;
			} else if (choice.equalsIgnoreCase("D")){
				correctInput = true;
				return choice;
			} else {
				System.out.println("Wrong input");
			}			 
		}
		// !! als ik deze return weghaal vind de functie dat hij geen return value meer heeft
		return choice;
	}
	
}
