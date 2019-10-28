package managers;

import databases.MovieDB;

/**
 *
 * @author Gan Shyan
 */
public class AdminMovieManager {

    private MovieDB movieDB;

    public AdminMovieManager() {
        this.movieDB = MovieDB.getInstance();
    }

    public void startUp() {
        System.out.println("Welcome Admin\n\n");
    }

}
