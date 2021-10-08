import java.util.*;

public class Test {
	public static void main (String [] args) {
				
	}
	
	// recursive programming, methode roept zich zelf aan.
	public static int factorial(int n) {
		if (n == 1) { return 1; }
		return n * factorial(n-1);
	}
	
	// recursive
	public static String starString(int n) { 
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n == 0) {
			return "*";
		} else {
			return starString(n - 1).concat(starString(n-1));
		}
	}
	
	public static String repeat(String s, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("No negative values allowed");
		} else if (n == 0){
			return "";
		} else if (n == 1) {
			return s;
		} else if (n % 2 == 0){
			return s + s.concat(repeat(s, n -2));
		} else {
			return s.concat(repeat(s, n - 1));
		}

	}
	
	// int n tot de macht n van 2, omgezet in lijnen van sterren
		public static int starStringNr(int n) {
			if (n < 0) {
				System.out.println("IllegalArgumentException");
				return -1;			
			} else if (n == 0) {
				System.out.println("*");
				return 1;
			} else {
				int sum = 2 * starStringNr(n -1);
				for (int i = 0; i < sum; i++) {
					System.out.print("*");
				}
				System.out.println();
				return sum;
				
			}
		}
		


	public static void forLoops() {
		
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		for (int i = 0; i < 3; i++) {
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 3; x++) {
					System.out.print(y);
				}
			}
			System.out.println();
		}
		
	}
	
	public static void longestName(Scanner console, int n) {
		ArrayList<String> namen = new ArrayList<String>();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("name #" + i + "? " );
			namen.add(console.nextLine());
		}
		
		String langsteNaam = "a";
		boolean tie = false;
		
		for (String naam: namen) {
			if (naam.length() > langsteNaam.length()) {
				langsteNaam = naam;	
				if (tie) {
					tie = false;
				}
			} 	else if (langsteNaam.length() == naam.length()) {
				tie = true;
			}
		}
		
		langsteNaam = langsteNaam.toLowerCase();
		langsteNaam = langsteNaam.substring(0,1).toUpperCase() + langsteNaam.substring(1);
		
		System.out.println(langsteNaam + "'s name is longest");
		if (tie) {
			System.out.println("(There was a tie!)");
		}

		
	}
}

