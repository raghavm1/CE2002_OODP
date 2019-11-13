package entities;

/**
 * @author Gan Shyan
 * Entity class which represents a single cinema hall
 */

public class CinemaHall {

    /**
     * Total Number of seats for the cinema hall
     */
    private int numberOfSeats;

    /**
     * Hall number that is unique for cinema halls in a {@link Cineplex}
     */
    private int hallNumber;

    /**
     * Constructor
     *
     * @param hallNumber Unique hall number
     */
    public CinemaHall(int numberOfSeats, int hallNumber) {
        this.numberOfSeats = numberOfSeats;
        this.hallNumber = hallNumber;
    }

    /**
     * Getter for hall number attribute
     *
     * @return hallNumber attribute
     */
    public int getHallNumber() {
        return hallNumber;
    }

    /**
     * Getter for the number of seats
     *
     * @return
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

}
