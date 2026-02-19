import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String name;
    private String address;
    private List<CinemaHall> halls  = new ArrayList<>();
    private List<Screening> screenings = new ArrayList<>();

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public void addHall(CinemaHall hall){
        halls.add(hall);
    }
    public void addScreening(Screening screening){
        screenings.add(screening);
    }

    public void printProgramme(){
        for(Screening s : screenings){
            System.out.println(s);
        }
    }

    public Screening[] getScreenings(){
        return screenings.toArray(new Screening[0]);
    }



}

