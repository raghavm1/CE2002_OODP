package dao;

import java.util.List;

import entities.MovieListing;

public interface IMovieListingDBDAO {
    List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList);
}
