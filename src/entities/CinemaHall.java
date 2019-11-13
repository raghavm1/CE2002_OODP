package entities;

/**
 * @author Gan Shyan
 * Entity class which represents a single cinema hall
 */

public class CinemaHall {

    /**
     * Floor plan of the cinema hall
     */
    private FloorPlan floorPlan;

    /**
     * Total Number of seats for the cinema hall
     */
    private int numberOfSeats;

    /**
     * Number of seats that have already been booked
     */
    private int numberOfBookedSeats;

    /**
     * Hall number that is unique for cinema halls in a {@link Cineplex}
     */
    private int hallNumber;

    /**
     * Constructor
     *
     * @param hallNumber Unique hall number
     */
    public CinemaHall(FloorPlan floorPlan,int numberOfSeats, int hallNumber, int numberOfBookedSeats) {
        this.floorPlan = floorPlan;
        this.numberOfSeats = numberOfSeats;
        this.hallNumber = hallNumber;
        this.numberOfBookedSeats = numberOfBookedSeats;
    }

    public FloorPlan getFloorPlan() {
        return floorPlan;
    }

    public int getNumberOfBookedSeats() {
        return numberOfBookedSeats;
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
