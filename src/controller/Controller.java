package controller;

import model.AdminSystem;
import processing.core.PApplet;

public class Controller {

	private AdminSystem adminSystem;
	
	public Controller() {
		adminSystem= AdminSystem.getInstance();
	}
	
	public void sort() {}
	
	public void addContact() {}


	public void getUserInfo(String name, String lastName,String nationality, String email,  String phone,
			String password, PApplet app) {
		adminSystem.addUser(name,lastName,nationality,email,phone,password, app);
		
	}
	
	public boolean login(int pos, String password) {
		return adminSystem.login(pos, password);
	}
	
	public int[] searchUser(String email) {
		return adminSystem.searchUser(email);
	}
	
	public void initialUser(PApplet app) {
		adminSystem.initialUser(app);
	}

	public void drawUser() {
		adminSystem.drawUser();
		
	}
	
	public void addTrip(int trip) {
		//1 Mars, 2 Moon, 3 Intercontinental
		adminSystem.addTrip(trip);
	}

	public void getContactInfo(String name, String lastName, String nationality, String email, String phone,
			PApplet app) {
		adminSystem.addContact(name,lastName,nationality,email,phone,app);
		
	}

}
