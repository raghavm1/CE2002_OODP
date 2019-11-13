package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Booking;
import utilities.CSVFileIO;
import utilities.CSVRow;

/**
 * @author Lakshyajeet Dwivedee
 */
public class BookingDBDAO {

    public void insert(Booking booking, List<Booking> bookingList) {
    	bookingList.add(booking);
    	this.saveToFile(booking);
    }
    
    private void saveToFile(Booking booking) {
    	CSVRow tempCsvRow = new CSVRow();
    	tempCsvRow.clearRow();
    	
    	tempCsvRow.addVariable(booking.getTransactionID());
    	tempCsvRow.addVariable(booking.getCustomerName());
    	tempCsvRow.addVariable(booking.getMovieName());
    	tempCsvRow.addVariable(booking.getEmailID());
    	tempCsvRow.addVariable(String.valueOf(booking.getMobileNumber()));
    	tempCsvRow.addVariable(booking.getCinemaHallID());
    	tempCsvRow.addVariable(booking.getCineplexName());
    	
    	CSVFileIO.writeToCSV("../bookings.csv", tempCsvRow);
    }
    
    private List<Booking> convertToBookings(List<CSVRow> table) {
    	List<Booking> bookings = new ArrayList<>();
    	for(CSVRow csvRow : table) {
    		List<String> row = csvRow.getRow();
    		Booking tempBooking = new Booking(row.get(1), row.get(3), Integer.parseInt(row.get(4)), row.get(2), row.get(5), row.get(6), row.get(0));
    		bookings.add(tempBooking);
    	}
    	return bookings;
    }

    public List<Booking> getBookings(String emailID) {
    	
    	List<CSVRow> table = CSVFileIO.getParsedCSV("../bookings.csv");
    	List<Booking> bookingList = convertToBookings(table);
    	
        List<Booking> relevantBookings = new ArrayList<Booking>();
        for(Booking booking : bookingList) {
        	if(booking.getEmailID().compareTo(emailID) == 0) {
        		relevantBookings.add(booking);
        	}
        }
        return relevantBookings;
    }
}
