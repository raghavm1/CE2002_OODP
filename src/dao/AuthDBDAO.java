package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Auth;
import utilities.CSVFileIO;
import utilities.CSVRow;

/*
 * Class accesses the Auth database
 * @author Lakshyajeet Dwivedee
 */
public class AuthDBDAO {
    
    /**
     * Getauthg data from the CSV file
     * @return List of CSVRows containing the data of alluser's credentialss
     */
    public static List<CSVRow> getUserCredentials() {
    	List<CSVRow> table = CSVFileIO.getParsedCSV("src/auth.csv");
    	return table;
    }
}