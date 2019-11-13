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
	private Movie movie;
	private CinemaHall cinemaHall;
	private Cineplex cineplex;
	
	/**
     * Constructor
     *
     * @param customerName Name of customer making the booking
     * @param emailID Email ID entered by customer making the booking
     * @param mobileNumber Mobile number entered by the customer making the booking
     * @param movie Movie for which booking is being made
     * @param cinemaHall Cinema hall in which movie was shown
     * @param cinePlex Cineplex in which movie was booked
     */
	public Booking(String customerName, String emailID, int mobileNumber, Movie movie, CinemaHall cinemaHall, Cineplex Cineplex) {
		this.customerName = customerName;
		this.emailID = emailID;
		this.mobileNumber = mobileNumber;
		this.movie = movie;
		this.cinemaHall = cinemaHall;
		this.cineplex = cineplex;
		this.transactionID = String.valueOf(LocalDateTime.now().getYear()) + String.valueOf(LocalDateTime.now().getMonthValue()) + String.valueOf(LocalDateTime.now().getDayOfYear()) + String.valueOf(LocalDateTime.now().getHour()) + String.valueOf(LocalDateTime.now().getMinute()) + String.valueOf(cinemaHall.getHallNumber());
	}
	
	public String getEmailID() {
		return this.emailID;
	}
}
