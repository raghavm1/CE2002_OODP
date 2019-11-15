package modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Movie;
import managers.AdminMovieDBManager;

/**
 * The UI class for the admin movie database module
 *
 * @author Gan Shyan
 */
public class AdminMovieDBModule {

    private int sel = -1;
    private Scanner scanner;

    private AdminMovieDBManager adminMovieDBManager;

    public AdminMovieDBModule(String userType) {
        scanner = new Scanner(System.in);
        adminMovieDBManager = new AdminMovieDBManager(userType);
    }

    public void startUp() {
        System.out.println("****** Welcome To Movie Manager ******\n");

        while (sel != 0) {
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Admin Movie Database Module");
            System.out.println("(1) - Enter New Movie");
            System.out.println("(2) - Change Movie Status");
            System.out.println("(3) - Search For Movie");
            System.out.println("(4) - List All Movie");

            sel = scanner.nextInt();
            scanner.nextLine();

            switch (sel) {
                case 0:
                    adminMovieDBManager.saveDatabase();
                    break;
                case 1:
                    enterNewMovie();
                    break;
                case 2:
                    changeMovieStatus();
                    break;
                case 3:
                    searchForMovie();
                    break;
                case 4:
                    listAllMovies();
                    break;
            }
        }
    }

    /**
     * Insert a new movie into the movie database
     */
    private void enterNewMovie() {
        System.out.println("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.println("Enter runtime (minutes): ");
        int runTime = scanner.nextInt();
        scanner.nextLine();

        int genre;

        while (true) {
            System.out.println("\nMovie genres:");
            System.out.println("(1) - BLOCKBUSTER\n" +
                    "(2) - ROMANTIC\n" +
                    "(3) - COMEDY\n" +
                    "(4) - CRIME\n" +
                    "(5) - FANTASY\n" +
                    "(6) - HISTORY\n" +
                    "(7) - HORROR\n" +
                    "(8) - THREE_D\n");

            genre = scanner.nextInt();
            scanner.nextLine();
            if (1 <= genre && genre <= 8) {
                break;
            } else {
                System.out.println("Invalid genre chosen");
            }
        }

        System.out.println("Enter movie synopsis: ");
        String synopsis = scanner.nextLine();
        System.out.println("Enter movie director: ");
        String director = scanner.nextLine();

        System.out.println("Enter number of casts: ");
        int i = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> casts = new ArrayList<String>();
        for (int j = 0; j < i; j++) {
            System.out.println("Enter cast " + (j + 1) + " : ");
            String c = scanner.nextLine();
            casts.add(c);
        }

        System.out.println("Enter censor classification: ");
        System.out.println("(1) : G");
        System.out.println("(2) : PG");
        System.out.println("(3) : NC16");
        System.out.println("(4) : M18");
        System.out.println("(5) : R21");
        int censorClassificationIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter status: ");
        System.out.println(Movie.COMING_SOON + " : Coming soon");
        System.out.println(Movie.PREVIEW + " : Preview");
        System.out.println(Movie.NOW_SHOWING + " : Now showing");
        System.out.println(Movie.END_OF_SHOWING + " : End of showing");
        int status = scanner.nextInt();
        scanner.nextLine();

        Movie newMovie = new Movie(title.trim(), runTime, genre, status, synopsis, director, casts, censorClassificationIndex, 0);

        adminMovieDBManager.insertMovie(newMovie);
    }

    /**
     * Search for a single movie by name
     */
    private void searchForMovie() {
        System.out.println("Enter name of movie: ");
        String name = scanner.nextLine();
        Movie movie = adminMovieDBManager.searchMovie(name);

        if (movie == null) {
            System.out.println("No movie found");
        } else {
            System.out.println("Movie found \n");
            listMovie(movie);
        }
    }

    /**
     * Allow admin to update the status of a movie
     */
    private void changeMovieStatus() {
        System.out.println("Enter name of movie to change: ");
        String movieName = scanner.nextLine();

        Movie oldMovie = adminMovieDBManager.searchMovie(movieName);
        if (oldMovie == null) {
            System.out.println("No movie found");
            return;
        } else {
            System.out.println("Movie found, current status: ");
        }

        switch (oldMovie.getStatus()) {
            case Movie.COMING_SOON:
                System.out.println("Coming soon");
                break;
            case Movie.PREVIEW:
                System.out.println("Preview");
                break;
            case Movie.NOW_SHOWING:
                System.out.println("Now Showing");
                break;
            case Movie.END_OF_SHOWING:
                System.out.println("End of showing");
                break;
        }

        System.out.println("Update status: ");
        System.out.println(Movie.COMING_SOON + " : Coming soon");
        System.out.println(Movie.PREVIEW + " : Preview");
        System.out.println(Movie.NOW_SHOWING + " : Now showing");
        System.out.println(Movie.END_OF_SHOWING + " : End of showing");
        int status = scanner.nextInt();
        scanner.nextLine();

        oldMovie.setStatus(status);
        System.out.println("Movie status updated");

    }

    /**
     * List out all the movies in the movie database in the UI
     */
    private void listAllMovies() {
        List<Movie> allMovies = adminMovieDBManager.getAllMovies();

        System.out.println("Number of movies: " + allMovies.size());

        for (Movie movie : allMovies) {
            listMovie(movie);
            System.out.println("\n\n");
        }
    }

    /**
     * Display a single movie in the UI
     *
     * @param movie
     */
    private void listMovie(Movie movie) {
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Runtime: " + movie.getRunTime() + " minutes");
        System.out.print("Status: ");
        switch (movie.getStatus()) {
            case Movie.COMING_SOON:
                System.out.println("Coming soon");
                break;
            case Movie.PREVIEW:
                System.out.println("Preview");
                break;
            case Movie.NOW_SHOWING:
                System.out.println("Now Showing");
                break;
            case Movie.END_OF_SHOWING:
                System.out.println("End of showing");
                break;
        }
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Synopsis: " + movie.getSynopsis());

        System.out.print("Genre: ");
        switch (movie.getTypeOfMovie()) {
            case 1:
                System.out.print("Blockbuster");
                break;
            case 2:
                System.out.print("Romantic");
                break;
            case 3:
                System.out.print("Comedy");
                break;
            case 4:
                System.out.print("Crime");
                break;
            case 5:
                System.out.print("Fantasy");
                break;
            case 6:
                System.out.print("History");
                break;
            case 7:
                System.out.print("Horror");
                break;
            case 8:
                System.out.print("3D");
        }
        System.out.print("\n");

        System.out.println("Casts: ");
        int i = 1;
        for (String cast : movie.getCasts()) {
            System.out.println(i + ": " + cast);
            i += 1;
        }

        int censor = movie.getCensorClassification();
        String censorStr;

        switch (censor) {
            case Movie.G:
                censorStr = "G";
                break;
            case Movie.PG:
                censorStr = "PG";
                break;
            case Movie.NC16:
                censorStr = "NC16";
                break;
            case Movie.M18:
                censorStr = "M18";
                break;
            case Movie.R21:
                censorStr = "R21";
                break;
            default:
                censorStr = "No Rating";
        }
        System.out.println("Censor Classification: " + censorStr);

        System.out.println("Average rating: " + movie.getReviews().getAverageRating());
        System.out.print("Sales figure: " + movie.getSales());
    }
}
