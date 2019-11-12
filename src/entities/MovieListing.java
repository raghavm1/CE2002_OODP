package entities;

import java.util.Date;

/**
 * Entity class which presents a movie showing at a {@link Cineplex}'s {@link CinemaHall} at a particular time
 *
 * @author Gan Shyan
 */
public class MovieListing {

    /**
     * Unique ID of the movie listing
     */
    private int id;

    /**
     * ID of the {@link Cineplex} this movie is going to be shown
     */
    private String cineplexName;

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

    public MovieListing(int id, String cineplexName, int cinemaHall, Date showTime, Movie movie){
        this.id = id;
        this.cineplexName = cineplexName;
        this.cinemaHall = cinemaHall;
        this.showTime = showTime;
        this.movie = movie;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public int getCinemaHall() {
        return cinemaHall;
    }

    public Date getShowTime() {
        return showTime;
    }

    /**
     * Getter for {@link Movie} attribute
     *
     * @return entities.Movie attribute
     */
    public Movie getMovie() {
        return this.movie;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setCineplexID(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public void setCinemaHall(int cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
