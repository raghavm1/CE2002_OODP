package dao;

import java.util.List;

import entities.Movie;

/**
 * @author Gan Shyan
 */
public class AdminMovieDBDAO implements IAdminMovieDBDAO {

    @Override
    public void delete(Movie movie, List<Movie> movieList) {
        movieList.remove(movie);
    }

    @Override
    public void insert(Movie movie, List<Movie> movieList) {
        movieList.add(movie);
    }

    @Override
    public void update(Movie movie, List<Movie> movieList) {
        for (Movie oldMovie : movieList) {
            if (oldMovie.getTitle().trim().toUpperCase().equals(movie.getTitle().trim().toUpperCase())) {
                oldMovie = movie;
            }
        }
    }

    @Override
    public List<Movie> getAllMovies(List<Movie> movieList) {
        return movieList;
    }

    @Override
    public Movie getMovie(String name, List<Movie> movieList) {
        String queryStr = name.toUpperCase().trim();
        for (Movie movie : movieList) {
            if (movie.getTitle().trim().toUpperCase().equals(queryStr)) {
                return movie;
            }
        }
        return null;
    }

}
