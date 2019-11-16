package manager;

import java.util.List;

import database.MovieDB;
import entities.Movie;
import factory.MovieDAOFactory;
import moviedao.IAdminMovieDAO;

/**
 * Control class for accessing the movie database for admins
 *
 * @author Gan Shyan
 */
public class AdminMovieManager {

    /**
     * The movie database
     */
    private MovieDB movieDB;

    /**
     * The movie database data access object
     */
    private IAdminMovieDAO dbdao;

    public AdminMovieManager(String userType) {
        movieDB = MovieDB.getInstance();
        dbdao = (IAdminMovieDAO) MovieDAOFactory.getMovieDBDAO(userType);
    }

    public void saveDatabase(){
        movieDB.saveDatabase();
    }

    public void insertMovie(Movie movie) {
        dbdao.insert(movie, movieDB.getMovieList());
    }

    public Movie searchMovie(String name) {
        return dbdao.getMovie(name, movieDB.getMovieList());
    }

    public List<Movie> getAllMovies() {
        return dbdao.getAllMovies(movieDB.getMovieList());
    }
}
