public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Step 1: Initialize components
        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        // Step 2: Add booking requests (FIFO)
        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Double"));
        queue.addRequest(new Reservation("Charlie", "Single"));
        queue.addRequest(new Reservation("David", "Suite"));
        queue.addRequest(new Reservation("Eve", "Suite")); // should fail

        // Step 3: Process queue
        while (!queue.isEmpty()) {
            Reservation r = queue.getNextRequest();
            service.allocateRoom(r, inventory);
        }

        // Step 4: Final inventory state
        System.out.println("Final Inventory:");
        System.out.println(inventory.getAll());
    }
}