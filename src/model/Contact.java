package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

/**
 * Contact class 
 * Final Version

 * @author: Juan P. Sanin

 * @version: 1.3 11/16/2020

 */
public class Contact extends Person implements Comparable<Contact>{
	private PFont font;
	
	/** 
	 * 
	 * Constructor Method for contact<br>
		<b> pre: </b> <br>
		<b> post: </b> Creates contact<br>
		@param name, the contacts name
		@param lastName, the contacts last name
		@param nationality, the contacts nationality
		@param email, the contacts email
		@param phone, the contacts phone
		@param app, PApplet processing core
	 */
	public Contact(String name, String lastName, String nationality, String email, String phone, PApplet app) {
		super(name, lastName, nationality, email, phone, app);
		font=null;
	}

	/** 
	 * 
	 * Method for comparing contacts by name<br>
		<b> pre: </b> <br>
		<b> post: </b> Compares contacts<br>
		@param c1, contact to compare to
		@return int, representing the result of the comparison, negative , positive or 0
	 */
	@Override
	public int compareTo(Contact c1) {
		return getName().compareTo(c1.getName());
	}


	
	/** 
	 * 
	 * Method for drawing contact<br>
		<b> pre: </b> <br>
		<b> post: </b> Contact is drawn<br>
		@param y, the initial Y axis position of it being drawn
	 */
	@Override
	public void draw(int posy) {
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

	
	/**
	 * Setter
	 */
	public void setFont(PFont font) {
		this.font = font;
	}
}
