import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * Allows guests to view available rooms without modifying system state.
 *
 * @version 3.1
 */
public class RoomSearch {

    public static void main(String[] args) {

        // Step 1: Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Create room objects
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Single", 1, 250, 1500.0));
        rooms.add(new Room("Double", 2, 400, 2500.0));
        rooms.add(new Room("Suite", 3, 750, 5000.0));

        // Step 3: Search Service (Read-only)
        SearchService searchService = new SearchService();

        // Step 4: Perform search
        searchService.searchAvailableRooms(inventory, rooms);
    }
}