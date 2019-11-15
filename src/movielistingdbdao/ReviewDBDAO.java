package movielistingdbdao;

import java.util.List;

import utilities.CSVFileIO;
import utilities.CSVRow;

/*
 * Class accesses the Reviews database
 * @author Lakshyajeet Dwivedee
 */
public class ReviewDBDAO {
	/*
	 * Insert a new review into ReviewDB CSV file
     * @param reviewData CSVRow containing the data of the booking
	 */
    public static void insertReview(CSVRow bookingData) {
    	CSVFileIO.writeToCSV("reviews.csv", bookingData);
    }

    /*
     * Get reviews data from the CSV file
     * @return List of CSVRows containing the data of all reviews
     */
    public static List<CSVRow> getReviews() {
    	List<CSVRow> table = CSVFileIO.getParsedCSV("src/reviews.csv");
    	return table;
    }
}