package movielistingdao;

import java.util.List;

import entities.MovieListing;

/**
 * DAO for Customers accessing the movie listing database
 * @author Gan Shyan
 */
public interface ICustomerMovieListingDAO extends IMovieListingDAO {
    /**
     * Return all movie listings that show a film
     * @param movieName
     * @param allMoviesListing
     * @return
     */
    List<MovieListing> searchMovieListingByFilmName(String movieName, List<MovieListing> allMoviesListing);

    /**
     * Return all movie listings in the cineplex according to the cineplex's name
     * @param cineplexName
     * @param allMoviesListing
     * @return
     */
    List<MovieListing> searchMovieListingByCineplex(String cineplexName, List<MovieListing> allMoviesListing);

}
