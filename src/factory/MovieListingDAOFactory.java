package factory;

import movielistingdao.AdminMovieListingDAO;
import movielistingdao.CustomerMovieListingDAO;
import movielistingdao.IMovieListingDAO;

/**
 * Factory class that instantiates the correct MovieListingDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class MovieListingDAOFactory {

    private static IMovieListingDAO dbdao = null;

    public static IMovieListingDAO getMovieListingDBDAO(String type) {
        if (type.trim().toUpperCase().equals("ADMIN")) {
            dbdao = new AdminMovieListingDAO();
        } else if (type.trim().toUpperCase().equals("CUSTOMER")) {
            dbdao = new CustomerMovieListingDAO();
        }
        return dbdao;
    }

}
