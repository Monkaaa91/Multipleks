import java.time.LocalDateTime;


    public static void main(String[] args) {

        Cinema cinema1 = new Cinema("The Best Cinema", "ul. Akacjowa 22");

        CinemaHall hall1 = new CinemaHall("Sala 1", 7, 12);
        cinema1.addHall(hall1);

        Movie movie1 = new Movie("The Best Movie", 90, "This Movie is the best");

        Screaning screaning1 = new Screaning(
                movie1,
                hall1,
                LocalDateTime.now().plusDays(1),
                ScreaningType.VIP
        );

        cinema1.addScreaning(screaning1);

        cinema1.printProgramme();
        Customer customer = new Customer("Monika", "monika@gmail.com");

        String[] seats = {"S1", "S2", "S3"};
        screaning1.reservePlaces(customer, seats);



        screaning1.buyTicket("S3", customer);

        System.out.println("Available seats: " + screaning1.getAvailableSeats().size());
    }


