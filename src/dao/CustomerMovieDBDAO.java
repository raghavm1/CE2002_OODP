package dao;

import java.util.ArrayList;
import java.util.List;

import databases.MovieDB;
import entities.Movie;

/**
 * Movie Database data access object for customers
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
        for (Movie movie : movieList){
            if(movie.getTitle().equals(name)){
                return movie;
            }
        }
        return null;
    }
}
