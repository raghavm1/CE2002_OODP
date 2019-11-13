package factory;

import movielistingdbdao.AdminMovieListingDBDAO;
import movielistingdbdao.CustomerMovieListingDBDAO;
import movielistingdbdao.IMovieListingDBDAO;

/**
 * Factory class that instantiates the correct MovieListingDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class MovieListingDBDAOFactory {

    private static IMovieListingDBDAO dbdao = null;

    public static IMovieListingDBDAO getMovieListingDBDAO(String type) {
        if (type.trim().toUpperCase().equals("ADMIN")) {
            dbdao = new AdminMovieListingDBDAO();
        } else if (type.trim().toUpperCase().equals("CUSTOMER")) {
            dbdao = new CustomerMovieListingDBDAO();
        }
        return dbdao;
    }

}
