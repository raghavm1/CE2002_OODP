package moviedbdao;

import java.util.List;

import entities.Movie;

/**
 * Customer DAO for the movie database
 *
 * @author Gan Shyan
 */
public interface ICustomerMovieDBDAO extends IMovieDBDAO {

    /**
     * Get all movies whose status are "UPCOMING"
     * @param movieList
     */
    List<Movie> getUpcomingMovies(List<Movie> movieList);

    /**
     * Get all movies whose status are "PREVIEW"
     * @param movieList
     */
    List<Movie> getPreviewMovies(List<Movie> movieList);

    /**
     * Get all movies whose status are "NOW SHOWING"
     * @param movieList
     */
    List<Movie> getShowingNowMovies(List<Movie> movieList);

    /**
     * Get all movies whose status are "END OF SHOWING"
     * @param movieList
     */
    List<Movie> getEndOfShowingMovies(List<Movie> movieList);
}
