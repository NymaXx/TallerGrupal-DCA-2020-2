package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Moon view class Final Version

 * @author: Juan P. Sanin

 * @version: 1.1 11/16/2020

 */
public class MoonView {
	private Controller controller;
	private PImage moonScreen;
	private PImage buyButton,buyButtonUI, navigation;
	private PApplet app;
	
	/** 
	 * 
	 *	Constructor method for Moon View <br>
		<b> pre: </b> <br>
		<b> post: </b> Creates the visualization of the moon trip screen<br>
	 * @param app, PApplet processing core
	 */
	public MoonView(PApplet app) {
		controller= new Controller();
		this.app = app;
		moonScreen = app.loadImage("../image/screens/buyMoonScreen.png");
		navigation = app.loadImage("../image/interactive/navBar.png");
		buyButton= app.loadImage("../image/interactive/buyButton.png");
		buyButtonUI= app.loadImage("../image/interactive/buyButtonUI.png");
	}
	
	/** 
	 * 
	 *	Method for drawing the moon trip Screen<br>
		<b> pre: </b> <br>
		<b> post: </b>Draws the moon trip screen<br>
	 */
	public void drawScreen() {
		app.image(moonScreen, 0, 0);
		app.image(navigation, -4, 0);
	
		if(app.mouseX>1019 && app.mouseX<1210 &&app.mouseY>622 && app.mouseY<684) {
			app.image(buyButtonUI, 1019, 622);
		}else {
			app.image(buyButton, 1019, 622);
		}
		
	}
	
	
	/**
	 *	Method for changing screens<br>
		<b> pre: </b> <br>
		<b> post: </b>Changes screens depending on the click<br>
		@return screen, the screen where the program should go
	 */
	public int changeScreen() {
		int screen=5;
		if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
			screen=3;
		}
		if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
			screen=8;
		}
		if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
			screen=9;
		}
		if(app.mouseX>1019 && app.mouseX<1210 &&app.mouseY>622 && app.mouseY<684){
			controller.setTripType(2);
			screen=7;
			
		}
		return screen;
	}
}
