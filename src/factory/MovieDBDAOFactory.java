package factory;

import dao.AdminMovieDBDAO;
import dao.CustomerMovieDBDAO;
import dao.IMovieDBDAO;

public abstract class MovieDBDAOFactory {

    private static IMovieDBDAO iMovieDBDAO = null;

    public static IMovieDBDAO getMovieDBDAO(String type) {
        if (type.equals("ADMIN")) {
            iMovieDBDAO = new CustomerMovieDBDAO();
        } else if (type.equals("CUSTOMER")) {
            iMovieDBDAO = new AdminMovieDBDAO();
        }
        return iMovieDBDAO;
    }
}
