/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * Allows guests to attach optional services to reservations
 * without modifying booking or inventory logic.
 *
 * @version 3.1
 */
public class AddOnServiceSelection {

    public static void main(String[] args) {

        // Step 1: Create reservation (already confirmed)
        Reservation r1 = new Reservation("RES-101", "Alice", "Single");

        // Step 2: Create add-on services
        AddOnService wifi = new AddOnService("WiFi", 200);
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1200);

        // Step 3: Initialize manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Step 4: Guest selects services
        manager.addService(r1.getReservationId(), wifi);
        manager.addService(r1.getReservationId(), breakfast);
        manager.addService(r1.getReservationId(), spa);

        // Step 5: Display services & cost
        System.out.println("\nReservation ID: " + r1.getReservationId());
        System.out.println("Guest: " + r1.getGuestName());
        System.out.println("Room Type: " + r1.getRoomType());

        manager.displayServices(r1.getReservationId());
    }
}