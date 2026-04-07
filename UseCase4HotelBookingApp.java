import java.util.HashMap;

abstract class Room {
    String type;
    double price;

    Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    void display() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: " + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 2000);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 3500);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 6000);
    }
}

class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

public class UseCase4HotelBookingApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        Room[] rooms = {single, doubleRoom, suite};

        System.out.println("Book My Stay - Hotel Booking System v4.0\n");
        System.out.println("Available Rooms:\n");

        for (Room r : rooms) {
            int available = inventory.getAvailability(r.type);
            if (available > 0) {
                r.display();
                System.out.println("Available: " + available + "\n");
            }
        }
    }
}