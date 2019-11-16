package moviedao;

import java.util.List;

import entities.Movie;

/**
 *
 * @author Gan Shyan
 */
public interface IMovieDAO {

    List<Movie> getAllMovies(List<Movie> movieList);

    Movie getMovie(String name, List<Movie> movieList);
}
