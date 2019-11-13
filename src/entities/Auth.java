package entities;

/*
 * Entity class representing a user's authentication details
 * @author Lakshyajeet Dwivedee
 */
public class Auth {
	
	/**
     * Store the user's username
     */
	private String username;
	/**
     * Store the user's password
     */
	private String password;
	
	/**
     * Constructor
     *
     * @param username Username of the user
     * @param password Password of the user
     */
	public Auth(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Returns the username of this user
	 * @return The username of the user
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Returns the password of the user
	 * @return The password of the user
	 */
	public String getPassword() {
		return this.password;
	}
}
