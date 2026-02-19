import java.util.List;

public class Reservation {
    private final List<Seat> seats;
    private final Screening screening;
    private final Customer customer;

    public Reservation(List<Seat> seats, Screening screening, Customer customer) {
        this.seats = seats;
        this.screening = screening;
        this.customer = customer;
    }
}
