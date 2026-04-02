import java.util.List;

public class BookingReportService {

    public void generateReport(List<Reservation> reservations) {
        System.out.println("\nBooking History and Reporting\n");
        System.out.println("Booking History Report");

        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
}