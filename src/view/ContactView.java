package view;

import controlP5.ControlP5;
import controlP5.Textfield;
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
	private PImage addButton, addButtonUI;
	private int sort;
	private PApplet app;
	
	
	


	public ContactView(PApplet app) {
		controller= new Controller();
		this.app = app;	
		navigation = app.loadImage("../image/interactive/contactNavBar.png");
		emptySortBar=app.loadImage("../image/interactive/emptySortBar.png");
		nameSortBar=app.loadImage("../image/interactive/nameSortBar.png");
		nationalitySortBar=app.loadImage("../image/interactive/nationalitySortBar.png");
		lastNameSortBar=app.loadImage("../image/interactive/lastNameSortBar.png");
		cellPhoneSortBar=app.loadImage("../image/interactive/cellPhoneSortBar.png");
		emailSortBar=app.loadImage("../image/interactive/emailSortBar.png");
		addButton = app.loadImage("../image/interactive/addButton.png");
		addButtonUI = app.loadImage("../image/interactive/addButtonUI.png");

		/**sort will represent how the contacts are sorted 
		0 is for not sorted
		1 is for sorting by name
		2 is for sorting by nationality
		3 if for sorting by lastName
		4 is for sorting by cell phone 
		5 is for sorting by email
		 */
		sort= 0;
		
	}
	
	

	public void drawScreen() {
		app.background(255);
		switch(sort) {
		case 0:
			app.image(emptySortBar, -4, 72);
			break;
		case 1:
			app.image(nameSortBar, -4, 72);
			break;
		case 2:
			app.image(nationalitySortBar, -4, 72);
			break;
		case 3:
			app.image(lastNameSortBar, -4, 72);
			break;
		case 4:
			app.image(cellPhoneSortBar, -4, 72);
			break;
		case 5:
			app.image(emailSortBar, -4, 72);
			break;

		}
		app.image(navigation, -4, 0);
		//If list empty show this
		
		if(app.mouseX>534 && app.mouseX<733 &&app.mouseY>420 && app.mouseY<467) {
			app.image(addButtonUI, 515, 360);
		}else {
			app.image(addButton, 515, 360);
		}
		 

	}

	public int changeScreen() {
		int screen=8;


		if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
			screen=3;
		}
		
		if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
			screen=9;
		}
		
		//If list is empty
		if(app.mouseX>534 && app.mouseX<733 &&app.mouseY>420 && app.mouseY<467) {
			screen=9;
		}

		
		if(app.mouseX>0 && app.mouseX<260 && app.mouseY>70 && app.mouseY<125) {
			sort=1;
		}
		if(app.mouseX>260 && app.mouseX<515 &&  app.mouseY>70 && app.mouseY<125) {
			sort=2;
		}
		if(app.mouseX>515 && app.mouseX<765 && app.mouseY>70 && app.mouseY<125) {
			sort=3;
		}
		if(app.mouseX>765 && app.mouseX<1015 &&  app.mouseY>70 && app.mouseY<125) {
			sort=4;
		}
		if(app.mouseX>1015 && app.mouseX<1280 &&  app.mouseY>70 && app.mouseY<125) {
			sort=5;
		}

		return screen;
	}
	



}
