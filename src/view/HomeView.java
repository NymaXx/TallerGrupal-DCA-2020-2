package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Home view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
	

public class HomeView {

	private Controller controller;
	private PImage homeScreen, flightNavBar;
	private int homeY,cardsY;
	private PApplet app;
	
	public HomeView(PApplet app) {
		controller= new Controller();
		this.app = app;
		homeScreen = app.loadImage("../image/template/HOME.png");
		flightNavBar=app.loadImage("../image/interactive/flightNavBar.png");
		homeY=0;
		cardsY=800;
		
		
	}
	
	public void drawScreen() {
		app.image(homeScreen, -4,homeY);
		app.image(flightNavBar, -4, 0);
		
	}
	
	public int changeScreen() {
		int screen=3;
		if(app.mouseX>185 && app.mouseX<442 &&app.mouseY>cardsY && app.mouseY<cardsY+259) {
			screen=4;
		}
		
		if(app.mouseX>511 && app.mouseX<768 &&app.mouseY>cardsY && app.mouseY<cardsY+259) {
			screen=5;
		}
		
		if(app.mouseX>837 && app.mouseX<1094 &&app.mouseY>cardsY && app.mouseY<cardsY+259) {
			screen=6;
		}
		
		if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
			screen=8;
		}
		if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
			screen=9;
		}
		return screen;
	}

	public void scroll(float e) {
		if(e>0) {
			if(homeY>-646) {
				homeY-=25;
				cardsY-=25;
			}
			
		}
		if(e<0) {
			if(homeY<0) {
				homeY+=25;
				cardsY+=25;
			}
			
		}
		
	}
	
	
	
}
