package dao;

import java.util.List;

import entities.Movie;

/**
 *
 * @author Gan Shyan
 */
public interface IMovieDBDAO {

    List<Movie> getAllMovies();

    Movie getMovie(int id);

    Movie getMovie(String name);
}
