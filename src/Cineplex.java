import java.util.ArrayList;
import java.util.List;

/**
 * A entity class which represents a cineplex at a location. It contains different cinema halls {@link CinemaHall}.
 *
 * @author Gan Shyan
 */
public class Cineplex {

    private int cineplexID;
    private String address;
    private String name;

    /**
     * A list which holds references to all cinema halls {@link CinemaHall} at the particular cineplex location
     */
    private List<CinemaHall> cinemaHallList = new ArrayList<>();


    /**
     * Constructor
     *
     * @param address Address of the Cineplex establishment
     * @param name    Name of the Cineplex establishment
     */
    public Cineplex(String address, String name) {
        this.address = address;
        this.name = name;
    }

    /**
     * Getter for cineplex id attribute
     *
     * @return cinplexID attribute
     */
    public int getCineplexID() {
        return this.cineplexID;
    }

    /**
     * Getter for address attribute
     *
     * @return address attribute
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Getter for name attribute
     *
     * @return name attribute
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param cinemaHall Add a cinema hall into the list of all cinema halls at the Cineplex location
     */
    protected void addCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHallList.add(cinemaHall);
    }

}
