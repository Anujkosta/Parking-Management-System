import java.util.Scanner;

/**
 * Main.java
 * Entry point of the Parking Management System.
 * Provides a menu-driven console interface for all operations.
 */
public class Main {

    // Scanner for reading user input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("      PARKING MANAGEMENT SYSTEM v1.0       ");
        System.out.println("============================================");

        // Step 1: Let user configure the lot
        ParkingLot parkingLot = setupParkingLot();

        // Step 2: Show the main menu in a loop
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addVehicleMenu(parkingLot);
                    break;
                case 2:
                    removeVehicleMenu(parkingLot);
                    break;
                case 3:
                    parkingLot.displayAllSlots();
                    break;
                case 4:
                    searchVehicleMenu(parkingLot);
                    break;
                case 5:
                    System.out.println("\n[INFO] Thank you for using the Parking Management System. Goodbye!\n");
                    running = false;
                    break;
                default:
                    System.out.println("[ERROR] Invalid choice. Please enter a number between 1 and 5.\n");
            }
        }

        scanner.close();
    }

    // -------------------------------------------------------
    // SETUP — Customize the parking lot
    // -------------------------------------------------------

    /**
     * Prompts the user to name the lot and set total slots.
     * Demonstrates slot count customization.
     */
    private static ParkingLot setupParkingLot() {
        System.out.print("\nEnter Parking Lot Name (e.g., City Mall Parking): ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Default Parking Lot";

        int slots = getIntInput("Enter Total Number of Parking Slots: ");
        while (slots <= 0) {
            System.out.println("[ERROR] Slot count must be at least 1.");
            slots = getIntInput("Enter Total Number of Parking Slots: ");
        }

        return new ParkingLot(name, slots);
    }

    // -------------------------------------------------------
    // MENU DISPLAY
    // -------------------------------------------------------

    private static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("               MAIN MENU                   ");
        System.out.println("--------------------------------------------");
        System.out.println("  1. Add Vehicle (Car / Bike)");
        System.out.println("  2. Remove Vehicle");
        System.out.println("  3. Display All Parking Slots");
        System.out.println("  4. Search Vehicle by Number");
        System.out.println("  5. Exit");
        System.out.println("--------------------------------------------");
    }

    // -------------------------------------------------------
    // OPTION 1: Add Vehicle
    // -------------------------------------------------------

    private static void addVehicleMenu(ParkingLot lot) {
        System.out.println("\n--- Add Vehicle ---");
        System.out.println("  1. Car");
        System.out.println("  2. Bike");
        int typeChoice = getIntInput("Select Vehicle Type: ");

        if (typeChoice != 1 && typeChoice != 2) {
            System.out.println("[ERROR] Invalid vehicle type.\n");
            return;
        }

        System.out.print("Enter Vehicle Number (e.g., MH12AB1234): ");
        String vehicleNumber = scanner.nextLine().trim().toUpperCase();

        if (vehicleNumber.isEmpty()) {
            System.out.println("[ERROR] Vehicle number cannot be empty.\n");
            return;
        }

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine().trim();
        if (ownerName.isEmpty()) ownerName = "Unknown";

        // Polymorphism — Vehicle reference holds either Car or Bike
        Vehicle vehicle;
        if (typeChoice == 1) {
            vehicle = new Car(vehicleNumber, ownerName);
        } else {
            vehicle = new Bike(vehicleNumber, ownerName);
        }

        lot.addVehicle(vehicle);
        System.out.println();
    }

    // -------------------------------------------------------
    // OPTION 2: Remove Vehicle
    // -------------------------------------------------------

    private static void removeVehicleMenu(ParkingLot lot) {
        System.out.println("\n--- Remove Vehicle ---");
        System.out.print("Enter Vehicle Number to remove: ");
        String vehicleNumber = scanner.nextLine().trim().toUpperCase();

        if (vehicleNumber.isEmpty()) {
            System.out.println("[ERROR] Vehicle number cannot be empty.\n");
            return;
        }

        lot.removeVehicle(vehicleNumber);
        System.out.println();
    }

    // -------------------------------------------------------
    // OPTION 4: Search Vehicle
    // -------------------------------------------------------

    private static void searchVehicleMenu(ParkingLot lot) {
        System.out.println("\n--- Search Vehicle ---");
        System.out.print("Enter Vehicle Number to search: ");
        String vehicleNumber = scanner.nextLine().trim().toUpperCase();

        if (vehicleNumber.isEmpty()) {
            System.out.println("[ERROR] Vehicle number cannot be empty.\n");
            return;
        }

        lot.searchVehicle(vehicleNumber);
        System.out.println();
    }

    // -------------------------------------------------------
    // UTILITY — Safe integer input
    // -------------------------------------------------------

    /**
     * Reads an integer from the user safely, re-prompting on invalid input.
     */
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Please enter a valid number.");
            }
        }
    }
}
