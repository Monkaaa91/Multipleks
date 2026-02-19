
public class Ticket {

    private final Seat seat;
    private final Screaning screaning;
    private final Customer owner;
    private final double price;

    public Ticket (Seat seat, Screaning screaning, Customer owner, double price){
        this.seat = seat;
        this.screaning = screaning;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Ticket for " + screaning + " seat: " + seat + " price: " + price;
    }


}
