package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
/**
 * User class 

 * @author: Juan P. Sanin

 * @version: 1.1 11/14/2020

 */
public class User extends Person{
	private String password;
	private ArrayList<Contact> contacts;
	private ArrayList<Trip> trips;
	private LastNameComparator lnc;
	private NationalityComparator nc;
	private EmailComparator ec;
	private PhoneComparator pc;

	public User(String name, String lastName, String nationality, String email, String phone,String password, PApplet app) {
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
	
	public void purchaseTrip(int trip) {
		switch(trip) {
		case 1:
			Mars mars= new Mars();
			trips.add(mars);
			break;
		case 2:
			Moon moon= new Moon();
			trips.add(moon);
			break;
		case 3:
			Intercontinental inter= new Intercontinental();
			trips.add(inter);
			break;
		}
	}
	public void sortContacts() {}
	
	@Override
	public void draw() {
		getApp().fill(0);
		getApp().textAlign(PConstants.CENTER);
		getApp().text(getName()+" "+getLastName(),1154,175);
		getApp().text(getEmail(),1154,214);
		getApp().text(getNationality(),1154,247);
		getApp().text(getPhone(),1154,280);
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
