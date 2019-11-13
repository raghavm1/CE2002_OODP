package movielistingdbdao;

import java.util.List;

import entities.MovieListing;

/**
 * Base DAO for the movie listing database
 * @author Gan Shyan
 */
public interface IMovieListingDBDAO {
    List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList);
}
