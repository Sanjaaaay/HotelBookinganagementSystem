import java.util.*;

class Reservation {
    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class BookingHistory {
    List<Reservation> history = new ArrayList<>();

    void addReservation(Reservation r) {
        history.add(r);
    }

    List<Reservation> getReservations() {
        return history;
    }
}

class BookingReportService {

    void displayBookings(List<Reservation> reservations) {
        for (Reservation r : reservations) {
            System.out.println("Reservation ID: " + r.reservationId);
            System.out.println("Guest: " + r.guestName);
            System.out.println("Room Type: " + r.roomType);
            System.out.println();
        }
    }

    void generateSummary(List<Reservation> reservations) {
        System.out.println("Total Confirmed Bookings: " + reservations.size());
    }
}

public class UseCase8HotelBookingApp {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("RES101", "Alice", "Single Room"));
        history.addReservation(new Reservation("RES102", "Bob", "Double Room"));
        history.addReservation(new Reservation("RES103", "Charlie", "Suite Room"));

        BookingReportService report = new BookingReportService();

        System.out.println("Book My Stay - Hotel Booking System v8.0\n");

        report.displayBookings(history.getReservations());

        report.generateSummary(history.getReservations());
    }
}
