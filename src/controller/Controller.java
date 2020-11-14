package controller;

import model.AdminSystem;
import processing.core.PApplet;

public class Controller {

	private AdminSystem adminSystem;
	
	public Controller() {
		adminSystem= AdminSystem.getInstance();
	}
	
	public void sort() {}
	public void login() {}
	public void searchUser() {}
	public void addContact() {}


	public void getUserInfo(String name, String lastName, String email, String nationality, String phone,
			String password, PApplet app) {
		adminSystem.addUser(name,lastName,email,nationality,phone,password, app);
		
	}
}
