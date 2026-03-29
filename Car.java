/**
 * Car.java
 * Represents a Car — inherits from Vehicle.
 * Demonstrates INHERITANCE and POLYMORPHISM.
 */
public class Car extends Vehicle {

    // Constructor calls the parent (Vehicle) constructor
    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    /**
     * Overrides abstract method to return this vehicle's type.
     * Polymorphism in action — each subclass defines its own type.
     */
    @Override
    public String getVehicleType() {
        return "Car ";
    }
}
