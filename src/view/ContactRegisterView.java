package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Contact Register view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
public class ContactRegisterView {
	private Controller controller;
	private PImage registerContactScreen;
	private PImage addContactButton, addContactButtonUI, navBar,added;
	private boolean contactAdded;
	private PApplet app;

	public ContactRegisterView(PApplet app) {
		controller=new Controller();
		this.app = app;
		registerContactScreen = app.loadImage("../image/screens/newContactScreen.png");
		navBar = app.loadImage("../image/interactive/addContactNavBar.png");
		addContactButton= app.loadImage("../image/interactive/addContactButton.png");
		addContactButtonUI= app.loadImage("../image/interactive/addContactButtonUI.png");
		added= app.loadImage("../image/interactive/addedSuccessfully.png");
		contactAdded=false;
	}

	public void drawScreen() {
		if(contactAdded==true) {
			app.image(registerContactScreen, 0,72);
			app.image(navBar, -4, 0);
			app.image(addContactButton, 541, 591);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			app.image(added,130, 274);
		}else {
			app.image(registerContactScreen, 0,72);
			app.image(navBar, -4, 0);
			if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
				app.image(addContactButtonUI, 541, 591);
			}else {
				app.image(addContactButton, 541, 591);
			}
		}

	}

	public int changeScreen() {
		int screen=9;
		if(contactAdded==true) {
			if(app.mouseX>560 && app.mouseX<758 &&app.mouseY>420 && app.mouseY<467) {
				screen=8;
				contactAdded=false;
			}
		}else {
			if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
				screen=3;
			}
			if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
				screen=8;
			}

			if(app.mouseX>541 && app.mouseX<739 &&app.mouseY>591 && app.mouseY<638) {
				contactAdded=true;
			}
		}


		return screen;
	}



}
