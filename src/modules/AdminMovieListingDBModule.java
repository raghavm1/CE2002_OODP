package modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Movie;
import entities.MovieListing;
import managers.AdminMovieListingDBManager;

/**
 * The UI class for the admin movie listing database module
 *
 * @author Gan Shyan
 */
public class AdminMovieListingDBModule {

    private int sel = -1;
    private Scanner scanner;
    private AdminMovieListingDBManager listingDBManager;

    public AdminMovieListingDBModule(String type) {
        scanner = new Scanner(System.in);
        listingDBManager = new AdminMovieListingDBManager(type);
    }

    public void startUp() {
        System.out.println("****** Welcome to Movie Listing Manager ******");

        while (sel != 0) {
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Admin Movie Listing Database Module");
            System.out.println("(1) - Enter New Movie Listing");
            System.out.println("(2) - List out all movie listings");


            sel = scanner.nextInt();
            scanner.nextLine();

            switch (sel) {
                case 1:
                    enterNewMovieListing();
                    break;
                case 2:
                    listOutAllMovieListings();
                    break;
            }
        }
    }

    /**
     * List out all the movie listings in the database
     */
    private void listOutAllMovieListings() {
        List<MovieListing> movieListingList = listingDBManager.getAllMovieListings();
        if (movieListingList.size() == 0) {
            System.out.println("No movie listings found");
        } else {
            System.out.println(movieListingList.size() + " movie listings found");
            for (MovieListing movieListing : movieListingList) {
                listMovieListing(movieListing);
                System.out.println("\n");
            }
        }
    }

    /**
     * Enter a new movie listing into the database
     */
    private void enterNewMovieListing() {
        System.out.println("Enter name of movie: ");
        String movieTitle = scanner.nextLine();

        Movie movie = listingDBManager.searchForMovie(movieTitle);
        if (movie == null) {
            System.out.println("No such movie found!");
            return;
        } else {
            System.out.println("Movie " + movie.getTitle() + " found");
            System.out.println("Run time: " + movie.getRunTime());
        }
        System.out.println("Enter cineplex name: ");
        String cineplexName = scanner.nextLine();
        System.out.println("Enter cinema hall number: ");
        int cinemaHallNumber = scanner.nextInt();
        scanner.nextLine();

        int date;
        while (true) {
            System.out.println("Enter date: ");
            date = scanner.nextInt();
            scanner.nextLine();
            if (date >= 1 && date <= 31) {
                break;
            }
            System.out.println("Invalid date entered");
        }

        int month;
        while (true) {
            System.out.println("Enter month(JAN - 1, Dec - 12):");
            month = scanner.nextInt();
            scanner.nextLine();
            if (month <= 12 && month >= 1) {
                break;
            }
            System.out.println("Invalid month entered");
        }

        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        int hour;
        while (true) {
            System.out.println("Enter hour (24h format): ");
            hour = scanner.nextInt();
            scanner.nextLine();
            if (hour <= 23 && hour >= 0) {
                break;
            }
            System.out.println("Invalid hour entered");
        }

        int minute;
        while (true) {
            System.out.println("Enter minute: ");
            minute = scanner.nextInt();
            scanner.nextLine();
            if (minute <= 59 && minute >= 0) {
                break;
            }
            System.out.println("Invalid minute entered");
        }

        Date startTime = new Date(year - 1900, month - 1, date, hour, minute, 0);

        int id = listingDBManager.getID();
        listingDBManager.insertMovieListing(new MovieListing(id, cineplexName, cinemaHallNumber, startTime, movie));
        System.out.println("Movie listing entered");
    }

    /**
     * Display a single movie listing in the database
     *
     * @param movieListing
     */
    private void listMovieListing(MovieListing movieListing) {
        System.out.println("ID: " + movieListing.getId());
        System.out.println("Movie Title: " + movieListing.getMovie().getTitle());
        System.out.println("Cineplex Name: " + movieListing.getCineplexName());
        System.out.println("Cinema Hall: " + movieListing.getCinemaHall());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("Show time: " + dateFormat.format(movieListing.getShowTime()));
        System.out.println("Run time: " + movieListing.getMovie().getRunTime());
    }
}
