import java.util.Scanner;

import modules.CustomerCineplexDBModule;
import modules.CustomerMovieDBModule;
import modules.CustomerMovieListingsDBModule;

/**
 * The main UI module for Customers.
 *
 * @author Gan Shyan
 */
public class CustomerModule {
    private Scanner scanner;
    private int sel = -1;

    public CustomerModule() {
        scanner = new Scanner(System.in);
    }

    public void startUp() {
        System.out.println("****** Welcome Customer ******");

        while (sel != 0) {
            System.out.println("Customer Module Main Menu:");
            System.out.println("(0): Exit Customer Module");
            System.out.println("(1): Access Movie Database");
            System.out.println("(2): Access Movie Listings Database");
            System.out.println("(3): Access Cineplex Locations Database");

            sel = scanner.nextInt();
            scanner.nextLine();

            switch (sel) {
                case 1:
                    new CustomerMovieDBModule().startUp();
                    break;
                case 2:
                    new CustomerMovieListingsDBModule().startUp();
                    break;
                case 3:
                    new CustomerCineplexDBModule().startUp();
                    break;
            }
        }
    }
}
