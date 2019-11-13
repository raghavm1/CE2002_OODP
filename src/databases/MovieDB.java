package databases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entities.Cineplex;
import entities.Movie;

/**
 * This class represents the database which stores all the Movies
 *
 * @author Gan Shyan
 */
public class MovieDB {

    private static final String FILE_PATH = ".\\movie_db.txt";

    /**
     * List of all movies in the database
     */
    private static List<Movie> movieList = new ArrayList<>();

    private static MovieDB instance;

    /**
     * Private constructor to prevent user to instantiate this class directly
     */
    private MovieDB() {

    }

    /**
     * Singleton pattern to get the instance of the Movie Database
     *
     * @return
     */
    public static MovieDB getInstance() {
        if (instance == null) {
            instance = new MovieDB();
        }
        return instance;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Write ArrayList to the txt file
     */
    public void saveDatabase() {
        try {
            FileOutputStream fos =
                    new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);
            oos.writeObject(movieList); // Save arraylist to txt file
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }

    /**
     * Open the database by reading the text file
     */
    private void openDatabase() {
        try {
            FileInputStream fos =
                    new FileInputStream(FILE_PATH);
            ObjectInputStream oos =
                    new ObjectInputStream(fos);
            try {
                movieList = ((ArrayList<Movie>) oos.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }
}
