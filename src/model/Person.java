package model;

import processing.core.PApplet;

/**
 * Abstract class for representing a person in the program
 * Final Version

 * @author: Juan P. Sanin

 * @version: 1.1 11/16/2020

 */

public abstract class Person {

	private String name;
	private String lastName;
	private String nationality;
	private String email;
	private String phone;
	private PApplet app;
	
	/**
	 * Constructor Method for person<br>
		<b> pre: </b> <br>
		<b> post: </b> Creates person<br>
		@param name, the persons name
		@param lastName, the persons last name
		@param nationality, the persons nationality
		@param email, the persons email
		@param phone, the persons phone
		@param app, PApplet processing core
	 */
	public Person(String name, String lastName, String nationality, String email, String phone, PApplet app) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
		this.app = app;
	}
	
	public abstract void draw(int y);
	
	/**
	 * Getters and Setters
	 *
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PApplet getApp() {
		return app;
	}
	public void setApp(PApplet app) {
		this.app = app;
	}
			
}
