package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Booking;

/**
 * @author Lakshyajeet Dwivedee
 */
public class BookingDBDAO {

    public void insert(Booking booking, List<Booking> bookingList) {
    	bookingList.add(booking);
    }

    public List<Booking> getBookings(List<Booking> bookingList, String emailID) {
        List<Booking> relevantBookings = new ArrayList<Booking>();
        for(Booking booking : bookingList) {
        	if(booking.getEmailID().compareTo(emailID) == 0) {
        		relevantBookings.add(booking);
        	}
        }
        return relevantBookings;
    }
}
