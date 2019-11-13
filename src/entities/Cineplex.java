package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A entity class which represents a cineplex at a location. It contains different cinema halls {@link CinemaHall}.
 *
 * @author Gan Shyan
 */
public class Cineplex {

    /**
     * The cineplex code for a single Cineplex
     */
    private int cineplexCode;
    /**
     * The address of the cineplex
     */
    private String address;
    /**
     * Name of the cineplex
     */
    private String name;

    /**
     * A list which holds references to all cinema halls {@link CinemaHall} at the particular cineplex location
     */
    private List<CinemaHall> cinemaHallList = new ArrayList<>();


    /**
     * Constructor
     *
     * @param address Address of the entities.Cineplex establishment
     * @param name    Name of the entities.Cineplex establishment
     */
    public Cineplex(int cineplexCode, String address, String name) {
        this.cineplexCode = cineplexCode;
        this.address = address;
        this.name = name;
    }

    /**
     * Getter for cineplex id attribute
     *
     * @return cinplexID attribute
     */
    public int getCineplexCode() {
        return this.cineplexCode;
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
     * @param cinemaHall Add a cinema hall into the list of all cinema halls at the entities.Cineplex location
     */
    protected void addCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHallList.add(cinemaHall);
    }

}
