package view;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Main class 

 * @author: Hillary Panesso y Estiven Reyes(version 2.0)

 * @version: 3.0 11/7/2020

 */

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	
	//Buttons
	PImage addBut, addButUI;//First white anf then red
	PImage addNewN, addNewNUI;//First black anf then red
	PImage loginBut, loginButUI;
	PImage payBut, payButUI;
	PImage registerB, registerBUI;
	
	//Feedback
	PImage addedSucces;//When the new contact has been added
	PImage paySucces;//at the end of the purchase payment
	
	
	PImage cardE,cardMars, cardMoon;//home's cards
	
	//--------------------------------------------------------------
	
	//Screens
	PImage buyE, buyMars, buyMoon;
	PImage home;
	PImage login, register;
	PImage navegation;//Barra de navegación
	PImage newContact;
	PImage payForm, pay;
	

	
	public void settings() {
		size(1280, 720);
		
	}
	
	public void setup() {
		
		//Initialize buttons
		addBut = loadImage("../image/interactive/addButton.png");
		addButUI = loadImage("../image/interactive/addButtonUI.png");
		addNewN = loadImage("../image/interactive/addNewNumber.png");
		addNewNUI = loadImage("../image/interactive/addNewNumberUI.png");
		loginBut = loadImage("../image/interactive/loginButton.png");
		loginButUI = loadImage("../image/interactive/loginButtonUI.png");
		payBut = loadImage("../image/interactive/payButton.png");
		payButUI = loadImage("../image/interactive/payButtonUI.png");
		registerB = loadImage("../image/interactive/registerButton.png");
		registerBUI = loadImage("../image/interactive/registerButtonUI.png");
		
		//Initialize Feedback
		addedSucces = loadImage("../image/interactive/addedSuccessfully.png");
		paySucces = loadImage("../image/interactive/paySuccessfull.png");
		
		
		cardE = loadImage("../image/interactive/cardEarth.png");
		cardMars = loadImage("../image/interactive/cardMars.png");
		cardMoon = loadImage("../image/interactive/cardMoon.png");
		
		//Initialize screens
		buyE = loadImage("../image/screens/buyEarthScreen.png");
		buyMars = loadImage("../image/screens/buyMarsScreen.png");
		buyMoon = loadImage("../image/screens/buyMoonScreen.png");
		home = loadImage("../image/screens/homeScreen.png");
		login = loadImage("../image/screens/loginScreen.png");
		register = loadImage("../image/screens/registerScreen.png");
		navegation = loadImage("../image/screens/navegationBarScreen.png");
		newContact = loadImage("../image/screens/newContactScreen.png");
		payForm = loadImage("../image/screens/paymentForm.png");
		pay = loadImage("../image/screens/payScreen.png");
	}
	
	public void draw() {
		background(0);
		
	}
	
}
