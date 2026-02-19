import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String email;
    private List<Ticket> tickets = new ArrayList<>();

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

}
