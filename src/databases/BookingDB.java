package databases;

import java.util.ArrayList;
import java.util.List;

import entities.Booking;

/**
 * This class represents the database which stores all the Bookings
 *
 * @author Lakshyajeet Dwuvedee
 */

public class BookingDB {

    /**
     * List of all bookings in the database
     */
    private static List<Booking> bookingList = new ArrayList<>();

    private static BookingDB instance;

    /**
     * Private constructor to prevent user to instantiate this class directly
     */
    private BookingDB(){}

    /**
     * Singleton pattern to get the instance of the Booking Database
     * @return
     */
    public static BookingDB getInstance(){
        if(instance == null){
            return new BookingDB();
        } else {
            return instance;
        }
    }

    public List<Booking> getMovieList(){
        return bookingList;
    }
}

