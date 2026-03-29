# Parking Management System

A console-based Parking Management System built in Java using Object-Oriented Programming principles.

---

## Description

This project simulates a real-world parking lot management system. It allows users to park Cars and Bikes, remove vehicles, view all slot statuses, and search for any parked vehicle — all through an interactive menu-driven console interface.

---

## Features

- Add vehicles (Car or Bike) with vehicle number and owner name
- Automatic slot assignment (first available slot)
- Remove a vehicle by its vehicle number
- Display all parking slots (occupied / empty)
- Search for a vehicle by its number
- Customizable parking lot name and slot count at startup
- Handles edge cases:
  - Parking lot full
  - Vehicle not found
  - Duplicate vehicle entry
  - Invalid input (non-numeric menu choices)

---

## Technologies Used

| Technology | Details              |
|------------|----------------------|
| Language   | Java (JDK 8+)        |
| Paradigm   | Object-Oriented (OOP)|
| Interface  | Console / Terminal   |
| Collections| ArrayList            |

---

## Project Structure

```
ParkingManagementSystem/
├── Vehicle.java        # Abstract base class
├── Car.java            # Inherits from Vehicle
├── Bike.java           # Inherits from Vehicle
├── ParkingSlot.java    # Represents a single parking slot
├── ParkingLot.java     # Manages all slots and vehicles
└── Main.java           # Entry point, menu-driven interface
```

---

## How to Run (Step-by-Step)

### Prerequisites
- Java JDK 8 or above installed
- A terminal / command prompt

### Steps

**1. Download or copy all `.java` files into a single folder:**
```
ParkingManagementSystem/
```

**2. Open a terminal and navigate to the folder:**
```bash
cd path/to/ParkingManagementSystem
```

**3. Compile all Java files:**
```bash
javac *.java
```

**4. Run the program:**
```bash
java Main
```

---

## Example Output

```
============================================
      PARKING MANAGEMENT SYSTEM v1.0       
============================================

Enter Parking Lot Name: City Mall Parking
Enter Total Number of Parking Slots: 5

[INFO] Parking lot 'City Mall Parking' created with 5 slots.

--------------------------------------------
               MAIN MENU                   
--------------------------------------------
  1. Add Vehicle (Car / Bike)
  2. Remove Vehicle
  3. Display All Parking Slots
  4. Search Vehicle by Number
  5. Exit
--------------------------------------------
Enter your choice: 1

--- Add Vehicle ---
  1. Car
  2. Bike
Select Vehicle Type: 1
Enter Vehicle Number: MH12AB1234
Enter Owner Name: Rahul Sharma

[SUCCESS] Car (MH12AB1234) parked at Slot 1.

Enter your choice: 3

========================================
  Parking Lot: City Mall Parking
  Total Slots : 5
  Occupied    : 1
  Available   : 4
========================================
  Slot 1 [OCCUPIED] -> Car  | Number: MH12AB1234 | Owner: Rahul Sharma
  Slot 2 [EMPTY]
  Slot 3 [EMPTY]
  Slot 4 [EMPTY]
  Slot 5 [EMPTY]
========================================

Enter your choice: 2
--- Remove Vehicle ---
Enter Vehicle Number to remove: MH12AB1234

[SUCCESS] Car (MH12AB1234) removed from Slot 1.

Enter your choice: 5

[INFO] Thank you for using the Parking Management System. Goodbye!
```

---

## OOP Concepts Used

| Concept       | Where Applied                                      |
|---------------|----------------------------------------------------|
| Encapsulation | Private fields with getters in all classes         |
| Abstraction   | `Vehicle` is abstract with `getVehicleType()`      |
| Inheritance   | `Car` and `Bike` extend `Vehicle`                  |
| Polymorphism  | `Vehicle` reference holds `Car` or `Bike` objects  |

---

## Author

**Student Name:** [Your Name]  
**Course:** [Your Course Name]  
**University:** [Your University Name]  
**Submission Year:** 2025
