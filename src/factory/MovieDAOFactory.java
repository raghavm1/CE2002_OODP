package factory;

import moviedao.AdminMovieDAO;
import moviedao.CustomerMovieDAO;
import moviedao.IMovieDAO;

/**
 * Factory class that instantiates the correct MovieDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class MovieDAOFactory {

    private static IMovieDAO iMovieDBDAO = null;

    public static IMovieDAO getMovieDBDAO(String type) {
        if (type.equals("ADMIN")) {
            iMovieDBDAO = new AdminMovieDAO();
        } else if (type.equals("CUSTOMER")) {
            iMovieDBDAO = new CustomerMovieDAO();
        }
        return iMovieDBDAO;
    }
}