import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList
import java.util.List;

/*
* Class finds specified CSV file and converts it into a 2D ArrayList of Strings
* @author Lakshyajeet Dwivedee 
*/
public class CSVReader {
    
    /**
	 * Store parsed CSV data as a list of CSV rows
	 */
    private List<CSVRow> CSVInfo = new ArrayList<>();
    /**
	 * Store the path to the CSV file
	 */
    private String path;

    /**
	 * Creates a new CSVReader which reads from specified path
	 * path must be given
	 * @param path Path to the CSV file which has to be read
	 */
    public CSVReader(String path) {
        this.path = path
    }
    
    /**
	 * Parses CSV and returns it as a list of list of attributes in String form
	 * @return The ArrayList of CSVRow Arraylists
	 */
    public ArrayList<CSVRow> getParsedCSV() {
        // Declare a BufferedReader
        BufferedReader br = null;
        String line = ""; // Will store new line of CSV
        String splitter = ","; // Will store the delimiter to be used
        
        // Try catch block in case file is not found
        try {
            // Initialise BufferedReader with a new FileReader pointing to the input path
            br = new BufferedReader(new FileReader(this.path
            
            //Iterate through each line of the CSV file till end reached
            while ((line = br.readLine()) != null) {

                // Use comma as separator
                String[] attributes = line.split(splitter);
                // Create a new CSVRow object
                CSVRow newRow = new CSVRow();
                // Fill up the newRow with the attributes present in this line of the CSV
                for(String var : attributes){
                    newRow.addVariable(var);
                }
                // Insert newRow into the CSVInfo table
                CSVInfo.add(newRow);
                
            }
        // If file is not found
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        // If there is some error in IO
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                // Try closing the BufferedReader
                try {
                    br.close();
                // If there is some error in IO
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
