package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Moon view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
public class PayView {
	private Controller controller;
	private PImage payScreen;
	private PImage payButtonUI, paySuccess;
	private boolean purchased;
	private PApplet app;
	

	public PayView(PApplet app) {
		controller= new Controller();
		this.app = app;
		payScreen = app.loadImage("../image/screens/payScreen.png");
		paySuccess = app.loadImage("../image/interactive/paySuccessfull.png");
		payButtonUI= app.loadImage("../image/interactive/payButtonUI.png");
		purchased=false;
	}
	
	public void drawScreen() {
		
		
		if(purchased==true) {
			app.image(payScreen, -4, 0);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			app.image(paySuccess,394, 182);
		}else {
			app.image(payScreen, -4, 0);
			if(app.mouseX>886 && app.mouseX<1236 &&app.mouseY>578 && app.mouseY<632) {
				app.image(payButtonUI, 886, 578);
			}
			
		}
		
		
	}
	
	public int changeScreen() {
		int screen=7;
		if(purchased==true) {
			if(app.mouseX>540 && app.mouseX<738 &&app.mouseY>520 && app.mouseY<567) {
				screen=3;
				purchased=false;
			}
		}else {
			if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
				screen=3;
			}
			if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
				screen=8;
			}
			if(app.mouseX>886 && app.mouseX<1236 &&app.mouseY>578 && app.mouseY<632) {
				purchased=true;
			}
		}
		return screen;
	}
}
