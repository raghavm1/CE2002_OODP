package managers;

import java.util.List;

import cineplexdbdao.ICustomerCineplexDBDAO;
import databases.CineplexDB;
import entities.CinemaHall;
import entities.Cineplex;
import factory.CineplexDBDAOFactory;

/**
 * Control class for accessing the cineplex database for Customer
 *
 * @author Gan Shyan
 */
public class CustomerCineplexDBManager {
    private CineplexDB cineplexDB;
    private ICustomerCineplexDBDAO customerCineplexDBDAO;

    public CustomerCineplexDBManager() {
        cineplexDB = CineplexDB.getInstance();
        customerCineplexDBDAO = (ICustomerCineplexDBDAO) CineplexDBDAOFactory.getDAO("CUSTOMER");
    }

    public List<Cineplex> getAllCineplexes() {
        return customerCineplexDBDAO.getAllCineplexes(cineplexDB.getCineplexList());
    }

    public CinemaHall searchCinemaHall(int cinemaHallNumber) {
        return customerCineplexDBDAO.searchCinemaHall(cinemaHallNumber, cineplexDB.getCineplexList());
    }
}
