package modules;

import java.util.List;
import java.util.Scanner;

import entities.CinemaHall;
import entities.Cineplex;
import managers.CustomerCineplexDBManager;

/**
 * UI module for CUSTOMERs for accessing the Cineplex Database
 *
 * @author Gan Shyan
 */
public class CustomerCineplexDBModule {

    private int sel = -1;
    private Scanner scanner;
    private CustomerCineplexDBManager customerCineplexDBManager;

    public CustomerCineplexDBModule() {
        scanner = new Scanner(System.in);
        customerCineplexDBManager = new CustomerCineplexDBManager();
    }

    public void startUp() {
        System.out.println("****** Welcome Customer to Cineplex Locations Manager ******\n");

        while (sel != 0) {
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Cineplex Locations Manager");
            System.out.println("(1) - List out all Cineplex location");
            System.out.println("(2) - Search for cinema hall");
            sel = scanner.nextInt();
            scanner.nextLine();

            switch (sel) {
                case 1:
                    listOutCineplexLocations();
                    break;
                case 2:
                    searchForCinemaHall();
                    break;
            }
        }
    }

    /**
     * List out all the cineplex
     */
    private void listOutCineplexLocations() {
        List<Cineplex> cineplexList = customerCineplexDBManager.getAllCineplexes();
        if (cineplexList == null || cineplexList.size() == 0) {
            System.out.println("No Cineplex found");
        } else {
            System.out.println("We currently have " + cineplexList.size() + " locations\n");
            for (Cineplex cineplex : cineplexList) {
                printOutCineplexDetail(cineplex);
                System.out.print("\n\n");
            }
        }

    }

    /**
     * Search for a single cinema hall and print out the details
     */
    private void searchForCinemaHall() {
        System.out.print("\n");

        CinemaHall cinemaHall;

        System.out.print("Enter cinema hall number: ");
        int hallNumber = scanner.nextInt();
        scanner.nextLine();
        cinemaHall = customerCineplexDBManager.searchCinemaHall(hallNumber);
        if (cinemaHall == null) {
            System.out.println("No cinema hall found");
        } else {
            printOutCinemaHallDetail(cinemaHall);
        }
    }

    /**
     * Print out the details of a single cineplex on the console
     */
    private void printOutCineplexDetail(Cineplex cineplex) {
        System.out.print("\n");
        System.out.println("Cineplex - " + cineplex.getName());
        System.out.println("Cineplex code - " + cineplex.getCineplexCode());
        System.out.println("Address - " + cineplex.getAddress());
        System.out.println("Number of cinema halls - " + cineplex.getCinemaHallList().size());
        for (CinemaHall cinemaHall : cineplex.getCinemaHallList()) {
            System.out.print("*** Cinema hall " + cinemaHall.getHallNumber() + ", Seating capacity - " + cinemaHall.getNumberOfSeats());
        }
    }

    private void printOutCinemaHallDetail(CinemaHall cinemaHall) {
        System.out.println("Cinema hall number - " + cinemaHall.getHallNumber());
        System.out.println("Seating capacity - " + cinemaHall.getNumberOfSeats());
        System.out.println("****** Floor Plan ******\n");
        cinemaHall.getFloorPlan().printOutFloorPlan();
    }
}
