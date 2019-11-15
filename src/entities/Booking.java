package entities;

import java.util.ArrayList;
import java.time.LocalDateTime;

/*
 * Entity class representing a Booking
 * @author Lakshyajeet Dwivedee
 */
public class Booking {
	

	/*
	 * Store the booking's transaction ID
	 */
	private String transactionID;

	/*
	 * Store the name of the customer
	 */
	private String customerName;

	/*
	 * Store the email ID of the customer
	 */
	private String emailID;

	/*
	 * Store the mobile number of the customer
	 */
	private int mobileNumber;

	/*
	 * Store the name of the movie
	 */
	private String movieName;

	/*
	 * Store the ID of the cinema hall
	 */
	private String cinemaHallID;

	/*
	 * Store the name of the cineplex
	 */
	private String cineplexName;
	
	/*
	 * Constructor called when a new booking is made
     *
     * @param customerName Name of customer making the booking
     * @param emailID Email ID entered by customer making the booking
     * @param mobileNumber Mobile number entered by the customer making the booking
     * @param movie Movie for which booking is being made
     * @param cinemaHall Cinema hall in which movie was shown
     * @param cinePlex Cineplex in which movie was booked
	 */
	public Booking(String customerName, String emailID, int mobileNumber, String movieName, String cinemaHallID, String cineplexName) {
		this.customerName = customerName;
		this.emailID = emailID;
		this.mobileNumber = mobileNumber;
		this.movieName = movieName;
		this.cinemaHallID = cinemaHallID;
		this.cineplexName = cineplexName;
		this.transactionID = String.valueOf(LocalDateTime.now().getYear()) + String.valueOf(LocalDateTime.now().getMonthValue()) + String.valueOf(LocalDateTime.now().getDayOfYear()) + String.valueOf(LocalDateTime.now().getHour()) + String.valueOf(LocalDateTime.now().getMinute()) + String.valueOf(cinemaHallID);
	}
	
	/*
	 * Constructor called when an older booking is being retrieved
     *
     * @param customerName Name of customer making the booking
     * @param emailID Email ID entered by customer making the booking
     * @param mobileNumber Mobile number entered by the customer making the booking
     * @param movie Movie for which booking is being made
     * @param cinemaHall Cinema hall in which movie was shown
     * @param cinePlex Cineplex in which movie was booked
     * @param transactionID Transaction ID of this booking
	 */
	public Booking(String customerName, String emailID, int mobileNumber, String movieName, String cinemaHallID, String cineplexName, String transactionID) {
		this.customerName = customerName;
		this.emailID = emailID;
		this.mobileNumber = mobileNumber;
		this.movieName = movieName;
		this.cinemaHallID = cinemaHallID;
		this.cineplexName = cineplexName;
		this.transactionID = transactionID;
	}

	/*
	 * Returns the email ID of the customer who made the booking
	 * @return The email ID of the customer who made the booking
	 */
	public String getEmailID() {
		return this.emailID;
	}

	/*
	 * Returns the name of the customer who made the booking
	 * @return The name of the customer who made the booking
	 */
	public String getCustomerName() {
		return this.customerName;
	}

	/*
	 * Returns the mobile number of the customer who made the booking
	 * @return The mobile number of the customer who made the booking 
	 */
	public int getMobileNumber() {
		return this.mobileNumber;
	}

	/*
	 * Returns the movie for which booking was made
	 * @return The movie for which booking was made
	 */
	public String getMovieName() {
		return this.movieName;
	}

	/*
	 * Returns the ID of the cinema hall for which booking was made
	 * @return The ID of the cinema hall for which booking was made
	 */
	public String getCinemaHallID() {
		return this.cinemaHallID;
	}

	/*
	 * Returns the name of the cineplex in which the booking was made
	 * @return The name of the cineplex in which the booking was made
	 */
	public String getCineplexName() {
		return this.cineplexName;
	}

	/*
	 * Returns the transaction ID of the booking
	 * @return The transaction ID of the booking
	 */
	public String getTransactionID() {
		return this.transactionID;
	}

	/*
	 * Prints the booking details
	 */
	public void printBooking() {
		System.out.print(this.transactionID);
		System.out.print(" | ");
		System.out.print(this.customerName);
		System.out.print(" | ");
		System.out.print(this.movieName);
		System.out.print(" | ");
		System.out.print(this.emailID);
		System.out.print(" | ");
		System.out.print(this.mobileNumber);
		System.out.print(" | ");
		System.out.print(this.cinemaHallID);
		System.out.print(" | ");
		System.out.println(this.cineplexName);
	}
}
