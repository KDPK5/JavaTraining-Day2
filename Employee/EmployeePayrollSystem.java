 abstract class Employee {
    protected String name;
    protected int id;
    protected String designation;
    protected double basicSalary;

    // Constructor
    public Employee(String name, int id, String designation, double basicSalary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Method to display employee details
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

class FullTimeEmployee extends Employee {
    private double hra; // House Rent Allowance
    private double da;  // Dearness Allowance

    // Constructor
    public FullTimeEmployee(String name, int id, String designation, double basicSalary, double hra, double da) {
        super(name, id, designation, basicSalary);
        this.hra = hra;
        this.da = da;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + hra + da;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyWage;

    // Constructor
    public PartTimeEmployee(String name, int id, String designation, double hourlyWage, int hoursWorked) {
        super(name, id, designation, 0); // Basic salary is not applicable for part-time employees
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyWage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Hourly Wage: " + hourlyWage);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        // Creating full-time employee
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(
            "Alice",
            101,
            "Software Engineer",
            50000,
            10000,
            5000
        );

        // Creating part-time employee
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(
            "Bob",
            102,
            "Support Staff",
            200,
            30
        );

        // Displaying details and salary
        System.out.println("Full-Time Employee Details:");
        fullTimeEmployee.displayDetails();

        System.out.println("\nPart-Time Employee Details:");
        partTimeEmployee.displayDetails();
    }
}