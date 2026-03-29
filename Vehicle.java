/**
 * Vehicle.java
 * Abstract base class representing a generic vehicle.
 * Demonstrates ABSTRACTION and ENCAPSULATION.
 */
public abstract class Vehicle {

    // Private fields — Encapsulation
    private String vehicleNumber;
    private String ownerName;

    // Constructor
    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Abstract method — forces subclasses to define their vehicle type.
     * Demonstrates ABSTRACTION and POLYMORPHISM.
     */
    public abstract String getVehicleType();

    /**
     * Overrides toString for clean display of vehicle info.
     */
    @Override
    public String toString() {
        return getVehicleType() + " | Number: " + vehicleNumber + " | Owner: " + ownerName;
    }
}
