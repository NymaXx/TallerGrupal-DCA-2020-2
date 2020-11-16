package controller;

import model.AdminSystem;
import processing.core.PApplet;


/**
 * Controller class Final Version

 * @author: Juan P. Sanin

 * @version: 1.1 11/16/2020

 */
public class Controller {

	private AdminSystem adminSystem;
	
	/** 
	 * 
	 *	Constructor method Controller<br>
		<b> pre: </b> <br>
		<b> post: </b> Creates the controller by instancing the logic class<br>
	 */
	public Controller() {
		adminSystem= AdminSystem.getInstance();
	}

	/** 
	 * 
	 * Method for communicating sort to the logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Sends sort type to the logic<br>
		@param sort, int representing the sort type
	 */
	public void sort(int sort) {
		adminSystem.sort(sort);
	}

	/** 
	 * 
	 * Method for communicating user information to the logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Sends user information to the logic class<br>
		@param name, the users name
		@param lastName, the users last name
		@param nationality, the users nationality
		@param email, the users email
		@param phone, the users phone
		@param password, the users password
		@param app, PApplet processing core
	 */
	public void getUserInfo(String name, String lastName,String nationality, String email,  String phone,
			String password, PApplet app) {
		adminSystem.addUser(name,lastName,nationality,email,phone,password, app);

	}
	
	/** 
	 * 
	 * Method for communicating user login to the logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Sends user login attempt to the logic class<br>
		@param pos, position of the user in the users array
		@param password, the users password
		@return boolean, representing if passwords match or not
	 */
	public boolean login(int pos, String password) {
		return adminSystem.login(pos, password);
	}

	/** 
	 * 
	 * Method for communicating user to search to logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Search user attempt to the logic class<br>
		@param email, the users email
		@return int array, representing if user is found and their position
	 */
	public int[] searchUser(String email) {
		return adminSystem.searchUser(email);
	}

	
	/** 
	 * 
	 * Method for communicating initial user creation to logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Initial user communicated to logic class<br>
		@param app, PApplet processing core
	 */
	public void initialUser(PApplet app) {
		adminSystem.initialUser(app);
	}

	/** 
	 * 
	 * Method for communicating to draw user to logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Draw user communicated to logic class<br>
		@param y, the initial Y axis position of it being drawn
	 */
	public void drawUser(int y) {
		adminSystem.drawUser(y);

	}

	/** 
	 * 
	 * Method for communicating to add trip to logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Add trip communicated to logic class<br>
		@param trip, number from 1 to 3 representing the trip type
	 */
	public void addTrip(int trip) {
		//1 Mars, 2 Moon, 3 Intercontinental
		adminSystem.addTrip(trip);
	}

	/** 
	 * 
	 * Method for communicating contact information to the logic class<br>
		<b> pre: </b> <br>
		<b> post: </b> Sends contact information to the logic class<br>
		@param name, the contacts name
		@param lastName, the contacts last name
		@param nationality, the contacts nationality
		@param email, the contacts email
		@param phone, the contacts phone
		@param app, PApplet processing core
	 */
	public void getContactInfo(String name, String lastName, String nationality, String email, String phone,
			PApplet app) {
		adminSystem.addContact(name,lastName,nationality,email,phone,app);

	}
	
	
	/**
	 * Getters and setters
	 */
	public AdminSystem getAdminSystem() {
		return adminSystem;
	}

	public void setTripType(int type) {
		adminSystem.setTripType(type);
	}

	public double getTripPrice() {
		return adminSystem.getTripPrice();
	}




}
