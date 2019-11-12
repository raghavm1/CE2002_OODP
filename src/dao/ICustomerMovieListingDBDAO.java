package dao;

import java.util.List;

import entities.MovieListing;

public interface ICustomerMovieListingDBDAO extends IMovieListingDBDAO {
    MovieListing searchMovieListingByFilmName(String movieName, List<MovieListing> allMoviesListing);
    MovieListing searchMovieListingByCineplex(String cineplexName, List<MovieListing> allMoviesListing);
    MovieListing searchMovieListingByFileNameAndCinplex(String movieName, String cineplexName, List<MovieListing> allMoviesListing);
}
