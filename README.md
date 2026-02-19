## Class Diagram

@startuml

class Cinema {
    - name: String
    - address: String
    - halls: List<CinemaHall>
    - screenings: List<Screening>
    + printProgramme()
    + getScreenings(): Screening[]
    + addHall(hall: CinemaHall)
    + addScreening(screening: Screening)
}

class CinemaHall {
    - name: String
    - seats: List<Seat>
    + getSeats(): List<Seat>
    + findSeat(number: String): Seat
}

class Screening {
    - movie: Movie
    - hall: CinemaHall
    - dateTime: LocalDateTime
    - type: ScreeningType
    - tickets: List<Ticket>
    - reservations: List<Reservation>
    + reserveSeats(seatNumbers: String[])
    + reservePlaces(customer: Customer, seatNumbers: String[])
    + buyTicket(seatNumber: String, customer: Customer): Ticket
    + getAvailableSeats(): List<Seat>
}

class Movie {
    - title: String
    - duration: int
    - description: String
    + getTitle(): String
}

class Seat {
    - seatNumber: String
    - reserved: boolean
    + getSeatNumber(): String
    + isReserved(): boolean
    + reserve()
}

class Ticket {
    - seat: Seat
    - screening: Screening
    - owner: Customer
    - price: double
}

class Reservation {
    - seats: List<Seat>
    - screening: Screening
    - customer: Customer
}

class Customer {
    - name: String
    - email: String
    - tickets: List<Ticket>
    + getTickets(): List<Ticket>
    + addTicket(ticket: Ticket)
}

enum ScreeningType {
    STANDARD
    VIP
    THREE_D
}

Cinema "1" -- "*" CinemaHall
Cinema "1" -- "*" Screening
Screening "*" -- "1" Movie
Screening "*" -- "1" CinemaHall
Screening "1" -- "*" Ticket
Screening "1" -- "*" Reservation
CinemaHall "1" -- "*" Seat
Customer "1" -- "*" Ticket
Customer "1" -- "*" Reservation

@enduml
