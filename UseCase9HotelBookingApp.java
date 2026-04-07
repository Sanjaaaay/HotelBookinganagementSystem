import java.util.*;

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

class RoomInventory {
    HashMap<String, Integer> inventory = new HashMap<>();

    RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 0);
    }

    void validate(String roomType) throws InvalidBookingException {
        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        } else if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException(roomType + " is not available.");
        }
    }

    void bookRoom(String roomType) throws InvalidBookingException {
        validate(roomType);
        inventory.put(roomType, inventory.get(roomType) - 1);
        System.out.println(roomType + " booked successfully!");
    }

    void displayRooms() {
        System.out.println("Available Rooms:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class UseCase9HotelBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoomInventory ri = new RoomInventory();

        ri.displayRooms();

        System.out.print("\nEnter room type to book: ");
        String roomType = sc.nextLine();

        try {
            ri.bookRoom(roomType);
        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("\nUpdated Room Status:");
        ri.displayRooms();

        sc.close();
    }
}