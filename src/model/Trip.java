package model;

import processing.core.PApplet;

/**
 * Abstract class for representing a trip in the program

 * @author: Juan P. Sanin

 * @version: 1.0 11/7/2020

 */
public abstract class Trip {

	private double price;
	private String duration;
	private PApplet app;
	
	
	public Trip(double price, String duration, PApplet app) {
		this.price = price;
		this.duration = duration;
		this.app = app;
	}

	public abstract void draw();
	
	
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}

	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}
	
	
	
	
	
}
