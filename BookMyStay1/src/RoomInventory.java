import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> availability = new HashMap<>();

    public RoomInventory() {
        availability.put("Single", 2);
        availability.put("Double", 1);
        availability.put("Suite", 1);
    }

    public int getAvailableRooms(String type) {
        return availability.getOrDefault(type, 0);
    }

    public void decrementRoom(String type) {
        availability.put(type, availability.get(type) - 1);
    }

    public Map<String, Integer> getAll() {
        return availability;
    }
}