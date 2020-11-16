package model;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 * AdminSystem class Final Version

 * @author: Juan P. Sanin

 * @version: 1.1 11/16/2020

 */
public class AdminSystem {
	private ArrayList<User> users;
	private int currentUser;
	private int tripType;
	private static AdminSystem onlyInstance;

	/** 
	 * 
	 *	Constructor method AdminSystem<br>
		<b> pre: </b> <br>
		<b> post: </b> Creates the AdminSystem<br>
	 */
	private AdminSystem() {
		users = new ArrayList<User>();
		currentUser=0;
		tripType=0;
	}

	/** 
	 * 
	 *	Getter method for AdminSystem, singleton implementation<br>
		<b> pre: </b> <br>
		<b> post: </b> Creates the AdminSystem if it is not yet created<br>
	 */
	public static AdminSystem getInstance() {
		if(onlyInstance == null) {
			onlyInstance = new AdminSystem();
		}
		return onlyInstance;
	}

	/** 
	 * 
	 * Method for communicating sort to the user class<br>
		<b> pre: </b> <br>
		<b> post: </b> Sends sort type to the user<br>
		@param sort, int representing the sort type
	 */
	public void sort(int sort) {
		users.get(currentUser).sortContacts(sort);
	}


	/** 
	 * 
	 * Method for creating initial user<br>
		<b> pre: </b> <br>
		<b> post: </b> Initial user created and added<br>
		@param app, PApplet processing core
	 */
	public void initialUser(PApplet app) {
		User u= new User("Elon", "Musk", "American", "elonmusk@tesla.com", "4791874423", "123", app);
		users.add(u);
	}


	/**
	 * Method for adding user<br>
		<b> pre: </b> <br>
		<b> post: </b> Adds user to list<br>
		@param name, the users name
		@param lastName, the users last name
		@param nationality, the users nationality
		@param email, the users email
		@param phone, the users phone
		@param password, the users password
		@param app, PApplet processing core
	 */
	public void addUser(String name, String lastName, String nationality,String email, String phone, String password,
			PApplet app) {
		User u= new User(name, lastName, nationality, email, phone, password, app);
		users.add(u);
	}
	
	
	/** 
	 * 
	 * Method for searching for a user <br>
		<b> pre: </b> <br>
		<b> post: </b> The user is searched for<br>
		@param email, the users email
		@return int array, representing if user is found and their position
	 */
	public int[] searchUser(String email) {
		boolean found=false;
		int[] info= new int[2];
		info[0]=0;
		info[1]=0;
		for(int i = 0; i<users.size() && found==false;i++) {
			String compareEmail=users.get(i).getEmail();
			if(email.equals(compareEmail)) {
				found=true;
				info[0]=1;
				info[1]=i;
			}
		}

		return info;
	}

	
	/** 
	 * 
	 * Method for user login<br>
		<b> pre: </b> <br>
		<b> post: </b> Sees if user can login<br>
		@param pos, position of the user in the users array
		@param password, the users password
		@return success, representing if passwords match or not so it can login
	 */
	public boolean login(int pos, String password) {
		boolean success=false;
		if(password.equals(users.get(pos).getPassword())) {
			success=true;
			currentUser=pos;
		}

		return success;
	}
	
	
	/** 
	 * 
	 * Method for drawing user<br>
		<b> pre: </b> <br>
		<b> post: </b> User is drawn<br>
		@param y, the initial Y axis position of it being drawn
	 */
	public void drawUser(int y) {
		users.get(currentUser).draw(y);

	}

	
	/** 
	 * 
	 * Method for adding trip to user<br>
		<b> pre: </b> <br>
		<b> post: </b> Trip is added to user list of trips<br>
		@param trip, number from 1 to 3 representing the trip type
	 */
	public void addTrip(int trip) {
		users.get(currentUser).purchaseTrip(trip);
	}

	/** 
	 * 
	 * Method for adding contact to user contact list<br>
		<b> pre: </b> <br>
		<b> post: </b> Adds contact to user contact list<br>
		@param name, the contacts name
		@param lastName, the contacts last name
		@param nationality, the contacts nationality
		@param email, the contacts email
		@param phone, the contacts phone
		@param app, PApplet processing core
	 */
	public void addContact(String name, String lastName, String nationality, String email, String phone, PApplet app) {
		users.get(currentUser).addContact(name,lastName,nationality,email,phone,app);
	}

	
	/** 
	 * Getters and Setters
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	public int getCurrentUser() {
		return currentUser;
	}

	public void setTripType(int type) {

		tripType=type;

	}

	public double getTripPrice() {
		double price=0;
		switch(tripType) {
		case 1:
			price=8000000.00;
			break;
		case 2:
			price=850000.00;
			break;
		case 3:
			price=2500.00;
			break;
		}
		return price;

	}

	public int getTripType() {

		return this.tripType;
	}




}
