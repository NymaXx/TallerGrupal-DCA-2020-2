package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Login view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
public class LoginView {
	
	private Controller controller;
	private PImage loginScreen;
	private PImage loginBut, loginButUI, navigation;
	
	private PApplet app;

	public LoginView(PApplet app) {
		controller= new Controller();
		this.app = app;
		loginScreen = app.loadImage("../image/screens/LoginScreen.png");
		navigation = app.loadImage("../image/screens/navigationBar.png");
		loginBut = app.loadImage("../image/interactive/loginButton.png");
		loginButUI = app.loadImage("../image/interactive/loginButtonUI.png");
		
	}
	
	
	public void drawScreen() {
		app.image(loginScreen, 0,61,1280,659);
		app.image(navigation, -4, 0);
		if(app.mouseX>544 && app.mouseX<742 &&app.mouseY>451 && app.mouseY<497) {
			app.image(loginButUI, 544, 451);
		}else {
			app.image(loginBut, 544, 451);
		}
		
	}


	public int changeScreen() {
		int screen=1;
		if(app.mouseX>544 && app.mouseX<742 &&app.mouseY>451 && app.mouseY<497) {
			screen=3;
		}
		if(app.mouseX>723 && app.mouseX<746 &&app.mouseY>535 && app.mouseY<545) {
			screen=2;
		}
		return screen;
	}

	
	

	
	
	

}