package moviedao;

import java.util.List;

import entities.Movie;

/**
 *
 * @author Gan Shyan
 */
public interface IAdminMovieDAO extends IMovieDAO {
    void delete(Movie movie, List<Movie> movieList);
    void insert(Movie movie, List<Movie> movieList);
    void update(Movie movie, List<Movie> movieList);
}
