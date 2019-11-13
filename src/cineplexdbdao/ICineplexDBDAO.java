package cineplexdbdao;

import java.util.List;

import entities.CinemaHall;
import entities.Cineplex;

/**
 * Base data access object for cineplex database
 *
 * @author Gan Shyan
 */
public interface ICineplexDBDAO {
    /**
     * Return the entire list of cineplexes
     *
     * @param list
     * @return
     */
    List<Cineplex> getAllCineplexes(List<Cineplex> list);

    /**
     * Search for a single cineplex according to its unique Cineplex ID
     *
     * @param id
     * @param list
     * @return
     */
    Cineplex searchCineplex(int id, List<Cineplex> list);

    /**
     * Search for a single cineplex according to its name
     *
     * @param name
     * @param list
     * @return
     */
    Cineplex searchCineplex(String name, List<Cineplex> list);

    /**
     * Search for a single cinema hall according to its unqiue cinema hall id
     */
    CinemaHall searchCinemaHall(int cinemaHallId, List<Cineplex> list);

}
