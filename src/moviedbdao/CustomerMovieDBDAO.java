package moviedbdao;

import java.util.ArrayList;
import java.util.List;

import entities.Movie;

/**
 * Movie Database data access object for customers
 *
 * @author Gan Shyan
 */
public class CustomerMovieDBDAO implements ICustomerMovieDBDAO {

    public CustomerMovieDBDAO() {

    }

    @Override
    public List<Movie> getAllMovies(List<Movie> movieList) {
        return movieList;
    }

    @Override
    public Movie getMovie(String name, List<Movie> movieList) {
        name = name.trim().toUpperCase();
        for (Movie movie : movieList) {
            if (movie.getTitle().trim().toUpperCase().contains(name)) {
                return movie;
            }
        }
        return null;
    }


    @Override
    public List<Movie> getUpcomingMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.COMING_SOON) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }

    @Override
    public List<Movie> getPreviewMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.PREVIEW) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }

    @Override
    public List<Movie> getShowingNowMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.NOW_SHOWING) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }

    @Override
    public List<Movie> getEndOfShowingMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.END_OF_SHOWING) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }
}
