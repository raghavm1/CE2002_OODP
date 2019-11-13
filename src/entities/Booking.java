package entities;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Entity class representing a Booking
 *
 * @author Lakshyajeet Dwivedee
 */

public class Booking {
	private String transactionID;
	private String customerName;
	private String emailID;
	private int mobileNumber;
	private String movieName;
	private String cinemaHallID;
	private String cineplexName;
	
	/**
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
	
	/**
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
	
	public String getEmailID() {
		return this.emailID;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public int getMobileNumber() {
		return this.mobileNumber;
	}
	
	public String getMovieName() {
		return this.movieName;
	}
	
	public String getCinemaHallID() {
		return this.cinemaHallID;
	}
	
	public String getCineplexName() {
		return this.cineplexName;
	}
	
	public String getTransactionID() {
		return this.transactionID;
	}
	
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
