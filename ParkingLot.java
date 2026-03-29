import java.util.ArrayList;

/**
 * ParkingLot.java
 * Core class that manages all parking slots and vehicles.
 * Uses ArrayList (Collection) to store ParkingSlot objects.
 * Demonstrates ENCAPSULATION and use of Collections.
 */
public class ParkingLot {

    private String lotName;
    private int totalSlots;
    private ArrayList<ParkingSlot> slots; // Collection of all slots

    /**
     * Constructor — initializes the lot with a given number of slots.
     * @param lotName   Name of the parking lot
     * @param totalSlots Number of slots to create
     */
    public ParkingLot(String lotName, int totalSlots) {
        this.lotName = lotName;
        this.totalSlots = totalSlots;
        this.slots = new ArrayList<>();

        // Create and add each slot to the list
        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new ParkingSlot(i));
        }

        System.out.println("\n[INFO] Parking lot '" + lotName + "' created with " + totalSlots + " slots.\n");
    }

    // -------------------------------------------------------
    // 1. ADD VEHICLE — Auto-assign first available slot
    // -------------------------------------------------------

    /**
     * Parks a vehicle by finding the first empty slot automatically.
     * @param vehicle The vehicle to park
     * @return true if parked successfully, false if lot is full
     */
    public boolean addVehicle(Vehicle vehicle) {
        // Check if vehicle is already parked
        if (findSlotByVehicleNumber(vehicle.getVehicleNumber()) != -1) {
            System.out.println("[ERROR] Vehicle " + vehicle.getVehicleNumber() + " is already parked in the lot.");
            return false;
        }

        // Find first empty slot
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                slot.parkVehicle(vehicle);
                System.out.println("[SUCCESS] " + vehicle.getVehicleType().trim() + " (" +
                        vehicle.getVehicleNumber() + ") parked at Slot " + slot.getSlotNumber() + ".");
                return true;
            }
        }

        // No empty slot found
        System.out.println("[ERROR] Parking lot is FULL. Cannot park " + vehicle.getVehicleNumber() + ".");
        return false;
    }

    // -------------------------------------------------------
    // 2. REMOVE VEHICLE — by vehicle number
    // -------------------------------------------------------

    /**
     * Removes a parked vehicle by its vehicle number.
     * @param vehicleNumber The number of the vehicle to remove
     * @return true if removed, false if not found
     */
    public boolean removeVehicle(String vehicleNumber) {
        int slotIndex = findSlotByVehicleNumber(vehicleNumber);

        if (slotIndex == -1) {
            System.out.println("[ERROR] Vehicle " + vehicleNumber + " not found in the parking lot.");
            return false;
        }

        ParkingSlot slot = slots.get(slotIndex);
        System.out.println("[SUCCESS] " + slot.getVehicle().getVehicleType().trim() +
                " (" + vehicleNumber + ") removed from Slot " + slot.getSlotNumber() + ".");
        slot.removeVehicle();
        return true;
    }

    // -------------------------------------------------------
    // 3. DISPLAY ALL SLOTS
    // -------------------------------------------------------

    /**
     * Displays all slots with their current status.
     */
    public void displayAllSlots() {
        System.out.println("\n========================================");
        System.out.println("  Parking Lot: " + lotName);
        System.out.println("  Total Slots : " + totalSlots);
        System.out.println("  Occupied    : " + getOccupiedCount());
        System.out.println("  Available   : " + getAvailableCount());
        System.out.println("========================================");
        for (ParkingSlot slot : slots) {
            slot.displaySlot();
        }
        System.out.println("========================================\n");
    }

    // -------------------------------------------------------
    // 4. SEARCH VEHICLE — by vehicle number
    // -------------------------------------------------------

    /**
     * Searches for a vehicle and displays its slot info.
     * @param vehicleNumber The vehicle number to search
     */
    public void searchVehicle(String vehicleNumber) {
        int slotIndex = findSlotByVehicleNumber(vehicleNumber);

        if (slotIndex == -1) {
            System.out.println("[NOT FOUND] No vehicle with number '" + vehicleNumber + "' is currently parked.");
        } else {
            ParkingSlot slot = slots.get(slotIndex);
            System.out.println("[FOUND] " + slot.getVehicle().toString() + " -> Slot " + slot.getSlotNumber());
        }
    }

    // -------------------------------------------------------
    // HELPER METHODS
    // -------------------------------------------------------

    /**
     * Returns the ArrayList index of the slot containing a given vehicle number.
     * Returns -1 if not found.
     */
    private int findSlotByVehicleNumber(String vehicleNumber) {
        for (int i = 0; i < slots.size(); i++) {
            ParkingSlot slot = slots.get(i);
            if (slot.isOccupied() &&
                    slot.getVehicle().getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                return i;
            }
        }
        return -1;
    }

    /** Returns number of occupied slots */
    public int getOccupiedCount() {
        int count = 0;
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied()) count++;
        }
        return count;
    }

    /** Returns number of available (empty) slots */
    public int getAvailableCount() {
        return totalSlots - getOccupiedCount();
    }

    public String getLotName() {
        return lotName;
    }

    public int getTotalSlots() {
        return totalSlots;
    }
}
