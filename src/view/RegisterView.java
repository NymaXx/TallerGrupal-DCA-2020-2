package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Register view class 

 * @author: Juan P. Sanin

 * @version: 1.1 11/14/2020

 */
	

public class RegisterView {
	private Controller controller;
	private PImage registerScreen;
	private PImage registerB, registerBUI, navigation;
	private PImage errorMessage;
	private PImage fillFields;
	private PImage passwordError;
	
	//box
	private PImage nameB;
	private PImage lastB;
	private PImage natiB;
	private PImage emailB;
	private PImage cellB;
	private PImage passB;
	private PImage confirB;
		
	private PFont font;
	
	private boolean error;
	private boolean registerError;
	private boolean passwordMatchError;
	private PApplet app;
	private String name;
	private String lastName;
	private String nationality;
	private String email;
	private String phone;
	private String password;
	private String confirmPassword;
	private String[] inputs;
	private ControlP5 cp5;
	

	public RegisterView(PApplet app) {
		controller=new Controller();
		this.app = app;
		registerScreen = app.loadImage("../image/screens/registerScreen.png");
		navigation = app.loadImage("../image/interactive/navBar.png");
		registerB = app.loadImage("../image/interactive/registerButton.png");
		registerBUI = app.loadImage("../image/interactive/registerButtonUI.png");
		errorMessage = app.loadImage("../image/interactive/registerError.png");
		fillFields = app.loadImage("../image/interactive/fillFields.png");
		passwordError= app.loadImage("../image/interactive/passwordMatch.png");
		font = app.createFont("../font/Heebo-Regular.ttf", 16);
		//BOX
		nameB = app.loadImage("../image/box/nameRect.png");
		lastB = app.loadImage("../image/box/lastRect.png");
		natiB = app.loadImage("../image/box/natiRect.png");
		emailB = app.loadImage("../image/box/emailRect.png");
		cellB = app.loadImage("../image/box/cellRect.png");
		passB = app.loadImage("../image/box/passwordRect.png");
		confirB = app.loadImage("../image/box/confirRect.png");
		
		error=false;
		registerError=false;
		passwordMatchError=false;
		
		cp5 = new ControlP5(app);
		inputs = new String[7];
		initializeTextFields();

	}
	
	

	private void initializeTextFields() {
		inputs[0] = "Name";
		inputs[1] = "Last Name";
		inputs[2] = "E-mail";
		inputs[3] = "Nationality";
		inputs[4] = "Phone Number";
		inputs[5] = "Password";
		inputs[6] = "Confirm Password";
		
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
		
		cp5.addTextfield(inputs[5]).setPosition(205,478).setSize(406, 51).setPasswordMode(true).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
		
		cp5.addTextfield(inputs[6]).setPosition(670,478).setSize(406, 51).setPasswordMode(true).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).setFont(font).getCaptionLabel().hide();
	}
	
	public void drawScreen() {
		
		if(error==true || registerError==true || passwordMatchError==true) {
			app.image(registerScreen, 0,72,1280,648);
			app.tint(255, 126); 
			app.image(nameB, 202,252);
			app.image(lastB, 667,251);
			app.image(emailB, 202,329);
			app.image(natiB, 667,329);
			app.image(cellB, 202,405);
			app.image(passB, 202,478);
			app.image(confirB, 667,478);
			app.tint(255, 255); 
			app.image(navigation, -4, 0);
			app.image(registerB, 541, 591);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			if(error==true) {
				app.image(errorMessage,179, 273);
			}
			if(registerError==true) {
				app.image(fillFields,124,218);
			}
			if(passwordMatchError==true) {
				app.image(passwordError,124,218);
			}
		}else {
			
			app.image(registerScreen, 0,72,1280,648);
			app.tint(255, 126); 
			app.image(nameB, 202,252);
			app.image(lastB, 667,251);
			app.image(emailB, 202,329);
			app.image(natiB, 667,329);
			app.image(cellB, 202,405);
			app.image(passB, 202,478);
			app.image(confirB, 667,478);
			app.tint(255, 255); 
			app.image(navigation, -4, 0);
			if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
				app.image(registerBUI, 541, 591);
			}else {
				app.image(registerB, 541, 591);
			}	
		}
		
		
	}
	
	


	public int changeScreen() {
		int screen=2;
		if(error==false && registerError==false && passwordMatchError==false) {
			if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
				boolean success=registerUser();
				if(success==true) {
					screen=1;
				}
				
			}
			if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
				error=true;
			}
			if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
				error=true;
			}
			if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
				error=true;
			}
			if(app.mouseX>1112 && app.mouseX<1225 &&app.mouseY>28 && app.mouseY<43) {
				error=true;
			}
		}else {
			if(app.mouseX>550 && app.mouseX<750 &&app.mouseY>360 && app.mouseY<410) {
				error=false;
				registerError=false;
				passwordMatchError=false;
			}
		}
		
		return screen;
	}
	
	private boolean registerUser() {
		boolean success=false;
		name=cp5.get(Textfield.class, "Name").getText();
		lastName=cp5.get(Textfield.class, "Last Name").getText();
		email=cp5.get(Textfield.class, "E-mail").getText();
		nationality=cp5.get(Textfield.class, "Nationality").getText();
		phone=cp5.get(Textfield.class, "Phone Number").getText();
		password=cp5.get(Textfield.class, "Password").getText();
		confirmPassword=cp5.get(Textfield.class, "Confirm Password").getText();
		
		boolean notemptyName = !name.equals("");
		boolean notemptyLastName = !lastName.equals("");
		boolean notemptyEmail = !email.equals("");
		boolean notemptyNationality = !nationality.equals("");
		boolean notemptyPhone = !phone.equals("");
		boolean notemptyPassword = !password.equals("");
		
		if(!notemptyName || !notemptyLastName || !notemptyEmail ||
				!notemptyNationality||!notemptyPhone ||!notemptyPassword) {
			registerError=true;
		}else {
			if(password.equals(confirmPassword)) {
				controller.getUserInfo(name,lastName,nationality,email,phone,password, app);
				success=true;
			}else {
				passwordMatchError=true;
				cp5.get(Textfield.class, "Password").setText("");
				cp5.get(Textfield.class, "Confirm Password").setText("");
			}
		}
		if(success==true) {
			cp5.get(Textfield.class, "Name").setText("");
			cp5.get(Textfield.class, "Last Name").setText("");
			cp5.get(Textfield.class, "E-mail").setText("");
			cp5.get(Textfield.class, "Nationality").setText("");
			cp5.get(Textfield.class, "Phone Number").setText("");
			cp5.get(Textfield.class, "Password").setText("");
			cp5.get(Textfield.class, "Confirm Password").setText("");
		}
		return success;
	}
	
	public void hide() {
		cp5.hide();
	}

	public ControlP5 getCp5() {
		return cp5;
	}
	public boolean isError() {
		return error;
	}
	public boolean isRegisterError() {
		return registerError;
	}
	public boolean isPasswordMatchError() {
		return passwordMatchError;
	}
	public void clearTextFields() {
		cp5.get(Textfield.class, "Name").setText("");
		cp5.get(Textfield.class, "Last Name").setText("");
		cp5.get(Textfield.class, "E-mail").setText("");
		cp5.get(Textfield.class, "Nationality").setText("");
		cp5.get(Textfield.class, "Phone Number").setText("");
		cp5.get(Textfield.class, "Password").setText("");
		cp5.get(Textfield.class, "Confirm Password").setText("");
	}

}
