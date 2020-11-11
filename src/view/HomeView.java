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
	private PImage homeScreen;
	private int homeY;
	private PApplet app;
	
	public HomeView(PApplet app) {
		controller= new Controller();
		this.app = app;
		homeScreen = app.loadImage("../image/template/HOME.png");
		homeY=0;
	
		
	}
	
	public void drawScreen() {
		app.image(homeScreen, -4,homeY);
	
	}

	public void scroll(float e) {
		if(e>0) {
			if(homeY>-646) {
				homeY-=25;
		
			}
			
		}
		if(e<0) {
			if(homeY<0) {
				homeY+=25;
			}
			
		}
		
	}
	
	
	
}
