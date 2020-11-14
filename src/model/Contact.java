package model;

import processing.core.PApplet;

public class Contact extends Person implements Comparable<Contact>{

	public Contact(String name, String lastName, String nationality, String email, String phone, PApplet app) {
		super(name, lastName, nationality, email, phone, app);

	}

	@Override
	public int compareTo(Contact c1) {
		return getName().compareTo(c1.getName());
	}

	@Override
	public void draw() {
		
	}

}
