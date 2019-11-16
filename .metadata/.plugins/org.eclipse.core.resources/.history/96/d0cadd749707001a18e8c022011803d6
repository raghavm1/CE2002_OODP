package managers;

import java.util.List;

import databases.MovieDB;
import databases.MovieListingDB;
import entities.Movie;
import entities.MovieListing;
import factory.MovieListingDBDAOFactory;
import movielistingdbdao.ICustomerMovieListingDBDAO;

/**
 * Control class for accessing the movie listings database for CUSTOMERS
 *
 * @author Gan Shyan
 */
public class CustomerMovieListingDBManager {
    private MovieDB movieDB;
    private MovieListingDB movieListingDB;
    private ICustomerMovieListingDBDAO dbdao;

    public CustomerMovieListingDBManager() {
        movieListingDB = MovieListingDB.getInstance();
        movieDB = MovieDB.getInstance();
        dbdao = (ICustomerMovieListingDBDAO) MovieListingDBDAOFactory.getMovieListingDBDAO("CUSTOMER");
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
