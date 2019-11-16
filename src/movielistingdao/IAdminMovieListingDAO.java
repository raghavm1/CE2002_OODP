package movielistingdao;

import java.util.ArrayList;
import java.util.List;

import entities.MovieListing;

/**
 * DAO for ADMINS to access the movie listing database
 * @author Gan Shyan
 */
public interface IAdminMovieListingDAO extends IMovieListingDAO {

    MovieListing searchMovieListingByID(int id, List<MovieListing> movieListingList);

    void addMovieListing(MovieListing movieListing, List<MovieListing> movieListingList);

    void deleteMovieListing(MovieListing movieListing, List<MovieListing> movieListingList);

    List<MovieListing> getAllCancelledMovieListings(List<MovieListing> movieListingList);
}
