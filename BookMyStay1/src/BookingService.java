public class BookingService {

    private RoomInventory inventory;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void processBooking(BookingRequest request) {

        String roomId = inventory.allocateRoom(request.getRoomType());

        if (roomId != null) {
            System.out.println("Booking confirmed for Guest: "
                    + request.getGuestName()
                    + ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for Guest: "
                    + request.getGuestName()
                    + " (No rooms available)");
        }
    }
}