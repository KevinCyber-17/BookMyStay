import java.util.Queue;

public class BookingProcessor implements Runnable {

    private Queue<BookingRequest> queue;
    private BookingService service;

    public BookingProcessor(Queue<BookingRequest> queue, BookingService service) {
        this.queue = queue;
        this.service = service;
    }

    @Override
    public void run() {
        while (true) {

            BookingRequest request;

            // 🔐 synchronized access to shared queue
            synchronized (queue) {
                if (queue.isEmpty()) {
                    break;
                }
                request = queue.poll();
            }

            if (request != null) {
                service.processBooking(request);
            }
        }
    }
}