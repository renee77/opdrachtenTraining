import java.util.Scanner;
// 2 vragen
public class Klooien {

	public static void main(String[] args) {
		Car myCar  = new Car();
		
		// waarom komt hier vroom uit en hoef ik niet myCar.toString() te zetten?
		System.out.println(myCar);

	}
	
	
	

}


class Car{
	public void m1() {
		System.out.println("car 1");
	}
	public String toString() {
		return ("vroom");
	}
}

