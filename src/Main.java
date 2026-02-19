import java.time.LocalDateTime;


    public static void main(String[] args) {

        Cinema cinema1 = new Cinema("The Best Cinema", "ul. Akacjowa 22");

        CinemaHall hall1 = new CinemaHall("Sala 1", 7, 12);
        cinema1.addHall(hall1);

        Movie movie1 = new Movie("The Best Movie", 90, "This Movie is the best");

        Screening screening1 = new Screening(
                movie1,
                hall1,
                LocalDateTime.now().plusDays(1),
                ScreeningType.VIP
        );

        cinema1.addScreening(screening1);

        cinema1.printProgramme();
        Customer customer = new Customer("Monika", "monika@gmail.com");

        String[] seats = {"S1", "S2", "S3"};
        screening1.reservePlaces(customer, seats);



        screening1.buyTicket("S3", customer);

        System.out.println("Available seats: " + screening1.getAvailableSeats().size());
    }


