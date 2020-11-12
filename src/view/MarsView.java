package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Mars view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
	
public class MarsView {
	private Controller controller;
	private PImage marsScreen;
	private PImage buyButton,buyButtonUI;
	private PApplet app;
	
	public MarsView(PApplet app) {
		controller= new Controller();
		this.app = app;
		marsScreen = app.loadImage("../image/screens/buyMarsScreen.png");
		buyButton= app.loadImage("../image/interactive/buyButton.png");
		buyButtonUI= app.loadImage("../image/interactive/buyButtonUI.png");
	}
	
	public void drawScreen() {
		app.image(marsScreen, 0, 0);
		
	
		if(app.mouseX>1019 && app.mouseX<1210 &&app.mouseY>622 && app.mouseY<684) {
			app.image(buyButtonUI, 1019, 622);
		}else {
			app.image(buyButton, 1019, 622);
		}
		
	}
	
	public int changeScreen() {
		int screen=4;
		
		if(app.mouseX>1019 && app.mouseX<1210 &&app.mouseY>622 && app.mouseY<684){
			screen=7;
		}
	
		
		return screen;
	}
	
}
