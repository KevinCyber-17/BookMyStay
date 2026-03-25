import java.util.List;
import java.util.Map;

public class SearchService {

    /**
     * Displays only available rooms (read-only operation)
     */
    public void searchAvailableRooms(RoomInventory inventory, List<Room> rooms) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Available Rooms:\n");

        for (Room room : rooms) {

            int count = availability.getOrDefault(room.getType(), 0);

            // Defensive check: only show available rooms
            if (count > 0) {
                displayRoom(room, count);
            }
        }
    }

    /**
     * Helper method to display room details
     */
    private void displayRoom(Room room, int availableRooms) {
        System.out.println(room.getType() + " Room:");
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSize() + " sqft");
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println();
    }
}