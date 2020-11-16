package view;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Home view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */
	

public class HomeView {


	private PImage homeScreen, flightNavBar, arrow;
	private int homeY,cardsY;
	private boolean drawArrow;
	private PApplet app;
	
	public HomeView(PApplet app) {
		this.app = app;
		homeScreen = app.loadImage("../image/template/HOME.png");
		flightNavBar=app.loadImage("../image/interactive/flightNavBar.png");
		arrow= app.loadImage("../image/interactive/arrowVector.png");
		homeY=0;
		cardsY=800;
		drawArrow=true;
		
		
	}
	
	public void drawScreen() {
		app.image(homeScreen, -4,homeY);
		app.image(flightNavBar, -4, 0);
		if(drawArrow==true) {
			app.image(arrow, 614, 675);
		}
		
	}
	
	public int changeScreen() {
		int screen=3;
		if(app.mouseX>185 && app.mouseX<442 &&app.mouseY>cardsY && app.mouseY<cardsY+259) {
			screen=4;
			drawArrow=true;
			homeY=0;
			cardsY=800;
		}
		
		if(app.mouseX>511 && app.mouseX<768 &&app.mouseY>cardsY && app.mouseY<cardsY+259) {
			screen=5;
			drawArrow=true;
			homeY=0;
			cardsY=800;
		}
		
		if(app.mouseX>837 && app.mouseX<1094 &&app.mouseY>cardsY && app.mouseY<cardsY+259) {
			screen=6;
			drawArrow=true;
			homeY=0;
			cardsY=800;
		}
		
		if(app.mouseX>538 && app.mouseX<650 &&app.mouseY>28 && app.mouseY<43) {
			screen=8;
			drawArrow=true;
			homeY=0;
			cardsY=800;
		}
		if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
			screen=9;
			drawArrow=true;
			homeY=0;
			cardsY=800;
		}
		return screen;
	}

	public void scroll(float e) {
		if(e>0) {
			if(homeY>-646) {
				homeY-=25;
				cardsY-=25;
			}
			drawArrow=false;
			
		}
		if(e<0) {
			if(homeY<0) {
				homeY+=25;
				cardsY+=25;
			}
			
		}
		
	}

	public void setHomeY(int homeY) {
		this.homeY = homeY;
	}

	public void setCardsY(int cardsY) {
		this.cardsY = cardsY;
	}

	public void setDrawArrow(boolean drawArrow) {
		this.drawArrow = drawArrow;
	}
	
	
	
}
