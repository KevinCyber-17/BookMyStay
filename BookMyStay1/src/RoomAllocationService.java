import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoomAllocationService {

    // Map: RoomType -> Set of allocated Room IDs
    private Map<String, Set<String>> allocatedRooms = new HashMap<>();

    // Global set to ensure uniqueness
    private Set<String> allRoomIds = new HashSet<>();

    /**
     * Process booking request and allocate room
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String type = reservation.getRoomType();

        // Step 1: Check availability
        if (inventory.getAvailableRooms(type) <= 0) {
            System.out.println("Booking Failed for " + reservation.getGuestName()
                    + " (No " + type + " rooms available)");
            return;
        }

        // Step 2: Generate unique Room ID
        String roomId = generateRoomId(type);

        // Step 3: Ensure uniqueness using Set
        while (allRoomIds.contains(roomId)) {
            roomId = generateRoomId(type);
        }

        allRoomIds.add(roomId);

        // Step 4: Map room type to allocated rooms
        allocatedRooms.putIfAbsent(type, new HashSet<>());
        allocatedRooms.get(type).add(roomId);

        // Step 5: Update inventory immediately
        inventory.decrementRoom(type);

        // Step 6: Confirm booking
        System.out.println("Booking Confirmed!");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Type: " + type);
        System.out.println("Assigned Room ID: " + roomId);
        System.out.println();
    }

    /**
     * Generates a room ID (e.g., SINGLE-101)
     */
    private String generateRoomId(String type) {
        int number = (int)(Math.random() * 900) + 100;
        return type.toUpperCase() + "-" + number;
    }
}