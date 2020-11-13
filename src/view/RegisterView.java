package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Register view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
	

public class RegisterView {
	private Controller controller;
	private PImage registerScreen;
	private PImage registerB, registerBUI, navigation;
	private PImage errorMessage;
	private boolean error;
	private PApplet app;

	public RegisterView(PApplet app) {
		controller=new Controller();
		this.app = app;
		registerScreen = app.loadImage("../image/screens/registerScreen.png");
		navigation = app.loadImage("../image/interactive/navBar.png");
		registerB = app.loadImage("../image/interactive/registerButton.png");
		registerBUI = app.loadImage("../image/interactive/registerButtonUI.png");
		errorMessage = app.loadImage("../image/interactive/registerError.png");
		error=false;
	}
	
	public void drawScreen() {
		
		if(error==true) {
			app.image(registerScreen, 0,72,1280,648);
			app.image(navigation, -4, 0);
			app.image(registerB, 541, 591);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			app.image(errorMessage,179, 273);
		}else {
			app.image(registerScreen, 0,72,1280,648);
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
		if(error==false) {
			if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
				screen=1;
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
			}
		}
		
		return screen;
	}

}
