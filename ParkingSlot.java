/**
 * ParkingSlot.java
 * Represents a single parking slot in the lot.
 * Demonstrates ENCAPSULATION — all fields are private with controlled access.
 */
public class ParkingSlot {

    private int slotNumber;       // Unique slot ID
    private Vehicle vehicle;      // Parked vehicle (null if empty)
    private boolean isOccupied;   // Quick flag for slot status

    // Constructor — creates an empty slot
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.vehicle = null;
        this.isOccupied = false;
    }

    // --- Getters ---

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // --- Slot Operations ---

    /**
     * Parks a vehicle in this slot.
     * @param vehicle The vehicle to park
     */
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    /**
     * Removes the vehicle from this slot, making it empty.
     */
    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    /**
     * Displays the current state of this slot.
     */
    public void displaySlot() {
        if (isOccupied) {
            System.out.println("  Slot " + slotNumber + " [OCCUPIED] -> " + vehicle.toString());
        } else {
            System.out.println("  Slot " + slotNumber + " [EMPTY]");
        }
    }
}
