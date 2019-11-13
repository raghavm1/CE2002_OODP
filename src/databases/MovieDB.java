package databases;

import java.util.ArrayList;
import java.util.List;

import entities.Movie;

/**
 * This class represents the database which stores all the Movies
 *
 * @author Gan Shyan
 */
public class MovieDB {

    /**
     * List of all movies in the database
     */
    private static List<Movie> movieList = new ArrayList<>();

    private static MovieDB instance;

    /**
     * Private constructor to prevent user to instantiate this class directly
     */
    private MovieDB(){

    }

    /**
     * Singleton pattern to get the instance of the Movie Database
     * @return
     */
    public static MovieDB getInstance(){
        if(instance == null){
            return new MovieDB();
        } else {
            return instance;
        }
    }

    public List<Movie> getMovieList(){
        return movieList;
    }
}
