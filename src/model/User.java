package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class User extends Person{
	private String password;
	private ArrayList<Contact> contacts;
	private ArrayList<Trip> trips;
	private LastNameComparator lnc;
	private NationalityComparator nc;
	private EmailComparator ec;
	private PhoneComparator pc;

	public User(String name, String lastName, String nationality, String email, Long phone,String password, PApplet app) {
		super(name, lastName, nationality, email, phone, app);
		this.password=password;
		contacts= new ArrayList<Contact>();
		trips= new ArrayList<Trip>();
		lnc= new LastNameComparator();
		nc= new NationalityComparator();
		ec= new EmailComparator();
		pc= new PhoneComparator();
	}

	
	public void addContact() {}
	public void purchaseTrip() {}
	public void sortContacts() {}
	
	@Override
	public void draw() {
		
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public ArrayList<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}


	public ArrayList<Trip> getTrips() {
		return trips;
	}


	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}

}
