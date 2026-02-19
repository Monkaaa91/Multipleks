import java.util.List;

public class Reservation {
    private final List<Seat> seats;
    private final Screaning screaning;
    private final Customer customer;

    public Reservation(List<Seat> seats, Screaning screaning, Customer customer) {
        this.seats = seats;
        this.screaning = screaning;
        this.customer = customer;
    }
}
