import java.util.*;

public class Fraction {
	private int numerator;
	private int denominator;
	
	// constructor met voorwaarden
	Fraction(int numerator, int denominator){
		if (denominator == 0) {
			throw new IllegalArgumentException("Denominator cant be zero");
		} else if (numerator <0 && denominator < 0) { // num and denom are negative, drop the negatives
			this.numerator = Math.abs(numerator);
			this.denominator = Math.abs(denominator);
		} else if (denominator < 0){ // denom is negative, move negative to num
			this.numerator = -1 * numerator;
			this.denominator = Math.abs(denominator);
		} else {
			this.numerator = numerator;
			this.denominator = denominator;
		}		
	}
	
	// constructor voor num, waar denom = 1
	Fraction(int numerator){
		this(numerator, 1);
	}
	
	// constr zero param num = 0 & denom = 1 -> object = 0
	Fraction(){
		this(0,1);
	}
	
	//methods
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public String toString() {
		return Integer.toString(numerator) + "/" + Integer.toString(denominator);		
	}
	
	public double toDouble() {
		return numerator / denominator;
	}
	
	public Fraction add(Fraction other) {
		Fraction sum = new Fraction();
		if (this.denominator != other.denominator) {
			sum.numerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
			sum.denominator = this.denominator * other.denominator;
		} else {
			sum.numerator = this.numerator + other.numerator;
			sum.denominator = this.denominator;
		}
		
		return sum;
	}
	
	public Fraction subtract(Fraction other) {
		Fraction sum = new Fraction();
		if (this.denominator != other.denominator) {
			sum.numerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
			sum.denominator = this.denominator * other.denominator;
		} else {
			sum.numerator = this.numerator - other.numerator;
			sum.denominator = this.denominator;
		}
		
		return sum;
	}
	
	public Fraction multiply(Fraction other) {
		Fraction sum = new Fraction();
		sum.numerator = this.numerator * other.numerator;
		sum.denominator = this.denominator * other.denominator;
		return sum;
	}
	
	public Fraction divide(Fraction other) {
		Fraction sum = new Fraction();
		int tempNum = other.numerator;
		int tempDenom = other.denominator;
		other.numerator = tempDenom;
		other.denominator = tempNum;
		sum.numerator = this.numerator * other.numerator;
		sum.denominator = this.denominator * other.denominator;
		return sum;
	}
	
	// method needs Object as a parameter to override the Object equals() method
	public boolean equals(Object other) {
		if (other instanceof Fraction) {
			Fraction otherFraction = (Fraction) other;
			if ((this.numerator / this.denominator) == (otherFraction.numerator / otherFraction.denominator)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void toLowestTerms() {
		int gcd = gcd(this.numerator, this.denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;
	}
	
	public static int gcd(int a, int b) {
		int highestNumber;
		int lowestNumber;
		
		// Euclidean algorithm divide a/b, b -> a remainder -> b aslong as b != 0 then a = gcd
		if(a > b) {
			highestNumber = Math.abs(a);
			lowestNumber = Math.abs(b);
		} else  if (b > a){
			highestNumber = Math.abs(b);
			lowestNumber = Math.abs(a);
		} else {
			return a;
		}
		
		while (lowestNumber != 0){
			int rest = highestNumber % lowestNumber;
			highestNumber = lowestNumber;
			lowestNumber = rest;
		}
		
		return highestNumber;
	}
}
