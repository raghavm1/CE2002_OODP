package dao;

import java.util.List;

import entities.MovieListing;

public interface IAdminMovieListingDBDAO extends IMovieListingDBDAO {

    MovieListing searchMovieListingByID(int id, List<MovieListing> movieListingList);

    void addMovieListing(MovieListing movieListing, List<MovieListing> movieListingList);

    void deleteMovieListing(MovieListing movieListing, List<MovieListing> movieListingList);
}
