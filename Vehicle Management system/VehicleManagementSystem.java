// Abstract Base Class: Vehicle
abstract class Vehicle {
    protected String vehicleType;
    protected String numberPlate;
    protected double rentalPricePerDay;

    // Constructor
    public Vehicle(String vehicleType, String numberPlate, double rentalPricePerDay) {
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // Abstract method to display details
    public abstract void displayDetails();

    // Method to calculate rental cost
    public double calculateRentalCost(int daysRented) {
        return daysRented * rentalPricePerDay;
    }
}

// Subclass: Car
class Car extends Vehicle {
    private int numberOfDoors;
    private boolean hasAirConditioning;

    // Constructor
    public Car(String numberPlate, double rentalPricePerDay, int numberOfDoors, boolean hasAirConditioning) {
        super("Car", numberPlate, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Number Plate: " + numberPlate);
        System.out.println("Rental Price Per Day: " + rentalPricePerDay);
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Air Conditioning: " + (hasAirConditioning ? "Yes" : "No"));
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    private boolean isElectric;

    // Constructor
    public Bike(String numberPlate, double rentalPricePerDay, boolean isElectric) {
        super("Bike", numberPlate, rentalPricePerDay);
        this.isElectric = isElectric;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Number Plate: " + numberPlate);
        System.out.println("Rental Price Per Day: " + rentalPricePerDay);
        System.out.println("Electric Bike: " + (isElectric ? "Yes" : "No"));
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    private double loadCapacity; // in tons

    // Constructor
    public Truck(String numberPlate, double rentalPricePerDay, double loadCapacity) {
        super("Truck", numberPlate, rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Number Plate: " + numberPlate);
        System.out.println("Rental Price Per Day: " + rentalPricePerDay);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Main Class
public class VehicleManagementSystem {
    public static void main(String[] args) {
        // Create instances of vehicles
        Car car = new Car("AB123CD", 50.0, 4, true);
        Bike bike = new Bike("EF456GH", 20.0, true);
        Truck truck = new Truck("IJ789KL", 100.0, 10.0);

        // Display vehicle details and calculate rental cost
        System.out.println("Car Details:");
        car.displayDetails();
        System.out.println("Total Rental Cost for 3 days: $" + car.calculateRentalCost(3));
        System.out.println();

        System.out.println("Bike Details:");
        bike.displayDetails();
        System.out.println("Total Rental Cost for 5 days: $" + bike.calculateRentalCost(5));
        System.out.println();

        System.out.println("Truck Details:");
        truck.displayDetails();
        System.out.println("Total Rental Cost for 2 days: $" + truck.calculateRentalCost(2));
    }
}