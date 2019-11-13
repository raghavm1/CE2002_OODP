package managers;

import java.util.List;

import cineplexdbdao.IAdminCineplexDBDAO;
import databases.CineplexDB;
import entities.CinemaHall;
import entities.Cineplex;
import factory.CineplexDBDAOFactory;

/**
 * Control class for accessing the cineplex database for admins
 *
 * @author Gan Shyan
 */
public class AdminCineplexDBManager {

    private CineplexDB cineplexDB;
    private IAdminCineplexDBDAO iAdminCineplexDBDAO;

    public AdminCineplexDBManager() {
        cineplexDB = CineplexDB.getInstance();
        iAdminCineplexDBDAO = (IAdminCineplexDBDAO) CineplexDBDAOFactory.getDAO("ADMIN");
    }

    public void addCineplex(Cineplex cineplex) {
        iAdminCineplexDBDAO.addCineplex(cineplex, cineplexDB.getCineplexList());
    }

    public void deleteCineplex(Cineplex cineplex) {
        iAdminCineplexDBDAO.deleteCineplex(cineplex, cineplexDB.getCineplexList());
    }

    public List<Cineplex> getAllCineplexes() {
        return iAdminCineplexDBDAO.getAllCineplexes(cineplexDB.getCineplexList());
    }

    public CinemaHall searchCinemaHall(int cinemaHallNumber) {
        return iAdminCineplexDBDAO.searchCinemaHall(cinemaHallNumber, cineplexDB.getCineplexList());
    }
}
