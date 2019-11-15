package factory;

import cineplexdbdao.AdminCineplexDBDAO;
import cineplexdbdao.CustomerCineplexDBDAO;
import cineplexdbdao.ICineplexDBDAO;

/**
 * Factory class that instantiates the correct CineplexDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class CineplexDBDAOFactory {

    public static ICineplexDBDAO getDAO(String type) {
        if (type.equals("ADMIN")) {
            return new AdminCineplexDBDAO();
        } else if (type.equals("CUSTOMER")) {
            return new CustomerCineplexDBDAO();
        }
        return null;
    }
}
