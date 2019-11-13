package movielistingdbdao;

import java.util.List;

import entities.MovieListing;

/**
 * Data Access Object for admins for accessing the movie listing database
 *
 * @author Gan Shyan
 */
public class AdminMovieListingDBDAO implements IAdminMovieListingDBDAO {

    @Override
    public MovieListing searchMovieListingByID(int id, List<MovieListing> movieListingList) {
        for (MovieListing movieListing : movieListingList) {
            if (movieListing.getId() == id) {
                return movieListing;
            }
        }
        return null;
    }

    @Override
    public void addMovieListing(MovieListing movieListing, List<MovieListing> movieListingList) {
        movieListingList.add(movieListing);
    }

    @Override
    public void deleteMovieListing(MovieListing movieListing, List<MovieListing> movieListingList) {
        movieListingList.remove(movieListing);
    }

    @Override
    public List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList) {
        return movieListingList;
    }

}
