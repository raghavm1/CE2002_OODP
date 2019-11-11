import java.util.Scanner;

/**
 * The main UI module for Customers.
 *
 * @author Gan Shyan
 */
public class CustomerModule {
    private Scanner scanner;
    private int choice = -1;

    public CustomerModule() {
        scanner = new Scanner(System.in);
    }

    public void startUp() {
        System.out.println("****** Welcome Customer ******");

        while (choice != 0) {
            System.out.println("Customer Module Main Menu:");
            System.out.println("(0): Exit Customer Module");
            System.out.println("(1): Access Movie Database");
            System.out.println("(2): Access Movie Listings Database");

            choice = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
