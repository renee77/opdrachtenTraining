import java.util.Scanner;

public class MazeRunner2 {

	public static void main(String[] args) {
		Maze map = new Maze();
		gamePlay(map);
		
		

	}
	
	public static void gamePlay(Maze map) {
		intro(map);
		
		boolean didIwin = false;
		while (!didIwin) {
			
			boolean canImove = false;
			while (!canImove) {
				String move = userMove();
				if (move.equals("R")) {
					if (map.canIMoveRight()) {
						map.moveRight();
						map.printMap();
						canImove = true;
					} 					
				} else if (move.equals("L")) {
					if (map.canIMoveLeft()) {
						map.moveLeft();
						map.printMap();
						canImove = true;
					}
				} else if (move.equals("U")) {
					if (map.canIMoveUp()) {
						map.moveUp();
						map.printMap();
						canImove = true;
					}
				} else if (move.equals("D")) {
					if (map.canIMoveDown()) {
						map.moveDown();
						map.printMap();
						canImove = true;
					}
				} 
				
				if (!canImove) {
					System.out.println("Sorry you've hit a wall!");
				}
				
				didIwin = map.didIWin();
			}
		}
		
		System.out.println("You won");
	}
	
	
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
			
			choice = input.nextLine().trim().toUpperCase();
			if (choice.equals("R")){
				correctInput = true;
				return choice;
			} else if (choice.equals("L")){
				correctInput = true;
				return choice;
			} else if (choice.equals("U")){
				correctInput = true;
				return choice;
			} else if (choice.equals("D")){
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



