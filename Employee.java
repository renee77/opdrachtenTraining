
public class Employee {
	private String name;
	private double baseSalary;
	private int employeeId;
	private static int idCount = 0;
	
	Employee(String name, double salary){
		this.name = name;
		this.baseSalary = salary;
		this.employeeId = idCount;
		idCount++;
	}
	
	
	Employee(String name){
		this.name = name;
		this.employeeId = idCount;
		idCount++;
	}
	
	public double getBaseSalary() {
		return this.baseSalary;
	}
	public String getName() {
		return this.name;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
}
