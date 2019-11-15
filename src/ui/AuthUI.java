package ui;

import java.io.IOException;
import java.util.Scanner;

import manager.AuthManager;

/*
 * UI for authenticating an administrator
 * @author Lakshyajeet Dwivedee
 */
public class AuthUI {
	
    public static boolean showAuthenticationModule() {

    	int numLogin = 0;
    	
    	Scanner sc = new Scanner(System.in); //Initialise Scanner for IO

        //Ask for input thrice and then fail auth
        while (numLogin < 3) {
            try {

                System.out.println("Username:");
                String username = sc.nextLine();
                
                System.out.println("Password:");
                String password = sc.nextLine();

                //If input ie neither 0 nor 1, throw exception
                if (!(AuthManager.authenticateUser(username, password))) {
                    throw new IOException();
                }

                //If input is correct, return true
                return true;

            } catch (IOException e) {

                //Catch exception if input is neither 1 nor 0
                System.out.println("The username and password is incorrect");

            } finally {
            	numLogin++;
            }
        }
        
        //If authentication fails, return false
        return false;
    }
}
