package databases;

import java.util.ArrayList;
import java.util.List;

import entities.Movie;
import entities.MovieListing;

/**
 * Class that represents the movie listing database
 * @author
 */
public class MovieListingDB {

    /**
     * List of all movies in the database
     */
    private static List<MovieListing> movieList = new ArrayList<>();

    private static MovieListingDB instance;

    private MovieListingDB(){

    }

    public static MovieListingDB getInstance(){
        if(instance == null){
            instance = new MovieListingDB();
        }
        return instance;
    }

    public List<MovieListing> getMovieList(){
        return movieList;
    }
}
