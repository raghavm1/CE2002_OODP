package managers;

import java.util.List;

import databases.MovieDB;
import entities.Movie;
import factory.MovieDBDAOFactory;
import moviedbdao.ICustomerMovieDBDAO;

/**
 * Control class for accessing the movie database for CUSTOMERS
 *
 * @author Gan Shyan
 */
public class CustomerMovieDBManager {
    /**
     * The movie database
     */
    private MovieDB movieDB;

    /**
     * The movie database data access object
     */
    private ICustomerMovieDBDAO dbdao;

    public CustomerMovieDBManager() {
        movieDB = MovieDB.getInstance();
        dbdao = (ICustomerMovieDBDAO) MovieDBDAOFactory.getMovieDBDAO("CUSTOMER");
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
