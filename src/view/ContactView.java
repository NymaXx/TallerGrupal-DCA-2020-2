package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PFont;
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
	private int current;
	private int contactsY;
	private PFont font;
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
		font = app.createFont("../font/Heebo-Regular.ttf", 18);
		contactsY=173;
		current=0;
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
		current=controller.getAdminSystem().getCurrentUser();
		app.background(255);
		app.fill(240);
		app.noStroke();
		app.rect(323, 127, 634, 673);
		
		
		
		
		if(controller.getAdminSystem().getUsers().get(current).getContacts().isEmpty()) {
			if(app.mouseX>534 && app.mouseX<733 &&app.mouseY>420 && app.mouseY<467) {
				app.image(addButtonUI, 515, 360);
			}else {
				app.image(addButton, 515, 360);
			}
		}
		
		if(!controller.getAdminSystem().getUsers().get(current).getContacts().isEmpty()) {
			for (int i = 0; i < controller.getAdminSystem().getUsers().get(current).getContacts().size(); i++) {
				controller.getAdminSystem().getUsers().get(current).getContacts().get(i).setFont(font);
				controller.getAdminSystem().getUsers().get(current).getContacts().get(i).draw(contactsY+(i*125));
			}
			
		}	
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

		/*for (int i = 0; i < controller.getDogList().getDogList().size(); i++) {
			controller.getDogList().getDogList().get(i).draw(25+(i*130));
		}*/
		
	}

	public int changeScreen() {
		int screen=8;


		if(app.mouseX>358 && app.mouseX<437 &&app.mouseY>28 && app.mouseY<43) {
			screen=3;
		}
		
		if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
			screen=9;
		}
		
		if(controller.getAdminSystem().getUsers().get(controller.getAdminSystem().getCurrentUser()).getContacts().isEmpty()) {
		if(app.mouseX>534 && app.mouseX<733 &&app.mouseY>420 && app.mouseY<467) {
			screen=9;
		}
		}else {
			if(app.mouseX>0 && app.mouseX<260 && app.mouseY>70 && app.mouseY<125) {
				sort=1;
				contactsY=173;
			}
			if(app.mouseX>260 && app.mouseX<515 &&  app.mouseY>70 && app.mouseY<125) {
				sort=2;
				contactsY=173;
			}
			if(app.mouseX>515 && app.mouseX<765 && app.mouseY>70 && app.mouseY<125) {
				sort=3;
				contactsY=173;
			}
			if(app.mouseX>765 && app.mouseX<1015 &&  app.mouseY>70 && app.mouseY<125) {
				sort=4;
				contactsY=173;
			}
			if(app.mouseX>1015 && app.mouseX<1280 &&  app.mouseY>70 && app.mouseY<125) {
				sort=5;
				contactsY=173;
			}
			controller.sort(sort);
		}
		
		
		return screen;
	}



	public void scroll(float e) {
		if(e>0) {
			if(contactsY>-((controller.getAdminSystem().getUsers().get(current).getContacts().size()*125)-720)) {
				contactsY-=25;	
			}
			
		}
		if(e<0) {
			if(contactsY<173) {
			contactsY+=25;	
			}
		}
		
	}
	



}
