import java.util.LinkedList;
import java.util.Queue;

/**
 * Handles booking requests using FIFO principle
 */
public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /**
     * Add booking request to queue
     */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Request added: " + reservation);
    }

    /**
     * View all requests (without removing)
     */
    public void viewRequests() {
        System.out.println("\nCurrent Booking Queue:");
        for (Reservation r : requestQueue) {
            System.out.println(r);
        }
    }

    /**
     * Process next request (FIFO)
     */
    public Reservation processNextRequest() {
        return requestQueue.poll();
    }

    /**
     * Check if queue is empty
     */
    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }
}