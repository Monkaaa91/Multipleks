import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String name;
    private String address;
    private List<CinemaHall> halls  = new ArrayList<>();
    private List<Screaning> screanings = new ArrayList<>();

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public void addHall(CinemaHall hall){
        halls.add(hall);
    }
    public void addScreaning(Screaning screaning){
        screanings.add(screaning);
    }

    public void printProgramme(){
        for(Screaning s : screanings){
            System.out.println(s);
        }
    }

    public Screaning[] getScreenings(){
        return screanings.toArray(new Screaning[0]);
    }



}

