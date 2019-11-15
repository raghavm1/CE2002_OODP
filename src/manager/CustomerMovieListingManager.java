package manager;

import java.util.List;

import database.MovieDB;
import database.MovieListingDB;
import entities.Movie;
import entities.MovieListing;
import factory.MovieListingDAOFactory;
import movielistingdao.ICustomerMovieListingDAO;

/**
 * Control class for accessing the movie listings database for CUSTOMERS
 *
 * @author Gan Shyan
 */
public class CustomerMovieListingManager {
    private MovieDB movieDB;
    private MovieListingDB movieListingDB;
    private ICustomerMovieListingDAO dbdao;

    public CustomerMovieListingManager() {
        movieListingDB = MovieListingDB.getInstance();
        movieDB = MovieDB.getInstance();
        dbdao = (ICustomerMovieListingDAO) MovieListingDAOFactory.getMovieListingDBDAO("CUSTOMER");
    }

    public Movie searchForMovie(String movieTitle) {
        for (Movie movie : movieDB.getMovieList()) {
            if (movie.getTitle().trim().toUpperCase().equals(movieTitle.trim().toUpperCase())) {
                return movie;
            }
        }
        return null;
    }
    
  

    public List<MovieListing> getAllMovieListings() {
        return dbdao.getAllMovieListings(movieListingDB.getMovieList());
    }

    public List<MovieListing> getAllUpcomingMovieListings() {
        return dbdao.getAllUpcomingMovieListings(movieListingDB.getMovieList());
    }

    public List<MovieListing> getAllPreviousMovieListings() {
        return dbdao.getAllPreviousMovieListings(movieListingDB.getMovieList());
    }

    public List<MovieListing> searchMovieListingByFilmName(String filmName) {
        return dbdao.searchMovieListingByFilmName(filmName, movieListingDB.getMovieList());
    }

    public List<MovieListing> searchMovieListingByCineplex(String cineplexName) {
        return dbdao.searchMovieListingByCineplex(cineplexName, movieListingDB.getMovieList());
    }

}
