package movielistingdao;

import java.util.ArrayList;
import java.util.List;

import entities.MovieListing;

/**
 * Base DAO for the movie listing database
 * @author Gan Shyan
 */
public interface IMovieListingDAO {
    /**
     * Return all movie listings
     * @param movieListingList
     * @return
     */
    List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList);

    /**
     * Return all movie listings that are yet to occur
     * @param movieListingList
     * @return
     */
    List<MovieListing> getAllUpcomingMovieListings(List<MovieListing> movieListingList);

    /**
     * Return all movie listings that are over
     * @param movieListingList
     * @return
     */
    List<MovieListing> getAllPreviousMovieListings(List<MovieListing> movieListingList);
}
