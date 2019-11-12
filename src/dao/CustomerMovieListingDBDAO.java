package dao;

import java.util.List;

import entities.MovieListing;

/**
 * Movies Listing Database data access object for customers
 * @author Gan Shyan
 */
public class CustomerMovieListingDBDAO implements ICustomerMovieListingDBDAO {


    @Override
    public List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList) {
        return null;
    }

    @Override
    public MovieListing searchMovieListingByFilmName(String movieName, List<MovieListing> allMoviesListing) {
        return null;
    }

    @Override
    public MovieListing searchMovieListingByCineplex(String cineplexName, List<MovieListing> allMoviesListing) {
        return null;
    }

    @Override
    public MovieListing searchMovieListingByFileNameAndCinplex(String movieName, String cineplexName, List<MovieListing> allMoviesListing) {
        return null;
    }
}
