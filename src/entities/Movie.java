package entities;

public class Movie {
    private int id;
    private String title;
    private String status;
    private String synopsis;
    private String director;
    private String cast[]; //At least 2
    private Reviews reviews;

    public Movie(int id, String title, String status, String synopsis, String director, String[] cast, Reviews reviews) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }

    public String[] getCast() {
        return cast;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public Movie copy() {
        return new Movie(id, title, status, synopsis, director, cast, reviews);
    }
}
