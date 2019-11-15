package manager;

import java.util.List;

import database.MovieDB;
import entities.Movie;
import factory.MovieDAOFactory;
import moviedao.ICustomerMovieDAO;

/**
 * Control class for accessing the movie database for CUSTOMERS
 *
 * @author Gan Shyan
 */
public class CustomerMovieManager {
    /**
     * The movie database
     */
    private MovieDB movieDB;

    /**
     * The movie database data access object
     */
    private ICustomerMovieDAO dbdao;

    public CustomerMovieManager() {
        movieDB = MovieDB.getInstance();
        dbdao = (ICustomerMovieDAO) MovieDAOFactory.getMovieDBDAO("CUSTOMER");
    }

    public List<Movie> getAllMovies() {
        return dbdao.getAllMovies(movieDB.getMovieList());
    }

    public Movie searchMovie(String name) {
        return dbdao.getMovie(name, movieDB.getMovieList());
    }

    public List<Movie> getAllUpComingMovies() {
        return dbdao.getUpcomingMovies(movieDB.getMovieList());
    }

    public List<Movie> getAllPreviewMovies() {
        return dbdao.getPreviewMovies(movieDB.getMovieList());
    }

    public List<Movie> getAllNowShowingMovies() {
        return dbdao.getShowingNowMovies(movieDB.getMovieList());
    }

    public List<Movie> getEndOfShowingMovies() {
        return dbdao.getEndOfShowingMovies(movieDB.getMovieList());
    }
}
