public class DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        PersistenceService persistenceService = new PersistenceService();

        // Load existing data (if any)
        RoomInventory inventory = persistenceService.loadInventory();

        // Print current state
        inventory.printInventory();

        // Save current state
        persistenceService.saveInventory(inventory);
    }
}