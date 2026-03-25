import java.util.*;

/**
 * Manages add-on services for reservations
 */
public class AddOnServiceManager {

    // Map: ReservationID -> List of Services
    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    /**
     * Add service to a reservation
     */
    public void addService(String reservationId, AddOnService service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added service " + service.getServiceName()
                + " to Reservation " + reservationId);
    }

    /**
     * Get services for a reservation
     */
    public List<AddOnService> getServices(String reservationId) {
        return serviceMap.getOrDefault(reservationId, new ArrayList<>());
    }

    /**
     * Calculate total service cost
     */
    public double calculateTotalCost(String reservationId) {
        double total = 0;

        for (AddOnService service : getServices(reservationId)) {
            total += service.getPrice();
        }

        return total;
    }

    /**
     * Display services
     */
    public void displayServices(String reservationId) {

        List<AddOnService> services = getServices(reservationId);

        if (services.isEmpty()) {
            System.out.println("No add-on services selected.");
            return;
        }

        System.out.println("Selected Services:");
        for (AddOnService s : services) {
            System.out.println("- " + s);
        }

        System.out.println("Total Add-On Cost: ₹" + calculateTotalCost(reservationId));
    }
}