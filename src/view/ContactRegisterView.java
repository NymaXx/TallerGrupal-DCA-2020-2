package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
/**
 * Contact Register view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/16/2020

 */
public class ContactRegisterView {
	private Controller controller;
	private PImage registerContactScreen;
	private PImage errorMessageC;
	private PImage addContactButton, addContactButtonUI, navBar,added;
	private PImage nameB;
	private PImage lastB;
	private PImage natiB;
	private PImage emailB;
	private PImage cellB;
	private PFont font;
	
	private boolean contactAdded;
	private PApplet app;
	
	private String name;
	private String lastName;
	private String nationality;
	private String email;
	private String phone;
	
	private String[] inputs;
	private ControlP5 cp5;
	private boolean error;


	public ContactRegisterView(PApplet app) {
		controller=new Controller();
		this.app = app;
		registerContactScreen = app.loadImage("../image/screens/newContactScreenn.png");
		errorMessageC = app.loadImage("../image/interactive/registerContactErrorM.png");
		navBar = app.loadImage("../image/interactive/addContactNavBar.png");
		addContactButton= app.loadImage("../image/interactive/addContactButton.png");
		addContactButtonUI= app.loadImage("../image/interactive/addContactButtonUI.png");
		added= app.loadImage("../image/interactive/addedSuccessfully.png");
		nameB = app.loadImage("../image/box/nameRect.png");
		lastB = app.loadImage("../image/box/lastRect.png");
		natiB = app.loadImage("../image/box/natiRect.png");
		emailB = app.loadImage("../image/box/emailRect.png");
		cellB = app.loadImage("../image/box/cellRect.png");
		
		font = app.createFont("../font/Heebo-Regular.ttf", 16);
		
		contactAdded=false;
		error=false;
		
		cp5 = new ControlP5(app);
		inputs = new String[5];
		initializeTextFields();
	}
	
	//add new contact Screen-------------------
			private void initializeTextFields() {
				inputs[0] = "Name";
				inputs[1] = "Last Name";
				inputs[2] = "E-mail";
				inputs[3] = "Nationality";
				inputs[4] = "Phone Number";

				
				cp5.addTextfield(inputs[0]).setPosition(205,252).setSize(406, 51).setAutoClear(true).setColorValue(app.color(255))
				.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
				.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
				
				cp5.addTextfield(inputs[1]).setPosition(670,251).setSize(406, 51).setAutoClear(true).setColorValue(app.color(255))
				.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
				.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
				
				cp5.addTextfield(inputs[2]).setPosition(205,329).setSize(406, 51).setAutoClear(true).setColorValue(app.color(255))
				.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
				.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
				
				cp5.addTextfield(inputs[3]).setPosition(670,329).setSize(406, 51).setAutoClear(true).setColorValue(app.color(255))
				.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
				.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
				
				cp5.addTextfield(inputs[4]).setPosition(205,405).setSize(406, 51).setAutoClear(true).setColorValue(app.color(255))
				.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
				.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
				
			}
			
	public void drawScreen() {
		if(error==true||contactAdded==true) {
			app.image(registerContactScreen, 0,72);
			app.tint(255, 126); 
			app.image(nameB, 202,252);
			app.image(lastB, 667,251);
			app.image(emailB, 202,329);
			app.image(natiB, 667,329);
			app.image(cellB, 202,405);
			app.tint(255, 255); 
			app.image(navBar, -4, 0);
			app.image(addContactButton, 541, 591);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			
			
			if(contactAdded==true){
				app.image(added,130, 218);
			}
			
			if(error==true) {
				app.image(errorMessageC,179, 273);
			}
		}else {
			app.image(registerContactScreen, 0,72);
			app.tint(255, 126); 
			app.image(nameB, 202,252);
			app.image(lastB, 667,251);
			app.image(emailB, 202,329);
			app.image(natiB, 667,329);
			app.image(cellB, 202,405);
			app.tint(255, 255); 
			app.image(navBar, -4, 0);
			
			if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
				app.image(addContactButtonUI, 541, 591);
			}else {
				app.image(addContactButton, 541, 591);
			}
		}

	}
	
		
		private boolean contactRegister() {
			boolean success=false;
			name=cp5.get(Textfield.class, "Name").getText();
			lastName=cp5.get(Textfield.class, "Last Name").getText();
			email=cp5.get(Textfield.class, "E-mail").getText();
			nationality=cp5.get(Textfield.class, "Nationality").getText();
			phone=cp5.get(Textfield.class, "Phone Number").getText();
			
			
			boolean notemptyName = !name.equals("");
			boolean notemptyLastName = !lastName.equals("");
			boolean notemptyEmail = !email.equals("");
			boolean notemptyNationality = !nationality.equals("");
			boolean notemptyPhone = !phone.equals("");
			
			
			if(!notemptyName || !notemptyLastName || !notemptyEmail ||
					!notemptyNationality||!notemptyPhone) {
				error=true;
				System.out.println("si");
			}else {
				controller.getContactInfo(name,lastName,nationality,email,phone, app);
				success=true;
				contactAdded=true;
			}
				
			if(success==true) {
				cp5.get(Textfield.class, "Name").setText("");
				cp5.get(Textfield.class, "Last Name").setText("");
				cp5.get(Textfield.class, "E-mail").setText("");
				cp5.get(Textfield.class, "Nationality").setText("");
				cp5.get(Textfield.class, "Phone Number").setText("");
				
			}
			return success;
		}
		//-----------------------

	
	public int changeScreen() {
		int screen=9;
		if(contactAdded==true || error==true) {
			if(app.mouseX>555 && app.mouseX<753 &&app.mouseY>363 && app.mouseY<410) {
				if(contactAdded==true) {
					screen=8;
					contactAdded=false;
				}
				if(error==true) {
					error=false;
				}
				
			}
		}else {
			if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
				screen=3;
			}
			if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
				screen=8;
			}

			if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
				boolean success= contactRegister();
				if(success==true) {
					contactAdded=true;
				}
				
			}
		}


		return screen;
	}
	
	public ControlP5 getCp5() {
		return cp5;
	}

	public boolean isError() {
		
		return error;
	}

	public boolean isContactAdded() {
		return contactAdded;
	}

}
