package movielistingdbdao;

import java.util.ArrayList;
import java.util.Date;
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
        for (MovieListing m : movieListingList) {
            if (m.getId() == movieListing.getId()) {
                m.setId(MovieListing.CANCELLED);
            }
        }
    }
    @Override
    public List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList) {
        return movieListingList;
    }

    @Override
    public List<MovieListing> getAllUpcomingMovieListings(List<MovieListing> movieListingList) {
        Date currentDate = new Date();
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for(MovieListing m : movieListingList){
            if(m.getId() != MovieListing.CANCELLED && m.getShowTime().after(currentDate)){      // Get only movie listings that are not over and not cancelled
                filteredList.add(m);
            }
        }
        return filteredList;
     }

    @Override
    public List<MovieListing> getAllPreviousMovieListings(List<MovieListing> movieListingList) {
        Date currentDate = new Date();
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for(MovieListing m : movieListingList){
            if(m.getId() != MovieListing.CANCELLED && m.getShowTime().before(currentDate)){      // Get only movie listings that are over and not cancelled
                filteredList.add(m);
            }
        }
        return filteredList;
    }

    @Override
    public List<MovieListing> getAllCancelledMovieListings(List<MovieListing> movieListingList) {
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for(MovieListing m : movieListingList){
            if(m.getId() == MovieListing.CANCELLED){      // Get only movie listings that have been cancelled
                filteredList.add(m);
            }
        }
        return filteredList;
    }


}
