import java.util.*;

class Service {
    String name;
    double cost;

    Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

class AddOnServiceManager {

    HashMap<String, List<Service>> reservationServices = new HashMap<>();

    void addService(String reservationId, Service service) {
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    double calculateTotalCost(String reservationId) {
        double total = 0;
        List<Service> services = reservationServices.get(reservationId);
        if (services != null) {
            for (Service s : services) {
                total += s.cost;
            }
        }
        return total;
    }

    void displayServices(String reservationId) {
        List<Service> services = reservationServices.get(reservationId);
        if (services != null) {
            System.out.println("Services for Reservation " + reservationId + ":");
            for (Service s : services) {
                System.out.println(s.name + " - " + s.cost);
            }
        }
    }
}

public class UseCase7HotelBookingApp {

    public static void main(String[] args) {

        String reservationId = "RES101";

        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService(reservationId, new Service("Breakfast", 500));
        manager.addService(reservationId, new Service("Airport Pickup", 1200));
        manager.addService(reservationId, new Service("Spa Access", 800));

        System.out.println("Book My Stay - Hotel Booking System v7.0\n");

        manager.displayServices(reservationId);

        System.out.println("\nTotal Add-On Cost: " + manager.calculateTotalCost(reservationId));
    }
}
