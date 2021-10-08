import java.util.*;

public class BattleShips{
	public static void main(String[] args) {
		GamePlay battleShips = new GamePlay();
		battleShips.welcomeToGame();
		battleShips.deployShips();
		
		
		
	}
}

class GamePlay{
	static OceanMap map = new OceanMap();
	static OceanMap computerMap = new OceanMap();
	static Scanner input = new Scanner(System.in);
	
	public static void deployShips() {
		int rowCoor;
		int colCoor;
		for (int i = 0; i < 5; i++) {
			boolean correctLocation = false;
			
			System.out.println("Deploy your ships:");
			
			while (!correctLocation) {
				System.out.println("Enter x coordinate for your ship:");
				rowCoor = input.nextInt();
				System.out.println("Enter y coordinate for your ship:");
				colCoor = input.nextInt();
				
				if ((rowCoor > 1 && rowCoor < 12) && (colCoor > 1 && colCoor < 10) && map.map[rowCoor][colCoor] != '@') {
					map.map[rowCoor][colCoor] = '@';
					correctLocation = true;
				} else {
					System.out.println("Your ship is not at a appropiate location.");
				}
			}
			
		}
		map.printMap();
		
		for (int i = 0; i < 5; i++) {
			boolean emptyLocation = false;
			
			while (!emptyLocation) {
				rowCoor = (int)(Math.random()*9) + 2;
				colCoor = (int)(Math.random()*10) + 1;
				if (computerMap.map[rowCoor][rowCoor] != '@') {
					computerMap.map[rowCoor][colCoor] = '@';
					emptyLocation = true;
				}
			}
		}
		computerMap.printMap();
	}

	public static void welcomeToGame() {
		System.out.println("**** Welcome to Battle Ships game ****");
		System.out.println();
		System.out.println("Right now, the sea is empty");
		System.out.println();
		map.addCoordinates();
		map.printMap();
	}
	
}

class OceanMap{
	static char[][] map = new char[12][14];
	
	public static void printMap() {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col ++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
		
	}
	
	public static void addCoordinates(){
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				// numbers horizontal
				if (row == 0 || row == 11) {
					char letter = '0';
					int indexLetter = letter;
					
					for (int i = 2; i < 12; i++) {
						map[row][i] = letter;
						indexLetter++;
						letter = (char)indexLetter;
					}
				}
				// numbers vertical
				if (col == 0 || col == 13) {
					char letter = '0';
					int indexLetter = letter;
					
					for (int i = 1; i < 11; i++) {
						map[i][col] = letter;
						indexLetter++;
						letter = (char)indexLetter;
					}
				}
								// adding the pipe characters
				if (col == 1 || col == 12) {
					for (int i = 1; i <11; i++) {
						map[i][col] = '|';
					}
				}
			}
		}
		
	}
}
