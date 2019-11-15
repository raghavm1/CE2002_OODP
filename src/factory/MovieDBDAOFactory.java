package factory;

import moviedbdao.AdminMovieDBDAO;
import moviedbdao.CustomerMovieDBDAO;
import moviedbdao.IMovieDBDAO;

/**
 * Factory class that instantiates the correct MovieDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class MovieDBDAOFactory {

    private static IMovieDBDAO iMovieDBDAO = null;

    public static IMovieDBDAO getMovieDBDAO(String type) {
        if (type.equals("ADMIN")) {
            iMovieDBDAO = new AdminMovieDBDAO();
        } else if (type.equals("CUSTOMER")) {
            iMovieDBDAO = new CustomerMovieDBDAO();
        }
        return iMovieDBDAO;
    }
}