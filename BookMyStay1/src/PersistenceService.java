import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME = "inventory.dat";

    // Save inventory to file
    public void saveInventory(RoomInventory inventory) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    // Load inventory from file
    public RoomInventory loadInventory() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (RoomInventory) ois.readObject();

        } catch (Exception e) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return new RoomInventory();
        }
    }
}