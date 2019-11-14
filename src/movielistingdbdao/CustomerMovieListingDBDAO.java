package movielistingdbdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.MovieListing;

/**
 * Movies Listing Database data access object for customers
 *
 * @author Gan Shyan
 */
public class CustomerMovieListingDBDAO implements ICustomerMovieListingDBDAO {


    @Override
    public List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList) {
        return movieListingList;
    }

    @Override
    public List<MovieListing> searchMovieListingByFilmName(String movieName, List<MovieListing> allMoviesListing) {
        List<MovieListing> filteredList = new ArrayList<>();
        Date currentDate = new Date();
        for (MovieListing movieListing : allMoviesListing) {
            if (movieListing.getId() != MovieListing.CANCELLED && movieListing.getShowTime().after(currentDate) &&
                    movieListing.getMovie().getTitle().trim().toUpperCase().equals(movieName.toUpperCase().trim())) {  // Only return movie listings in the future and not cancelled
                filteredList.add(movieListing);
            }
        }
        return filteredList;
    }

    @Override
    public List<MovieListing> searchMovieListingByCineplex(String cineplexName, List<MovieListing> allMoviesListing) {
        List<MovieListing> filteredList = new ArrayList<>();
        Date currentDate = new Date();
        for (MovieListing movieListing : allMoviesListing) {
            if (movieListing.getId() != MovieListing.CANCELLED && movieListing.getShowTime().after(currentDate) &&
                    movieListing.getCineplexName().trim().toUpperCase().contains(cineplexName.trim().toUpperCase())) { // Only return movie listings in the future and not cancelled
                filteredList.add(movieListing);
            }
        }
        return filteredList;
    }

    @Override
    public List<MovieListing> getAllUpcomingMovieListings(List<MovieListing> movieListingList) {
        Date currentDate = new Date();
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for (MovieListing m : movieListingList) {
            if (m.getId() != MovieListing.CANCELLED && m.getShowTime().after(currentDate)) {      // Get only movie listings that are not over and not cancelled
                filteredList.add(m);
            }
        }

        return filteredList;
    }

    @Override
    public List<MovieListing> getAllPreviousMovieListings(List<MovieListing> movieListingList) {
        Date currentDate = new Date();
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for (MovieListing m : movieListingList) {
            if (m.getId() != MovieListing.CANCELLED && m.getShowTime().before(currentDate)) {      // Get only movie listings that are over and not cancelled
                filteredList.add(m);
            }
        }

        return filteredList;
    }
}
