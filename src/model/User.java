package model;

import java.util.ArrayList;
import java.util.Collections;

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
	/**sort will represent how the contacts are sorted 
	0 is for not sorted
	1 is for sorting by name
	2 is for sorting by nationality
	3 if for sorting by lastName
	4 is for sorting by cell phone 
	5 is for sorting by email
	 */

	public User(String name, String lastName, String nationality, String email, String phone,String password, PApplet app) {
		super(name, lastName, nationality, email, phone, app);
		this.password=password;
		contacts= new ArrayList<Contact>();
		trips= new ArrayList<Trip>();
		lnc= new LastNameComparator();
		nc= new NationalityComparator();
		ec= new EmailComparator();
		pc= new PhoneComparator();
		/*contacts.add(new Contact("Juan","Sanin","Colombian","juan@gmail.com","3214567879",app));
		contacts.add(new Contact("Carlos","Pedroza","Mexican","carlos@gmail.com","3147856968",app));
		contacts.add(new Contact("Jorge","Lloreda","Spainiard","jorge@gmail.com","35466781223",app));
		contacts.add(new Contact("Miguel","Tejada","Argentinian","miguel@gmail.com","3165664748",app));
		contacts.add(new Contact("James","Conner","American","james@gmail.com","3187287459",app));
		contacts.add(new Contact("Daniel","Robinson","English","daniel12@gmail.com","3183891259",app));
		contacts.add(new Contact("Daniel","Jones","Maldivian","daniel420@gmail.com","3145647484",app));
		contacts.add(new Contact("Juan Jose","Cortes","Colombian","juanjose@gmail.com","3447748553",app));*/
	
	}

	
	public void addContact(String name, String lastName, String nationality, String email, String phone, PApplet app) {
		Contact c= new Contact(name, lastName, nationality, email, phone, app);
		contacts.add(c);
		for(int i = 0; i<contacts.size();i++) {
			System.out.println(contacts.get(i).getName());
			System.out.println(contacts.get(i).getLastName());
			System.out.println(contacts.get(i).getEmail());
			System.out.println(contacts.get(i).getNationality());
			System.out.println(contacts.get(i).getPhone());
			System.out.println(">>>>>>>>><<<<<<<<<<");
			
		}
	}
	
	public void purchaseTrip(int trip) {
		switch(trip) {
		case 1:
			System.out.println("Mars");
			Mars mars= new Mars();
			trips.add(mars);
			break;
		case 2:
			System.out.println("Moon");
			Moon moon= new Moon();
			trips.add(moon);
			break;
		case 3:
			System.out.println("Inter");
			Intercontinental inter= new Intercontinental();
			trips.add(inter);
			break;
		}
	
	}
	
	
	public void sortContacts(int sort) {
		switch(sort) {

		case 1:
			Collections.sort(contacts);
			break;
		case 2:
			Collections.sort(contacts,nc);
			break;
		case 3:
			Collections.sort(contacts,lnc);
			break;
		case 4:
			Collections.sort(contacts,pc);
			break;
		case 5:
			Collections.sort(contacts,ec);
			break;
		}
	}
	
	@Override
	public void draw(int y) {
		getApp().fill(0);
		getApp().textAlign(PConstants.CENTER);
		getApp().text(getName()+" "+getLastName(),1154,y+175);
		getApp().text(getEmail(),1154,y+214);
		getApp().text(getNationality(),1154,y+247);
		getApp().text(getPhone(),1154,y+280);
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

	public ArrayList<Trip> getTrips() {
		return trips;
	}

}
