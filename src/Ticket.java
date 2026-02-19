
public class Ticket {

    private final Seat seat;
    private final Screening screening;
    private final Customer owner;
    private final double price;

    public Ticket (Seat seat, Screening screening, Customer owner, double price){
        this.seat = seat;
        this.screening = screening;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Ticket for " + screening + " seat: " + seat + " price: " + price;
    }


}
