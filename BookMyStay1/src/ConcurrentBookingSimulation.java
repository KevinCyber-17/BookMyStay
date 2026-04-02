import java.util.LinkedList;
import java.util.Queue;

public class ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        // Shared Queue
        Queue<BookingRequest> queue = new LinkedList<>();

        queue.add(new BookingRequest("Abhi", "Single"));
        queue.add(new BookingRequest("Vanmathi", "Double"));
        queue.add(new BookingRequest("Kural", "Suite"));
        queue.add(new BookingRequest("Subha", "Single"));

        // Shared Inventory
        RoomInventory inventory = new RoomInventory();

        // Service
        BookingService service = new BookingService(inventory);

        // Threads
        Thread t1 = new Thread(new BookingProcessor(queue, service));
        Thread t2 = new Thread(new BookingProcessor(queue, service));

        t1.start();
        t2.start();

        // Wait for threads
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final inventory
        inventory.printInventory();
    }
}