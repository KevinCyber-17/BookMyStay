import java.util.Map;

/**
 * ============================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * Demonstrates how room availability is managed
 * using a centralized inventory.
 *
 * @version 3.1
 */
public class InventorySetup {

    /**
     * Application entry point
     */
    public static void main(String[] args) {

        // Step 1: Initialize Inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Create Room objects (characteristics)
        Room single = new Room("Single", 1, 250, 1500.0);
        Room doubleroom = new Room("Double", 2, 400, 2500.0);
        Room suite = new Room("Suite", 3, 750, 5000.0);

        // Step 3: Fetch availability
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Step 4: Display inventory
        System.out.println("Hotel Room Inventory Status\n");

        displayRoom(single, availability.get(single.getType()));
        displayRoom(doubleroom, availability.get(doubleroom.getType()));
        displayRoom(suite, availability.get(suite.getType()));
    }

    /**
     * Helper method to display room details
     */
    private static void displayRoom(Room room, int availableRooms) {
        System.out.println(room.getType() + " Room:");
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSize() + " sqft");
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println();
    }
}