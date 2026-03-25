/**
 * ============================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ============================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * Demonstrates how booking requests are handled fairly
 * using a queue (FIFO).
 *
 * @version 3.1
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Step 1: Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Step 2: Guests submit booking requests
        bookingQueue.addRequest(new Reservation("Alice", "Single"));
        bookingQueue.addRequest(new Reservation("Bob", "Double"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite"));
        bookingQueue.addRequest(new Reservation("David", "Single"));

        // Step 3: View queue (arrival order)
        bookingQueue.viewRequests();

        // Step 4: Process requests in FIFO order
        System.out.println("\nProcessing Requests:\n");

        while (!bookingQueue.isEmpty()) {
            Reservation r = bookingQueue.processNextRequest();
            System.out.println("Processing: " + r);
        }
    }
}