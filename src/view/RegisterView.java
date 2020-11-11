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
	private PApplet app;

	public RegisterView(PApplet app) {
		controller=new Controller();
		this.app = app;
		registerScreen = app.loadImage("../image/screens/registerScreen.png");
		navigation = app.loadImage("../image/screens/navigationBar.png");
		registerB = app.loadImage("../image/interactive/registerButton.png");
		registerBUI = app.loadImage("../image/interactive/registerButtonUI.png");
		
	}
	
	public void drawScreen() {
		app.image(registerScreen, 0,72,1280,648);
		app.image(navigation, -4, 0);
		if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
			app.image(registerBUI, 541, 591);
		}else {
			app.image(registerB, 541, 591);
		}
		
	}
	
	public int changeScreen() {
		int screen=2;
		if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
			screen=1;
		}
		
		return screen;
	}

}
