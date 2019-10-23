import java.util.Date;

/**
 * Entity class which presents a movie showing at a {@link Cineplex}'s {@link CinemaHall} at a particular time
 *
 * @author Gan Shyan
 */
public class MovieListing {

    /**
     * ID of the {@link Cineplex} this movie is going to be shown
     */
    private int cineplexID;

    /**
     * Number of the {@link CinemaHall} this movie listing going to be shown
     */
    private int cinemaHall;

    /**
     * {@link Date} object for when the movie is showing
     */
    private Date showTime;

    /**
     * {@link Movie} that is being shown
     */
    private Movie movie;

    /**
     * Getter for {@link Movie} attribute
     * @return Movie attribute
     */
    public Movie getMovie(){
        return this.movie;
    }

}
