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
        for (String seatNumber : seatNumbers) {
            Seat seat = hall.findSeat(seatNumber);
            if (seat != null && !seat.isReserved()) {
                seat.reserve();
                seatsToReserve.add(seat);
            } else {
                System.out.println("Seat unavailable: " + seatNumber);
            }
            reservations.add(new Reservation(seatsToReserve, this, null));

        }


    }
}
