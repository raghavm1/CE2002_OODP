/**
 * A entity that represents the floor plan for a single {@link CinemaHall}
 *
 * @author Gan Shyan
 */
public class FloorPlan {

    /**
     * Enum that represents the state per cell in the {@link #seatingPlan}
     */
    private enum SEAT_AVAILABILITY {
        NOT_A_SEAT, FREE, OCCUPIED
    }

    /**
     * Number of seats for a cinema hall
     */
    private int numberOfSeats;

    /**
     * A 2D array which represents the seating plan
     */
    private int[][] seatingPlan;

    /**
     * Getter for number of seats
     *
     * @return numberOfSeats attribute
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

}
