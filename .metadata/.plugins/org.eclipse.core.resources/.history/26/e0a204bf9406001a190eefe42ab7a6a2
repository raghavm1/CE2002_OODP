import modules.AuthModule;

/*
 * Class controls which system UI to show based on input userType
 * @author Lakshyajeet Dwivedee
 */
public class StartupController {

    /**
     * Store if the user is a customer or staff (0 = Staff, 1 = Customer)
     */
    private int userType;

    /**
     * Creates a new StartupController with the given userType
     * userType must be given
     *
     * @param userType Type of user as input by the user
     */
    public StartupController(int userType) {
        this.userType = userType;
    }

    /**
     * Create system UI based on input user type and then display it
     */
    public void showUserSystem() {
        if (this.userType == 0) { //If the user said they are a staff member
        	
        	//Ask the user for their username and password
        	boolean isAuth = AuthModule.showAuthenticationModule();
        	// If authentication fails, return to startup
        	if(isAuth == false) {
        		return;
        	}

            //Create a new StaffUI Instance
            AdminModule adminModule = new AdminModule();
            // Display the CustomerUI
            adminModule.startUp();

        } else if (this.userType == 1) { //If the user said they are a customer

            //Create a new CustomerUI Instance
            CustomerModule customerUI = new CustomerModule();
            //Display the CustomerUI
            customerUI.startUp();
        }
    }
}
