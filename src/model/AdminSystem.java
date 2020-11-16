package model;

import java.util.ArrayList;
import processing.core.PApplet;

public class AdminSystem {
	private ArrayList<User> users;
	private int currentUser;
	private static AdminSystem onlyInstance;

	private AdminSystem() {
		users = new ArrayList<User>();
		currentUser=0;
		
	}
	
	public static AdminSystem getInstance() {
		if(onlyInstance == null) {
			onlyInstance = new AdminSystem();
		}
		return onlyInstance;
	}
	
	public void sort(int sort) {
		users.get(currentUser).sortContacts(sort);
	}
	
	public void initialUser(PApplet app) {
		User u= new User("Elon", "Musk", "American", "elonmusk@tesla.com", "4791874423", "123", app);
		users.add(u);
	}
	public void addUser(String name, String lastName, String nationality,String email, String phone, String password,
			PApplet app) {
		User u= new User(name, lastName, nationality, email, phone, password, app);
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
	
	public boolean login(int pos, String password) {
		boolean success=false;
		if(password.equals(users.get(pos).getPassword())) {
			success=true;
			currentUser=pos;
		}
		
		return success;
	}

	public void drawUser(int y) {
		users.get(currentUser).draw(y);
		
	}

	public void addTrip(int trip) {
		users.get(currentUser).purchaseTrip(trip);
	}

	
	public void addContact(String name, String lastName, String nationality, String email, String phone, PApplet app) {
		users.get(currentUser).addContact(name,lastName,nationality,email,phone,app);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public int getCurrentUser() {
		return currentUser;
	}

	
	
	
}
