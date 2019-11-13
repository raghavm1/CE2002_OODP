package entities;

import java.util.ArrayList;

/**
 * Entity class representing the Movie
 *
 * @author Gan Shyan
 */
public class Movie {

    // Status of the movie
    public static final int COMING_SOON = 1;
    public static final int PREVIEW = 2;
    public static final int NOW_SHOWING = 3;
    public static final int END_OF_SHOWING = -1;

    // Censorship classification
    public static final int G = 1;
    public static final int PG = 2;
    public static final int NC16 = 3;
    public static final int M18 = 4;
    public static final int R21 = 5;

    private String title;
    private int runTime;
    private int status;
    private String synopsis;
    private String director;
    private ArrayList<String> casts; //At least 2
    private Reviews reviews;
    private int censorClassification;

    public Movie(String title, int runTime, int status, String synopsis, String director, ArrayList<String> casts, int censorClassification) {
        this.title = title;
        this.runTime = runTime;
        this.status = status;
        this.synopsis = synopsis;
        this.director = director;
        this.censorClassification = censorClassification;
        this.casts = casts;
        this.reviews = new Reviews();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getRunTime() {
        return runTime;
    }

    public int getStatus() {
        return status;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }

    public int getCensorClassification() {
        return censorClassification;
    }

    public ArrayList<String> getCasts() {
        return casts;
    }

    public Reviews getReviews() {
        return reviews;
    }

    // Setters

    public void setStatus(int status) {
        this.status = status;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void insertCast(String cast) {
        casts.add(cast);
    }

}
