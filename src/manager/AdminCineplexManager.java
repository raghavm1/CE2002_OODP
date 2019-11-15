package manager;

import java.util.List;

import cineplexdao.IAdminCineplexDAO;
import database.CineplexDB;
import entities.CinemaHall;
import entities.Cineplex;
import factory.CineplexDAOFactory;

/**
 * Control class for accessing the cineplex database for admins
 *
 * @author Gan Shyan
 */
public class AdminCineplexManager {

    private CineplexDB cineplexDB;
    private IAdminCineplexDAO iAdminCineplexDBDAO;

    public AdminCineplexManager() {
        cineplexDB = CineplexDB.getInstance();
        iAdminCineplexDBDAO = (IAdminCineplexDAO) CineplexDAOFactory.getDAO("ADMIN");
    }

    public void saveDatabase(){
        cineplexDB.saveDatabase();
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

    public Cineplex searchCineplex(String name) {
        return iAdminCineplexDBDAO.searchCineplex(name, cineplexDB.getCineplexList());
    }

    public Cineplex searchCineplex(int id) {
        return iAdminCineplexDBDAO.searchCineplex(id, cineplexDB.getCineplexList());
    }

    public CinemaHall searchCinemaHall(int cinemaHallNumber) {
        return iAdminCineplexDBDAO.searchCinemaHall(cinemaHallNumber, cineplexDB.getCineplexList());
    }
}
