import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class RoomInventory {
    HashMap<String, Integer> inventory = new HashMap<>();

    RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    void decrement(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

public class UseCase6HotelBookingApp {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Double Room"));
        bookingQueue.add(new Reservation("Charlie", "Suite Room"));

        RoomInventory inventory = new RoomInventory();

        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();

        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());
        allocatedRooms.put("Suite Room", new HashSet<>());

        int idCounter = 1;

        System.out.println("Book My Stay - Hotel Booking System v6.0\n");

        while (!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.poll();

            if (inventory.getAvailability(r.roomType) > 0) {

                String roomId = r.roomType.replace(" ", "").substring(0,2).toUpperCase() + idCounter++;

                allocatedRooms.get(r.roomType).add(roomId);

                inventory.decrement(r.roomType);

                System.out.println("Reservation Confirmed");
                System.out.println("Guest: " + r.guestName);
                System.out.println("Room Type: " + r.roomType);
                System.out.println("Room ID: " + roomId + "\n");

            } else {

                System.out.println("No rooms available for " + r.roomType + " for guest " + r.guestName + "\n");

            }
        }
    }
}