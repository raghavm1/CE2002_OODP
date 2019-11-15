package manager;

import java.util.List;

import cineplexdao.ICustomerCineplexDAO;
import database.CineplexDB;
import entities.CinemaHall;
import entities.Cineplex;
import factory.CineplexDAOFactory;

/**
 * Control class for accessing the cineplex database for Customer
 *
 * @author Gan Shyan
 */
public class CustomerCineplexManager {
    private CineplexDB cineplexDB;
    private ICustomerCineplexDAO customerCineplexDBDAO;

    public CustomerCineplexManager() {
        cineplexDB = CineplexDB.getInstance();
        customerCineplexDBDAO = (ICustomerCineplexDAO) CineplexDAOFactory.getDAO("CUSTOMER");
    }

    public List<Cineplex> getAllCineplexes() {
        return customerCineplexDBDAO.getAllCineplexes(cineplexDB.getCineplexList());
    }

    public CinemaHall searchCinemaHall(int cinemaHallNumber) {
        return customerCineplexDBDAO.searchCinemaHall(cinemaHallNumber, cineplexDB.getCineplexList());
    }
}
