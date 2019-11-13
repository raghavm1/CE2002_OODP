package managers;

import java.util.List;

import movielistingdbdao.IAdminMovieListingDBDAO;
import databases.MovieDB;
import databases.MovieListingDB;
import entities.Movie;
import entities.MovieListing;
import factory.MovieListingDBDAOFactory;

/**
 * Control class for accessing the movie listings database for admins
 *
 * @author Gan Shyan
 */
public class AdminMovieListingDBManager {

    private MovieDB movieDB;
    private MovieListingDB movieListingDB;
    private IAdminMovieListingDBDAO dbdao;

    public AdminMovieListingDBManager(String type) {
        movieListingDB = MovieListingDB.getInstance();
        movieDB = MovieDB.getInstance();
        dbdao = (IAdminMovieListingDBDAO) MovieListingDBDAOFactory.getMovieListingDBDAO(type);
    }

    public Movie searchForMovie(String movieTitle) {
        for (Movie movie : movieDB.getMovieList()) {
            if (movie.getTitle().trim().toUpperCase().equals(movieTitle.trim().toUpperCase())) {
                return movie;
            }
        }
        return null;
    }

    public int getID() {
        return movieListingDB.getMovieList().size() + 1;
    }

    public List<MovieListing> getAllMovieListings() {
        return dbdao.getAllMovieListings(movieListingDB.getMovieList());
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
     * Get a movie listing from the database using the id
     *
     * @param id
     * @return
     */
    public MovieListing getMovieListingByID(int id) {
        return dbdao.searchMovieListingByID(id, movieListingDB.getMovieList());
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

}
