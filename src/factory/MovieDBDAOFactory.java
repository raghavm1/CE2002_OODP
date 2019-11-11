package factory;

import dao.AdminMovieDBDAO;
import dao.CustomerMovieDBDAO;
import dao.IMovieDBDAO;
import managers.AdminMovieDBManager;

/**
 * Factory class that instantiates the correct MovieDBDAO according to the caller type and
 * returns it to the caller
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