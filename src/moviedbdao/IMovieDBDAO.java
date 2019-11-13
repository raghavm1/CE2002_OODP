package moviedbdao;

import java.util.List;

import entities.Movie;

/**
 *
 * @author Gan Shyan
 */
public interface IMovieDBDAO {

    List<Movie> getAllMovies(List<Movie> movieList);

    Movie getMovie(String name, List<Movie> movieList);
}
