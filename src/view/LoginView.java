package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Login view class 

 * @author: Juan P. Sanin

 * @version: 1.1 11/14/2020

 */
public class LoginView {

	private Controller controller;
	private PImage loginScreen;
	private PImage loginBut, loginButUI, navigation;
	private PImage errorMessage;
	private PImage cannotLogin;
	
	private PImage namebox, passwbox;
	private boolean cannotLoginError;
	private boolean error;

	private String email;
	private String password;
	private boolean box;
	
	private String[] inputs;
	private ControlP5 cp5;

	private PApplet app;
	

	public LoginView(PApplet app) {
		controller= new Controller();
		this.app = app;
		controller.initialUser(app);
		loginScreen = app.loadImage("../image/screens/loginScreen.png");
		navigation = app.loadImage("../image/interactive/navBar.png");
		loginBut = app.loadImage("../image/interactive/loginButton.png");
		loginButUI = app.loadImage("../image/interactive/loginButtonUI.png");
		errorMessage = app.loadImage("../image/interactive/loginAlertMessage.png");
		cannotLogin = app.loadImage("../image/interactive/cannotLogin.png");
		
		namebox = app.loadImage("../image/box/logEmailRect.png");
		passwbox = app.loadImage("../image/box/logPassRect.png");
		box= false;
		
		error=false;
		cannotLoginError=false;
		cp5 = new ControlP5(app);
		inputs = new String[2];
		cp5.show();
		initializeTextFields();

	}

	private void initializeTextFields() {
		inputs[0] = "Email";
		inputs[1] = "Password";

		cp5.addTextfield(inputs[0]).setPosition(419,275).setSize(447, 56).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).getCaptionLabel().hide();
		
		cp5.addTextfield(inputs[1]).setPosition(419,363).setSize(447, 56).setPasswordMode(true).setAutoClear(true).setColorValue(app.color(255))
		.setColorActive(app.color(0,0,0,1)).setColorBackground(app.color(0,0,0,1)).setColorForeground(app.color(0,0,0,1))
		.setColor(app.color(0,0,0,255)).setColorCursor(app.color(0,0,0,255)).getCaptionLabel().hide();;

	}


	public void drawScreen() {
		if(error==true || cannotLoginError==true) {
			app.image(loginScreen, 0,0);
			app.image(navigation, -4, 0);
			app.image(loginBut, 544, 451);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			if(error==true) {
				app.image(errorMessage,179, 273);
			}
			if(cannotLoginError==true) {
				app.image(cannotLogin,179, 273);
			}


		}else {
			app.image(loginScreen, 0,0);
			app.image(navigation, -4, 0);
			if(app.mouseX>544 && app.mouseX<742 &&app.mouseY>451 && app.mouseY<497) {
				app.image(loginButUI, 544, 451);
			}else {
				app.image(loginBut, 544, 451);
			}
		}


	}


	public int changeScreen() {
		int screen=1;
		if(error==false && cannotLoginError==false) {
			if(app.mouseX>544 && app.mouseX<742 &&app.mouseY>451 && app.mouseY<497) {
				boolean success=login();
				if(success) {
					screen=3;
				}

			}
			if(app.mouseX>723 && app.mouseX<746 &&app.mouseY>535 && app.mouseY<545) {
				screen=2;
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
				cannotLoginError=false;
			}
		}
		return screen;
	}


	private boolean login() {
		boolean success=false;
		email=cp5.get(Textfield.class, "Email").getText();
		password=cp5.get(Textfield.class, "Password").getText();
		int[] info= controller.searchUser(email);
		if(info[0]==1) {
			success=controller.login(info[1], password);
		}
		if(info[0]==0) {
			cannotLoginError=true;
		}
		if(success==false) {
			cannotLoginError=true;
		}
		cp5.get(Textfield.class, "Email").setText("");
		cp5.get(Textfield.class, "Password").setText("");
		return success;

	}
	
	public void hide() {
		cp5.hide();
	}

	public boolean isCannotLoginError() {
		return cannotLoginError;
	}

	public boolean isError() {
		return error;
	}

	public ControlP5 getCp5() {
		return cp5;
	}

}
