import java.util.*;

class Reservation {
    String reservationId;
    String roomType;
    String roomId;

    Reservation(String reservationId, String roomType, String roomId) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.roomId = roomId;
    }
}

class RoomInventory {
    HashMap<String, Integer> inventory = new HashMap<>();

    RoomInventory() {
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 0);
    }

    void increment(String type) {
        inventory.put(type, inventory.get(type) + 1);
    }

    void display() {
        for (String key : inventory.keySet()) {
            System.out.println(key + " Available: " + inventory.get(key));
        }
    }
}

public class UseCase10HotelBookingApp {

    public static void main(String[] args) {

        HashMap<String, Reservation> bookings = new HashMap<>();
        Stack<String> rollbackStack = new Stack<>();
        RoomInventory inventory = new RoomInventory();

        Reservation r1 = new Reservation("RES101", "Single Room", "SI1");
        bookings.put(r1.reservationId, r1);

        System.out.println("Book My Stay - Hotel Booking System v10.0\n");

        System.out.println("Before Cancellation:");
        inventory.display();

        String cancelId = "RES101";

        if (bookings.containsKey(cancelId)) {

            Reservation r = bookings.get(cancelId);

            rollbackStack.push(r.roomId);

            inventory.increment(r.roomType);

            bookings.remove(cancelId);

            System.out.println("\nCancellation Successful for " + cancelId);
            System.out.println("Released Room ID: " + rollbackStack.peek());

        } else {

            System.out.println("Invalid Reservation ID");
        }

        System.out.println("\nAfter Cancellation:");
        inventory.display();
    }
}
