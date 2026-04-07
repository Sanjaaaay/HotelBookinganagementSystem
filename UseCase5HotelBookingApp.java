import java.util.Queue;
import java.util.LinkedList;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Guest: " + guestName + " | Room Type: " + roomType);
    }
}

public class UseCase5HotelBookingApp {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Double Room"));
        bookingQueue.add(new Reservation("Charlie", "Suite Room"));

        System.out.println("Book My Stay - Hotel Booking System v5.0\n");
        System.out.println("Booking Requests in Queue:\n");

        for (Reservation r : bookingQueue) {
            r.display();
        }
    }
}