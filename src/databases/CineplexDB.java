package databases;

import java.util.ArrayList;
import java.util.List;

import entities.CinemaHall;
import entities.Cineplex;
import entities.FloorPlan;

/**
 * This class represents the database which stores all the Cineplex details
 *
 * @author Gan Shyan
 */
public class CineplexDB {

    /**
     * Array of the cineplex representing the database data
     */
    private static List<Cineplex> cineplexList = new ArrayList<>();

    /**
     * Single instance of the DB
     */
    private static CineplexDB instance;

    private CineplexDB() {

       /* int[][] arr = new int[9][16];
        arr[1][6] = FloorPlan.BOOKED;
        arr[1][7] = FloorPlan.BOOKED;
        arr[1][8] = FloorPlan.BOOKED;
        arr[1][9] = FloorPlan.BOOKED;
        arr[2][6] = FloorPlan.BOOKED;
        arr[0][1] = FloorPlan.BOOKED;
        arr[0][2] = FloorPlan.BOOKED;
        FloorPlan floorPlan = new FloorPlan(arr, 9, 16);

        CinemaHall cinemaHall = new CinemaHall(floorPlan, 120, 7, 0);
        ArrayList<CinemaHall> cinemaHalls = new ArrayList<>();
        cinemaHalls.add(cinemaHall);
        cineplexList.add(new Cineplex(1, "Tampines Street 69", "Tampines Cineplex", cinemaHalls));*/
    }

    /**
     * Singleton pattern
     *
     * @return
     */
    public static CineplexDB getInstance() {
        if (instance == null) {
            instance = new CineplexDB();
        }

        return instance;
    }

    /**
     * Getter for the data in this DB
     *
     * @return
     */
    public List<Cineplex> getCineplexList() {
        return cineplexList;
    }
}
