package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;
/**
 * Pay view class Final Version

 * @author: Juan P. Sanin

 * @version: 1.4 11/16/2020

 */
public class PayView {
	private Controller controller;
	private PImage payScreen, navBar;
	private PImage payButtonUI, paySuccess, payError;
	private boolean purchased;
	private PApplet app;
	private String cardNumber;
	private String MMDD;
	private String CVV;
	private String installments;
	private String[] inputs;
	private PFont font;
	private ControlP5 cp5;
	private int passanger = 1;
	private double price;
	private boolean paymentError;
	
	/** 
	 * 
	 *	Constructor method for PayView <br>
		<b> pre: </b> <br>
		<b> post: </b> Creates the visualization of the paying screen<br>
	 * @param app, PApplet processing core
	 */
	public PayView(PApplet app) {
		controller= new Controller();
		this.app = app;
		
		payScreen = app.loadImage("../image/screens/payScreen.png");
		navBar= app.loadImage("../image/interactive/navBar.png");
		paySuccess = app.loadImage("../image/interactive/paySuccessfull.png");
		payButtonUI= app.loadImage("../image/interactive/payButtonUI.png");
		payError= app.loadImage("../image/interactive/paymentError.png");
		font = app.createFont("../font/Heebo-Regular.ttf", 16);
		purchased=false;
		paymentError=false;
		price=0;
		cp5 = new ControlP5(app);
		inputs = new String[7];
		initializeTextFields();
	}
	
	
	/** 
	 * 
	 *	Method for initializing textFields<br>
		<b> pre: </b> <br>
		<b> post: </b>initializes textFields with position, size, color and font<br>
	 */
	private void initializeTextFields() {
		inputs[0] = "Card Number";
		inputs[1] = "MM/DD";
		inputs[2] = "CVV";
		inputs[3] = "Installments";
		
		cp5.addTextfield(inputs[0]).setPosition(155,360).setSize(631, 43).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
		
		cp5.addTextfield(inputs[1]).setPosition(155,468).setSize(238, 43).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
		
		cp5.addTextfield(inputs[2]).setPosition(548,468).setSize(238, 43).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
		
		cp5.addTextfield(inputs[3]).setPosition(155,576).setSize(238, 43).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
	}
	
	/** 
	 * 
	 *	Method for drawing the pay Screen<br>
		<b> pre: </b> <br>
		<b> post: </b>Draws the pay screen<br>
	 */
	public void drawScreen() {
		price=controller.getTripPrice();
		if(purchased==true || paymentError==true) {
			app.image(payScreen, -4, 0);
			app.image(navBar, -4, 0);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			if(purchased==true) {
				app.image(paySuccess,394, 182);	
			}
			if(paymentError==true) {
				app.image(payError,179, 273);
			}
			
		}else {
			app.image(payScreen, -4, 0);
			app.image(navBar, -4, 0);
			if(app.mouseX>886 && app.mouseX<1236 &&app.mouseY>578 && app.mouseY<632) {
				app.image(payButtonUI, 886, 578);
			}
			
		}
		
		app.fill(0);
		app.textSize(18);
		app.textAlign(PConstants.LEFT);
		app.text(passanger, 1017, 400);
		app.text("$"+(int)(price), 1000, 350);
		app.text("$"+(int)(price *passanger), 970, 510);
	}
	
	
	/** 
	 * 
	 *	Method for purchasing<br>
		<b> pre: </b> <br>
		<b> post: </b>Purchases the trip or not depending on inputs<br>
		@return success, a boolean representing if a purchase is successful or not
	 */
	private boolean purchase() {
		boolean success=false;
		cardNumber=cp5.get(Textfield.class, "Card Number").getText();
		MMDD=cp5.get(Textfield.class, "MM/DD").getText();
		CVV=cp5.get(Textfield.class, "CVV").getText();
		installments=cp5.get(Textfield.class, "Installments").getText();
	
		
	
		boolean notemptyCardNumber = !cardNumber.equals("");
		boolean notemptyMMDD = !MMDD.equals("");
		boolean notemptyCVV = !CVV.equals("");
		boolean notemptyInstallments = !installments.equals("");
		
		if(!notemptyCardNumber || !notemptyMMDD|| !notemptyCVV ||
				!notemptyInstallments) {
			paymentError=true;
		}else {
			int trip= controller.getAdminSystem().getTripType();
			controller.addTrip(trip);
			success=true;
			}
		if(success==true) {
			cp5.get(Textfield.class, "Card Number").setText("");
			cp5.get(Textfield.class, "MM/DD").setText("");
			cp5.get(Textfield.class, "CVV").setText("");
			cp5.get(Textfield.class, "Installments").setText("");
		}
		
		return success;
	}
	
	
	/** 
	 * 
	 *	Method for changing screens<br>
		<b> pre: </b> <br>
		<b> post: </b>Changes screens depending on the click<br>
		@return screen, the screen where the program should go
	 */
	public int changeScreen() {
		int screen=7;
		if(purchased==true || paymentError==true) {
			if(purchased==true) {
				if(app.mouseX>540 && app.mouseX<738 &&app.mouseY>520 && app.mouseY<567) {
					screen=3;
					purchased=false;
				}	
			}
			if(paymentError==true) {
				if(app.mouseX>550 && app.mouseX<752 &&app.mouseY>360 && app.mouseY<410) {
					paymentError=false;
				}
			}
			
		}else {
			if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
				screen=3;
			}
			if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
				screen=8;
			}
			if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
				screen=9;
			}
			if(app.mouseX>886 && app.mouseX<1236 &&app.mouseY>578 && app.mouseY<632) {
				boolean success=purchase();
				if(success) {
					purchased=true;
				}
				
			}
			
			if(app.mouseX>1045 && app.mouseX<1059 &&app.mouseY>387 && app.mouseY<396) {
				passanger++;
			}
			//Multiplicar el precio por pasageros 
			if(app.mouseX>1060 && app.mouseX<1072 &&app.mouseY>387 && app.mouseY<396) {
				passanger++;
				if(passanger-->=3) {
					passanger--;
				}
			}
		}
		return screen;
	}

	/** 
	 * 
	 *	Method for clearing the text fields<br>
		<b> pre: </b> <br>
		<b> post: </b>Clears text fields<br>
	 */
	public void clearTextFields() {
		cp5.get(Textfield.class, "Card Number").setText("");
		cp5.get(Textfield.class, "MM/DD").setText("");
		cp5.get(Textfield.class, "CVV").setText("");
		cp5.get(Textfield.class, "Installments").setText("");
	}
	
	/** 
	 * Getters
	 */

	public ControlP5 getCp5() {
		return cp5;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public boolean isPaymentError() {
		return paymentError;
	}
	
	
}
