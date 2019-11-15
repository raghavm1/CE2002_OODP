package manager;

import java.util.ArrayList;
import java.util.List;

import entities.Auth;
import movielistingdao.AuthDAO;
import utility.CSVFileIO;
import utility.CSVRow;

/*
 * Control class for accessing the admin authentication database
 *
 * @author Lakshyajeet Dwivedee
 */
public class AuthManager {
	
	/*
	 * Check through the Auth database to see if the given authentication details are valid
	 * @params username The username of the user
	 * @params password The password of the user
     * @return Boolean whether username and password are correct and exist in database 
	 */
	public static boolean authenticateUser(String username, String password) {
		List<CSVRow> table = AuthDAO.getUserCredentials();
		List<Auth> authList = convertToAuth(table);
		
		for(Auth auth : authList) {
			if (auth.getUsername().compareTo(username) == 0 && auth.getPassword().compareTo(password) == 0) {
				 return true;
			}
		}
		return false;
	}
    

	/*
	 * Convert a list of CSVRow objects to a list of Auth objects
	 * @param table The list of CSVRow objects to convert
	 * @return The list of Auth objects 
	 */
    private static List<Auth> convertToAuth(List<CSVRow> table) {
    	List<Auth> auths = new ArrayList<>();
    	for(CSVRow csvRow : table) {
    		List<String> row = csvRow.getRow();
    		Auth tempAuth = new Auth(row.get(0), row.get(1));
    		auths.add(tempAuth);
    	}
    	return auths;
    }
	
}
