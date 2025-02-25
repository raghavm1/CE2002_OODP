package cineplexdao;

import java.util.List;

import entities.Cineplex;

/**
 * Data access object for admins to access the cineplex database
 * @author Gan Shyan
 */
public interface IAdminCineplexDAO extends ICineplexDAO {

    void addCineplex(Cineplex cineplex, List<Cineplex> list);

    void deleteCineplex(Cineplex cineplex, List<Cineplex> list);

}
