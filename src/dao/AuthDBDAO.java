package dao;

import java.util.List;

import utilities.CSVFileIO;
import utilities.CSVRow;

/*
 * Class accesses the Auth database
 * @author Lakshyajeet Dwivedee
 */
public class AuthDBDAO {

	/*
	 * Get the data from the CSV file
     * @return List of CSVRows containing the data of alluser's credentials 
	 */
    public static List<CSVRow> getUserCredentials() {
    	List<CSVRow> table = CSVFileIO.getParsedCSV("src/auth.csv");
    	return table;
    }
}