import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BookingCancellation {

    public static void main(String[] args) {

        // Booking storage
        Map<String, Reservation> bookingMap = new HashMap<>();
        bookingMap.put("Single-1", new Reservation("Single-1", "Single"));

        // Stack for rollback
        Stack<String> rollbackStack = new Stack<>();

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Service
        CancellationService service =
                new CancellationService(bookingMap, rollbackStack, inventory);

        System.out.println("Booking Cancellation");

        // Perform cancellation
        service.cancelBooking("Single-1");

        // Show rollback history
        service.showRollbackHistory();

        // Show updated inventory
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getAvailability("Single"));
    }
}