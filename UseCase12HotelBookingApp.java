import java.io.*;
import java.util.*;

class Reservation implements Serializable {
    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class SystemState implements Serializable {
    HashMap<String, Integer> inventory;
    List<Reservation> bookings;

    SystemState(HashMap<String, Integer> inventory, List<Reservation> bookings) {
        this.inventory = inventory;
        this.bookings = bookings;
    }
}

public class UseCase12HotelBookingApp {

    public static void main(String[] args) {

        String fileName = "system_state.dat";

        HashMap<String, Integer> inventory = new HashMap<>();
        List<Reservation> bookings = new ArrayList<>();

        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);

        bookings.add(new Reservation("RES101", "Alice", "Single Room"));
        bookings.add(new Reservation("RES102", "Bob", "Double Room"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(new SystemState(inventory, bookings));
            out.close();
            System.out.println("State saved successfully\n");
        } catch (Exception e) {
            System.out.println("Error saving state");
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            SystemState state = (SystemState) in.readObject();
            in.close();

            System.out.println("Recovered Inventory:");
            for (String key : state.inventory.keySet()) {
                System.out.println(key + " Available: " + state.inventory.get(key));
            }

            System.out.println("\nRecovered Bookings:");
            for (Reservation r : state.bookings) {
                System.out.println(r.reservationId + " | " + r.guestName + " | " + r.roomType);
            }

        } catch (Exception e) {
            System.out.println("No previous data found or file corrupted");
        }
    }
}
