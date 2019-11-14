package modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.CinemaHall;
import entities.Cineplex;
import entities.Movie;
import entities.MovieListing;
import managers.AdminCineplexDBManager;
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
    private AdminCineplexDBManager cineplexDBManager;

    public AdminMovieListingDBModule(String type) {
        scanner = new Scanner(System.in);
        listingDBManager = new AdminMovieListingDBManager(type);
        cineplexDBManager = new AdminCineplexDBManager();
    }

    public void startUp() {
        System.out.println("****** Welcome to Movie Listing Manager ******");

        while (sel != 0) {
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Admin Movie Listing Database Module");
            System.out.println("(1) - Enter New Movie Listing");
            System.out.println("(2) - Remove Movie Listing");
            System.out.println("(3) - Update MovieListing");
            System.out.println("(4) - List out all upcoming movie listings");
            System.out.println("(5) - List out all previous listings");
            System.out.println("(6) - List out all cancelled listings");

            sel = scanner.nextInt();
            scanner.nextLine();

            switch (sel) {
                case 0:
                    listingDBManager.saveDatabase();
                    break;
                case 1:
                    enterNewMovieListing();
                    break;
                case 2:
                    removeMovieListing();
                    break;
                case 3:
                    //updateMovieListing();
                    break;
                case 4:
                    listOutAllUpcomingMovieListings();
                    break;
                case 5:
                    listOutAllPreviousMovieListings();
                    break;
                case 6:
                    listOutAllCancelledMovieListings();
                    break;
            }
        }
    }

    /**
     * List out all the movie listings in the database that have yet to happen
     */
    private void listOutAllUpcomingMovieListings() {
        List<MovieListing> movieListingList = listingDBManager.getAllUpcomingMovieListings();
        if (movieListingList.size() == 0) {
            System.out.println("No movie listings found");
        } else {
            System.out.println(movieListingList.size() + " movie listings found\n\n");
            for (MovieListing movieListing : movieListingList) {
                if (movieListing.getId() != -1) {
                    listMovieListing(movieListing);
                    System.out.println("\n");
                }
            }
        }
    }

    /**
     * List out all the movie listings in the database that are already over
     */
    private void listOutAllPreviousMovieListings() {
        List<MovieListing> movieListingList = listingDBManager.getAllPreviousMovieListings();
        if (movieListingList.size() == 0) {
            System.out.println("No previous movie listings found");
        } else {
            System.out.println(movieListingList.size() + " previous movie listings found\n\n");
            for (MovieListing movieListing : movieListingList) {
                listMovieListing(movieListing);
                System.out.println("\n");
            }
        }
    }


    private void listOutAllCancelledMovieListings() {
        List<MovieListing> movieListingList = listingDBManager.getAllCancelledMovieListings();
        if (movieListingList.size() == 0) {
            System.out.println("No cancelled movie listings found");
        } else {
            System.out.println(movieListingList.size() + " cancelled movie listings found\n\n");
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

        // Admin choices the movie to create a new movie listing for
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

        // Search for cineplex
        Cineplex cineplex;
        while (true) {
            // Find the cineplex for the new movie listing
            System.out.println("Enter cineplex id: ");
            int cineplexId = scanner.nextInt();
            scanner.nextLine();
            cineplex = cineplexDBManager.searchCineplex(cineplexId);
            if (cineplex != null) {
                break;
            } else {
                System.out.println("Cineplex not found!");
            }
        }

        CinemaHall cinemaHall = null;
        while (true) {
            System.out.println("Enter cinema hall number: ");
            int cinemaHallNumber = scanner.nextInt();
            scanner.nextLine();

            for (CinemaHall c : cineplex.getCinemaHallList()) {
                if (c.getHallNumber() == cinemaHallNumber) {
                    cinemaHall = c.copy();
                    break;
                }
            }

            if (cinemaHall != null) {
                break;
            } else {
                System.out.println("Cinema hall not found!");
            }
        }


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
        listingDBManager.insertMovieListing(new MovieListing(id, cineplex.getName(), cinemaHall, startTime, movie));
        System.out.println("Movie listing entered");
    }

    /**
     * Remove a movie listing from the database
     */
    private void removeMovieListing() {
        int movieListingID;
        while (true) {
            while (true) {
                System.out.println("\n");
                System.out.println("Enter movie listing ID: ");
                movieListingID = scanner.nextInt();
                scanner.nextLine();
                if (movieListingID >= 0) {
                    break;
                }
                System.out.println("Invalid movie listing ID!");
            }
            MovieListing movieListing = listingDBManager.getMovieListingByID(movieListingID);
            if (movieListing == null) {
                System.out.println("No Movie Listing Found!\n");
            } else {
                System.out.println("Movie Listing found!");
                listMovieListing(movieListing);
                System.out.println("\n Confirm cancellation of movie listing? Y(Yes)/N(No) : ");
                char c = scanner.nextLine().charAt(0);
                if (c == 'y' || c == 'Y') {
                    listingDBManager.deleteMovieListing(movieListing);
                }
                break;
            }
        }


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
        System.out.println("Cinema Hall: " + movieListing.getCinemaHall().getHallNumber());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("Show time: " + dateFormat.format(movieListing.getShowTime()));
        System.out.println("Run time: " + movieListing.getMovie().getRunTime());
    }
}
