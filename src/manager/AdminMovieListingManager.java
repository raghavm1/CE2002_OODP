package manager;

import java.util.List;

import database.MovieDB;
import database.MovieListingDB;
import entities.Movie;
import entities.MovieListing;
import factory.MovieListingDAOFactory;
import movielistingdao.IAdminMovieListingDAO;

/**
 * Control class for accessing the movie listings database for admins
 *
 * @author Gan Shyan
 */
public class AdminMovieListingManager {

    private MovieDB movieDB;
    private MovieListingDB movieListingDB;
    private IAdminMovieListingDAO dbdao;

    public AdminMovieListingManager(String type) {
        movieListingDB = MovieListingDB.getInstance();
        movieDB = MovieDB.getInstance();
        dbdao = (IAdminMovieListingDAO) MovieListingDAOFactory.getMovieListingDBDAO(type);
    }

    public Movie searchForMovie(String movieTitle) {
        for (Movie movie : movieDB.getMovieList()) {
            if (movie.getTitle().trim().toUpperCase().equals(movieTitle.trim().toUpperCase())) {
                return movie;
            }
        }
        return null;
    }

    /**
     * This function generates a unique ID for a movie listing, since each movie listing is meant to have a unique ID
     *
     * @return
     */
    public int getID() {
        return movieListingDB.getMovieList().size() + 1;
    }

    public List<MovieListing> getAllMovieListings() {
        return dbdao.getAllMovieListings(movieListingDB.getMovieList());
    }

    /**
     * Get a movie listing from the database using the id
     *
     * @param id
     * @return
     */
    public MovieListing getMovieListingByID(int id) {
        return dbdao.searchMovieListingByID(id, movieListingDB.getMovieList());
    }


    /**
     * Insert new movie listing into the database
     *
     * @param movieListing
     */
    public void insertMovieListing(MovieListing movieListing) {
        dbdao.addMovieListing(movieListing, movieListingDB.getMovieList());
    }

    /**
     * Delete movie listing from the database
     *
     * @param movieListing
     */
    public void deleteMovieListing(MovieListing movieListing) {
        dbdao.deleteMovieListing(movieListing, movieListingDB.getMovieList());
    }

    /**
     * Delete a movie listing from the database using the id
     *
     * @param movieListingID
     */
    public void deleteMovieListing(int movieListingID) {
        MovieListing movieListing = getMovieListingByID(movieListingID);
        dbdao.deleteMovieListing(movieListing, movieListingDB.getMovieList());
    }

    /**
     * Save the arraylist database into the text file
     */
    public void saveDatabase() {
        movieListingDB.saveDatabase();
    }

    public List<MovieListing> getAllUpcomingMovieListings() {
        return dbdao.getAllUpcomingMovieListings(movieListingDB.getMovieList());
    }

    public List<MovieListing> getAllPreviousMovieListings() {
        return dbdao.getAllPreviousMovieListings(movieListingDB.getMovieList());
    }

    public List<MovieListing> getAllCancelledMovieListings() {
        return dbdao.getAllCancelledMovieListings(movieListingDB.getMovieList());
    }

}
