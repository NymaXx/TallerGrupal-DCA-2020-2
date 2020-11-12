package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Contact view class 

 * @author: Juan P. Sanin

 * @version: 1.0 11/9/2020

 */   
public class ContactView {
	private Controller controller;
	private PImage navigation;
	private PImage emptySortBar,nameSortBar,nationalitySortBar,lastNameSortBar,
	cellPhoneSortBar,emailSortBar;
	private PApplet app;
	
	
	public ContactView(PApplet app) {
		controller= new Controller();
		this.app = app;	
		navigation = app.loadImage("../image/screens/navigationBar.png");
		emptySortBar=app.loadImage("../image/interactive/emptySortBar.png");
		nameSortBar=app.loadImage("../image/interactive/nameSortBar.png");
		nationalitySortBar=app.loadImage("../image/interactive/nationalitySortBar.png");
		lastNameSortBar=app.loadImage("../image/interactive/lastNameSortBar.png");
		cellPhoneSortBar=app.loadImage("../image/interactive/cellPhoneSortBar.png");
		emailSortBar=app.loadImage("../image/interactive/emailSortBar.png");
	}
	
	public void drawScreen() {
		app.image(navigation, -4, 0);
	}
	
	
}
