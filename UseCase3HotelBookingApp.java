import java.util.HashMap;

class roominventory {

    private HashMap<String, Integer> inventory;

    public roominventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getavailability(String roomtype) {
        return inventory.get(roomtype);
    }

    public void updateavailability(String roomtype, int count) {
        inventory.put(roomtype, count);
    }

    public void displayinventory() {
        for (String room : inventory.keySet()) {
            System.out.println(room + " Available: " + inventory.get(room));
        }
    }
}

public class UseCase3HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Hotel Booking System v3.1\n");

        roominventory inventory = new roominventory();

        inventory.displayinventory();

        System.out.println("\nAvailability of Single Room: " + inventory.getavailability("Single Room"));

        inventory.updateavailability("Single Room", 4);

        System.out.println("\nAfter Update:");
        inventory.displayinventory();
    }
} 
