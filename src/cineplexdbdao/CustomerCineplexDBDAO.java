package cineplexdbdao;

import java.util.List;

import entities.CinemaHall;
import entities.Cineplex;

/**
 * Data access object for admins accessing the admin cineplex database
 *
 * @author Gan Shyan
 */
public class CustomerCineplexDBDAO implements ICustomerCineplexDBDAO {
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
