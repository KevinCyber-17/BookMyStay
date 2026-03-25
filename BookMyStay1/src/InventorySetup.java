import java.util.HashMap;
import java.util.Map;

/**
 * RoomInventory - Centralized inventory management
 * @version 3.1
 */
public class InventorySetup {

    // Map to store room type -> available count
    private Map<String, Integer> roomAvailability;

    // Constructor
    public InventorySetup() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    // Initialize default values
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    // Get all availability
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    // Get availability of specific type
    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    // Reduce room count after booking
    public void decrementRoom(String roomType) {
        if (roomAvailability.containsKey(roomType)) {
            roomAvailability.put(roomType, roomAvailability.get(roomType) - 1);
        }
    }
}