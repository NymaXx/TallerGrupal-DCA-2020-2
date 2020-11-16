package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Contact extends Person implements Comparable<Contact>{
	private PFont font;
	

	public Contact(String name, String lastName, String nationality, String email, String phone, PApplet app) {
		super(name, lastName, nationality, email, phone, app);
		font=null;
	}

	@Override
	public int compareTo(Contact c1) {
		return getName().compareTo(c1.getName());
	}


	
	
	@Override
	public void draw(int posy) {
		//Fix rect and Y
		getApp().noFill();
		getApp().stroke(0);
		getApp().rect(323,posy-20,634,25);
		getApp().fill(0);
		getApp().textFont(font);
		getApp().textAlign(PConstants.CENTER);
		getApp().text("Name: "+getName(),500,posy);
		getApp().text("Last Name: "+getLastName(),803,posy);
		getApp().text("Nationality: "+getNationality(),500,posy+37);
		getApp().text("Cell Phone: "+getPhone(),803,posy+37);
		getApp().text("Email: "+getEmail(),500,posy+79);
		
		
	}

	public void setFont(PFont font) {
		this.font = font;
	}
}
