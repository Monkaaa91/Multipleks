import java.util.ArrayList;
import java.util.List;

public class CinemaHall {
    private String name;
    private List<Seat> seats;

    public CinemaHall(String name, int rows, int seatsPerRow) {
        this.name = name;
        this.seats = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            char rowLetter = (char) ('A' + r);

            for (int i = 1; i <= seatsPerRow; i++) {
                seats.add(new Seat(rowLetter + "" + i));
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat findSeat(String number) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(number)) {
                return seat;
            }
        }
        return null;


    }
}
