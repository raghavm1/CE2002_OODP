package bookingdbdao;

import java.util.List;

import utilities.CSVFileIO;
import utilities.CSVRow;

/*
 * Class accesses the Booking database
 * @author Lakshyajeet Dwivedee
 */
public class BookingDBDAO {

	/*
	 * Insert a new booking into BookingDB CSV file
     * @param bookingData CSVRow containing the data of the booking
	 */
    public static void insertBooking(CSVRow bookingData) {
    	CSVFileIO.writeToCSV("bookings.csv", bookingData);
    }

    /*
     * Get booking data from the CSV file
     * @return List of CSVRows containing the data of all bookings
     */
    public static List<CSVRow> getBookings() {
    	List<CSVRow> table = CSVFileIO.getParsedCSV("bookings.csv");
    	return table;
    }
}
