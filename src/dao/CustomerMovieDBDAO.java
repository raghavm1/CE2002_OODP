package dao;

import java.util.List;

import entities.Movie;

/**
 * @author Gan Shyan
 */
public class CustomerMovieDBDAO implements ICustomerMovieDBDAO {

    private List<Movie> movieDB;

    public CustomerMovieDBDAO(List<Movie> movieList) {
        this.movieDB = movieList;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovie(int id) {
        for (Movie movie : movieDB) {
            if (movie.getId() == id) {
                return movie.copy();
            }
        }
        return null;
    }

    @Override
    public Movie getMovie(String name) {
        return null;
    }
}
