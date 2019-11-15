package modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import entities.CinemaHall;
import entities.Movie;
import entities.MovieListing;
import managers.CustomerMovieListingDBManager;

/**
 * The UI class for the admin movie listing database module
 *
 * @author Gan Shyan
 */

public class CustomerMovieListingsDBModule {
    private int sel = -1;
    private Scanner scanner;
    private CustomerMovieListingDBManager listingDBManager;

    public CustomerMovieListingsDBModule() {
        scanner = new Scanner(System.in);
        listingDBManager = new CustomerMovieListingDBManager();
    }

    public void startUp() {
        System.out.println("****** Welcome to Movie Listing Manager ******");
        while (sel != 0) {
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Customer Movie Listing Module");
            System.out.println("(1) - List out all upcoming movie listings");
            System.out.println("(2) - Search by Movie");
            System.out.println("(3) - Search by Cineplex");

            sel = scanner.nextInt();
            scanner.nextLine();

            switch (sel) {
                case 1:
                    listOutAllUpcomingMovieListings();
                    break;
                case 2:
                    searchByMovie();
                    break;
                case 3:
                    searchByCineplex();
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
            System.out.println("No upcoming movie listings found");
        } else {
            System.out.println(movieListingList.size() + " upcoming movie listings found\n\n");
            for (MovieListing movieListing : movieListingList) {
                if (movieListing.getId() != -1) {
                    listMovieListing(movieListing);
                    System.out.println("\n");
                }
            }
        }
    }

    /**
     * Searches and displays all movie listings that show a chosen movie and yet to occur
     */
    private void searchByMovie() {
        Movie movie;
        while (true) {
            System.out.println("Enter name of movie: ");
            String filmName = scanner.nextLine();

            movie = listingDBManager.searchForMovie(filmName.trim());

            if (movie == null) {
                System.out.println("Movie not found!");
            } else {
                break;
            }
        }
        System.out.println("\n");
        System.out.println("Movie Title: " + movie.getTitle());
        System.out.println("Run time: " + movie.getRunTime());
        System.out.println("Synopsis: " + movie.getSynopsis() + "\n\n");

        List<MovieListing> movieListingList = listingDBManager.searchMovieListingByFilmName(movie.getTitle());

        System.out.println("Number of showtimes found: " + movieListingList.size() + "\n");

        for (MovieListing movieListing : movieListingList) {
            listMovieListing(movieListing);
            System.out.println("\n");
        }
    }

    /**
     * Searches and displays all movie listings that show in a Cineplex location
     */
    private void searchByCineplex() {
        String loc;

        System.out.println("Enter cineplex location: ");
        loc = scanner.nextLine();

        List<MovieListing> movieListingList = listingDBManager.searchMovieListingByCineplex(loc);

        if (movieListingList.size() == 0) {
            System.out.println("No movie listings found!\n");
        } else {
            for (MovieListing m : movieListingList) {
                listMovieListing(m);
                System.out.println("\n");
            }
        }
    }

    /**
     * Display a single movie listing in the database
     *
     * @param movieListing
     */
    public void listMovieListing(MovieListing movieListing) {
        System.out.println("ID: " + movieListing.getId());
        System.out.println("Movie Title: " + movieListing.getMovie().getTitle());
        System.out.println("Cineplex Name: " + movieListing.getCineplexName());
        System.out.println("Cinema Hall: " + movieListing.getCinemaHall().getHallNumber());
        switch (movieListing.getCinemaHall().getCinemaType()) {
            case CinemaHall.NORMAL_HALL:
                System.out.println("Hall type - Normal Hall ");
                break;
            case CinemaHall.PLATINUM_MOVIE_SUITE:
                System.out.println("Hall type - Platinum Movie Suite");
                break;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("Show time: " + dateFormat.format(movieListing.getShowTime()));
        System.out.println("Run time: " + movieListing.getMovie().getRunTime());
    }
}
