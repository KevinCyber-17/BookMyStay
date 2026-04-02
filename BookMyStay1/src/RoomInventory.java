import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> counters = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        counters.put("Single", 0);
        counters.put("Double", 0);
        counters.put("Suite", 0);
    }

    // 🔐 Critical Section (Thread-safe)
    public synchronized String allocateRoom(String roomType) {

        int available = inventory.getOrDefault(roomType, 0);

        if (available <= 0) {
            return null;
        }

        // decrease inventory
        inventory.put(roomType, available - 1);

        // generate room ID
        int count = counters.get(roomType) + 1;
        counters.put(roomType, count);

        return roomType + "-" + count;
    }

    public void printInventory() {
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));
    }
}