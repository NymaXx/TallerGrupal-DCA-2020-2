package model;


/**
 * Class for representing a trip in the program

 * @author: Juan P. Sanin

 * @version: 1.0 11/7/2020

 */
public class Trip {

	private double price;
	private String duration;
	
	
	public Trip(double price, String duration) {
		this.price = price;
		this.duration = duration;
	}

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

}
