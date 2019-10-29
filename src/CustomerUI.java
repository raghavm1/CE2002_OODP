import java.io.IOException;
import java.util.*;
/*
* Class to show initial options to the customer
* @author Lakshyajeet Dwivedee 
*/
public class CustomerUI {
    
    /*
     * Show options to customer
     */
     private void showCustomerOptions() {
         System.out.println("Please choose one of the following:");
         System.out.println("1. See movie listings");
         System.out.println("2. View booking history");
         System.out.println("3. List top 5 movies by ticket sales");
         System.out.println("4. List top 5 movies by reviewers' ratings");
     }

    /**
     * Get the user's choice
     * @return userChoice The choice input by the user
     */
    private int getChoice(){
    
        Scanner sc = new Scanner(System.in); //Initialise Scanner for IO
        int userChoice;
        
        //Keep asking for input in while loop until input is correct
        while(true){
          try {
              
            // Get input from user
            userChoice = sc.nextInt();
            
            //If input ie neither 0 nor 1, throw exception
            if(!(userChoice >= 1 && userChoice <= 4)){
              throw new IOException();
            }
            
            //If input is correct, break out of while loop
            break;
            
          } catch (IOException e) { 
              
            //Catch exception if input is neither 1 nor 0
            System.out.println("That is an invalid option.");
            showCustomerOptions();
            
            }
          }
          return userChoice;
    }
    
    /* 
     * Display the options and use CustomerController to execute the options
     */
    public void display() {
        
        // Instantiate a CustomerController
            CustomerController customerController = new CustomerController();
        
        // Run loop, wait for user to complete choice, run again
        do {
            // Show the options to the customer
            showCustomerOptions();
            // Get the user's choice
            int choice = getChoice();
            
        } while(customerController.controlChoice(choice));
    }
}
