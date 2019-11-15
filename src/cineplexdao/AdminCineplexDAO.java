package cineplexdao;

import java.util.List;

import entities.CinemaHall;
import entities.Cineplex;

/**
 * Data access object for admins accessing the admin cineplex database
 *
 * @author Gan Shyan
 */
public class AdminCineplexDAO implements IAdminCineplexDAO {

    @Override
    public void addCineplex(Cineplex cineplex, List<Cineplex> list) {
        list.add(cineplex);
    }

    @Override
    public void deleteCineplex(Cineplex cineplex, List<Cineplex> list) {
        list.remove(cineplex);
    }

    @Override
    public List<Cineplex> getAllCineplexes(List<Cineplex> list) {
        return list;
    }

    @Override
    public Cineplex searchCineplex(int id, List<Cineplex> list) {
        for (Cineplex cineplex : list) {
            if (cineplex.getCineplexCode() == id) {
                return cineplex;
            }
        }
        return null;
    }

    @Override
    public Cineplex searchCineplex(String name, List<Cineplex> list) {
        for (Cineplex cineplex : list) {
            if (cineplex.getName().equals(name)) {
                return cineplex;
            }
        }
        return null;
    }

    @Override
    public CinemaHall searchCinemaHall(int cinemaHallId, List<Cineplex> list) {
        for (Cineplex cineplex : list) {
            for (CinemaHall cinemaHall : cineplex.getCinemaHallList()) {
                if (cinemaHall.getHallNumber() == cinemaHallId) {
                    return cinemaHall;
                }
            }
        }
        return null;
    }
}
