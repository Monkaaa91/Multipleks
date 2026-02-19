import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Screening {

    private final Movie movie;
    private final CinemaHall hall;
    private final LocalDateTime dateTime;
    private final ScreeningType type;
    private final List<Ticket> tickets = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public Screening(Movie movie, CinemaHall hall, LocalDateTime dateTime, ScreeningType type) {
        this.movie = movie;
        this.hall = hall;
        this.dateTime = dateTime;
        this.type = type;

    }

    public void reserveSeats(String[] seatNumbers) {
        List<Seat> seatsToReserve = new ArrayList<>();
        for (String number : seatNumbers) {
            Seat seat = hall.findSeat(number);
            if (seat != null || !seat.isReserved()) {
                seat.reserve();
                seatsToReserve.add(seat);
            } else {
                System.out.println("Seat unavailable: " + number);
            }
            reservations.add(new Reservation(seatsToReserve, this, null));

        }


    }
    public void reservePlaces(Customer customer, String[] seatNumbers) {
        List<Seat> seatsToReserve = new ArrayList<>();

        for (String number : seatNumbers) {
            Seat seat = hall.findSeat(number);

            if (seat == null || seat.isReserved()) {
                System.out.println("Cannot reserve seat: " + number);
                return;
            }

            seatsToReserve.add(seat);
        }

        for (Seat seat : seatsToReserve) {
            seat.reserve();
        }

        reservations.add(new Reservation(seatsToReserve, this, customer));
        System.out.println("Reservation success! " + customer);
    }


    public Ticket buyTicket(String seatNumber, Customer customer) {
        Seat seat = hall.findSeat(seatNumber);

        if (seat == null) {
            System.out.println("");
            return null;
        }

        if (seat.isReserved()) {
            System.out.println("Seat already reserved.");
            return null;
        }

        seat.reserve();

        double price = calculatePrice();
        Ticket ticket = new Ticket(seat, this, customer, price);

        tickets.add(ticket);

        if (customer != null) {
            customer.addTicket(ticket);
        }

        System.out.println("Thank you for purchasing a ticket: " + ticket);
        return ticket;
    }

    private double calculatePrice() {
        switch (type) {
            case VIP:
                return 69.0;
            case THREE_D:
                return 59.0;
            default:
                return 49.0;
        }
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> available = new ArrayList<>();

        for (Seat seat : hall.getSeats()) {
            if (!seat.isReserved()) {
                available.add(seat);
            }
        }

        return available;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return movie.getTitle() +
                " || " + dateTime +
                " || " + type +
                " || Hall: " + hall.getName();
    }
}

