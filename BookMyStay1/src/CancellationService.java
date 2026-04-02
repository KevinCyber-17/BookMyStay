import java.util.Map;
import java.util.Stack;

public class CancellationService {

    private Map<String, Reservation> bookingMap;
    private Stack<String> rollbackStack;
    private RoomInventory inventory;

    public CancellationService(Map<String, Reservation> bookingMap,
                               Stack<String> rollbackStack,
                               RoomInventory inventory) {
        this.bookingMap = bookingMap;
        this.rollbackStack = rollbackStack;
        this.inventory = inventory;
    }

    public void cancelBooking(String reservationId) {

        // Validation
        if (!bookingMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        Reservation res = bookingMap.get(reservationId);

        // Push to stack (LIFO rollback)
        rollbackStack.push(reservationId);

        // Restore inventory
        inventory.increment(res.getRoomType());

        // Remove booking
        bookingMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: "
                + res.getRoomType());
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");

        for (String id : rollbackStack) {
            System.out.println("Released Reservation ID: " + id);
        }
    }
}