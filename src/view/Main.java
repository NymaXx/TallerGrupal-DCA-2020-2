package view;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

/**
 * Main class 

 * @author: Juan Pablo Sanin

 * @version: 1.4 11/7/2020

 */

public class Main extends PApplet {
	private int screen;
	private LoginView lv;
	private RegisterView rv;
	private HomeView hv;
	private MarsView mv;
	private MoonView mnv;
	private EarthView ev;
	private PayView pv;
	private ContactView cv;
	private ContactRegisterView crv;
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	
	//Buttons
	PImage addBut, addButUI;//First white anf then red
	PImage addNewN, addNewNUI;//First black anf then red
	PImage loginBut, loginButUI;
	PImage payBut, payButUI;
	PImage registerB,registerBUI;
	
	//Feedback
	PImage addedSucces;//When the new contact has been added
	PImage paySucces;//at the end of the purchase payment
	PImage feed;// alert message
	PImage loginFeed; // alert message LOGIN
	
	PImage cardE,cardMars, cardMoon;//home's cards
	
	//--------------------------------------------------------------
	
	//Screens
	PImage buyE, buyMars, buyMoon;
	PImage home;
	PImage login;
	PImage register;
	PImage navegation;//Barra de navegación
	PImage newContact;
	PImage payForm, pay;
	

	
	public void settings() {
		size(1280, 720);
		
	}
	
	public void setup() {
		screen=1;
		lv= new LoginView(this);
		rv= new RegisterView(this);
		hv= new HomeView(this);
		mv= new MarsView(this);
		mnv=new MoonView(this);
		ev= new EarthView(this);
		pv=new PayView(this);
		cv= new ContactView(this);
		crv= new ContactRegisterView(this);
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
		feed = loadImage("../image/interactive/Feedback.png");
		loginFeed = loadImage("../image/interactive/loginAlertMessage.png");
		
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
		navegation = loadImage("../image/screens/navigationBar.png");
		newContact = loadImage("../image/screens/newContactScreen.png");
		payForm = loadImage("../image/screens/paymentForm.png");
		pay = loadImage("../image/screens/payScreen.png");
	}
	
	public void draw() {
		background(0);

		switch(screen) {
		case 1:
			lv.drawScreen();
			break;
		case 2:
			rv.drawScreen();
			break;
		case 3:
			hv.drawScreen();
			break;
		case 4:
			mv.drawScreen();
			break;
		case 5:
			mnv.drawScreen();
			break;
		case 6:
			ev.drawScreen();
			break;
		case 7:
			pv.drawScreen();
			break;
		case 8:
			cv.drawScreen();
			break;
		case 9:
			crv.drawScreen();
			break;
		}
		fill(255,255);
		text(mouseX+","+mouseY, mouseX, mouseY);
		
	}
	
	
	public void mousePressed() {
		switch(screen) {
		case 1:
			screen=lv.changeScreen();
			break;
		case 2:
			screen=rv.changeScreen();
			break;
		case 3:
			screen=hv.changeScreen();
			break;
		case 4:
			screen=mv.changeScreen();
			break;
		case 5:
			screen=mnv.changeScreen();
			break;
		case 6:
			screen=ev.changeScreen();
			break;
		case 7:
			screen=pv.changeScreen();
			break;
		case 8:
			screen=cv.changeScreen();
			break;
		case 9:
			screen=crv.changeScreen();
			break;
		}
	}
	
	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();
		switch(screen) {
		case 3:
			hv.scroll(e);
			break;
		}

		
	}
	
}
