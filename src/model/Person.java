package model;

import processing.core.PApplet;

/**
 * Abstract class for representing a person in the program

 * @author: Juan P. Sanin

 * @version: 1.0 11/7/2020

 */

public abstract class Person {

	private String name;
	private String lastName;
	private String nationality;
	private String email;
	private Long phone;
	private PApplet app;
	
	//Constructor
	public Person(String name, String lastName, String nationality, String email, Long phone, PApplet app) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.nationality = nationality;
		this.email = email;
		this.phone = phone;
		this.app = app;
	}
	
	public abstract void draw();
	
	//Getters and Setters
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public PApplet getApp() {
		return app;
	}
	public void setApp(PApplet app) {
		this.app = app;
	}
			
}
