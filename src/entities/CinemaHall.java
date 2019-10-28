package entities;

/**
 * @author Gan Shyan
 * Entity class which represents a single cinema hall
 */

public class CinemaHall {

    /**
     * Hall number that is unique for cinema halls in a {@link Cineplex}
     */
    private int hallNumber;

    /**
     * Constructor
     *
     * @param hallNumber    Unique hall number
     */
    public CinemaHall(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    /**
     * Getter for hall number attribute
     * @return hallNumber attribute
     */
    public int getHallNumber() {
        return hallNumber;
    }

}
