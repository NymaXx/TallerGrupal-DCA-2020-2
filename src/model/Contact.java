package model;

import processing.core.PApplet;
import processing.core.PConstants;

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
		//Fix rect and Y
		getApp().fill(0);
		getApp().textAlign(PConstants.CENTER);
		getApp().text("Name:"+getName(),1154,175);
		getApp().text("Last Name:"+getLastName(),1154,175);
		getApp().text("Email:"+getEmail(),1154,214);
		getApp().text("Nationality:"+getNationality(),1154,247);
		getApp().text("Call Phone:"+getPhone(),1154,280);
		
	}

}
