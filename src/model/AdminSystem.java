package model;

import java.util.ArrayList;
import processing.core.PApplet;

public class AdminSystem {
	private ArrayList<User> users;
	private static AdminSystem onlyInstance;

	private AdminSystem() {
		users = new ArrayList<User>();
	}
	
	public static AdminSystem getInstance() {
		if(onlyInstance == null) {
			onlyInstance = new AdminSystem();
		}
		return onlyInstance;
	}
	
	public void sort() {}
	public void login() {}
	
	public void addUser(String name, String lastName, String email, String nationality, String phone, String password,
			PApplet app) {
		User u= new User(name, lastName, email, nationality, phone, password, app);
		users.add(u);
		for(int i = 0; i<users.size();i++) {
			System.out.println(users.get(i).getName());
			System.out.println(users.get(i).getLastName());
			System.out.println(users.get(i).getEmail());
			System.out.println(users.get(i).getNationality());
			System.out.println(users.get(i).getPhone());
			System.out.println(users.get(i).getPassword());
			System.out.println(">>>>>>>>><<<<<<<<<<");
		}
		
	}
	public void searchUser() {}
	public void addContact() {}

	public ArrayList<User> getUsers() {
		return users;
	}
	
	
}
