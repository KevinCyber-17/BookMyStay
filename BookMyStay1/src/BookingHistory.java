import java.util.ArrayList;
import java.util.List;

public class BookingHistory {
    private List<Reservation> reservations;

    public BookingHistory() {
        reservations = new ArrayList<>();
    }

    // Add confirmed booking
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Retrieve all bookings
    public List<Reservation> getReservations() {
        return reservations;
    }
}