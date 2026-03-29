/**
 * Bike.java
 * Represents a Bike — inherits from Vehicle.
 * Demonstrates INHERITANCE and POLYMORPHISM.
 */
public class Bike extends Vehicle {

    // Constructor calls the parent (Vehicle) constructor
    public Bike(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    /**
     * Overrides abstract method to return this vehicle's type.
     */
    @Override
    public String getVehicleType() {
        return "Bike";
    }
}
