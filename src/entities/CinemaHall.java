package entities;

import java.io.Serializable;

/**
 * @author Gan Shyan
 * Entity class which represents a single cinema hall
 */

public class CinemaHall implements Serializable {

	
	static final long serialVersionUID =  -7199465161254546296l;
    public static final int NORMAL_HALL = 1;
    public static final int PLATINUM_MOVIE_SUITE = 2;

    /**
     * Floor plan of the cinema hall
     */
    private FloorPlan floorPlan;

    /**
     * Type of cinema hall
     */
    private int cinemaType;

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
    public CinemaHall(int hallType, FloorPlan floorPlan, int numberOfSeats, int hallNumber, int numberOfBookedSeats) {
        this.cinemaType = hallType;
        this.floorPlan = floorPlan;
        this.numberOfSeats = numberOfSeats;
        this.hallNumber = hallNumber;
        this.numberOfBookedSeats = numberOfBookedSeats;
    }
    
    public CinemaHall(int hallNumber) {
    	this.hallNumber = hallNumber;
    }

    public FloorPlan getFloorPlan() {
        return floorPlan;
    }

    /**
     * Getter for number of booked seats
     *
     * @return
     */
    public int getNumberOfBookedSeats() {
        return numberOfBookedSeats;
    }

    /**
     * Cinema type
     *
     * @return
     */
    public int getCinemaType() {
        return cinemaType;
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

    /**
     * Make a copy of the object and return it
     *
     * @return
     */
    public CinemaHall copy() {
        return new CinemaHall(cinemaType, this.floorPlan.copy(), numberOfSeats, hallNumber, numberOfBookedSeats);
    }

}
