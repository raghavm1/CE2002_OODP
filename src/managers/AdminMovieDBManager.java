package managers;

import java.util.List;

import dao.IAdminMovieDBDAO;
import databases.MovieDB;
import entities.Movie;
import factory.MovieDBDAOFactory;

/**
 * Control class for accessing the movie database for admins
 */
public class AdminMovieDBManager {

    /**
     * The movie database
     */
    private MovieDB movieDB;

    /**
     * The movie database data access object
     */
    private IAdminMovieDBDAO dbdao;

    public AdminMovieDBManager(String userType) {
        movieDB = MovieDB.getInstance();
        dbdao = (IAdminMovieDBDAO) MovieDBDAOFactory.getMovieDBDAO(userType);
    }

    public void insertMovie(Movie movie){
        dbdao.insert(movie, movieDB.getMovieList());
    }

    public Movie searchMovie(String name){
        return dbdao.getMovie(name, movieDB.getMovieList());
    }

    public List<Movie> getAllMovies(){
        return dbdao.getAllMovies(movieDB.getMovieList());
    }
}
