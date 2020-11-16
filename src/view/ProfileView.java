package view;

import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Profile view class Final Version

 * @author: Juan P. Sanin

 * @version: 1.1 11/16/2020

 */
public class ProfileView {

	private Controller controller;
	private PImage profileViewCard, logOutButtonUI;
	private PApplet app;
	
	/** 
	 * 
	 *	Constructor method for ProfileView <br>
		<b> pre: </b> <br>
		<b> post: </b> Creates the visualization of the profile<br>
	 * @param app, PApplet processing core
	 */
	public ProfileView(PApplet app) {
		controller= new Controller();
		this.app = app;
		profileViewCard = app.loadImage("../image/interactive/profileCard.png");
		logOutButtonUI = app.loadImage("../image/interactive/logOutButton.png");
	}
	
	/** 
	 * 
	 *	Method for drawing the profile<br>
		<b> pre: </b> <br>
		<b> post: </b>Draws the profile<br>
	 */
	public void drawProfile() {
		app.fill(0,90);
		app.rect(0,72,1280, 720);
		app.image(profileViewCard, 1028,72);
		if(app.mouseX>1028 && app.mouseX<1280 &&app.mouseY>309 && app.mouseY<345) {
			app.image(logOutButtonUI, 1028,309);
		}
		controller.drawUser(0);
	}
	
	
	/** 
	 * 
	 *	Method for logging out <br>
		<b> pre: </b> <br>
		<b> post: </b>Changes screens depending on the click<br>
		@param s, screen, the screen where the program is at
		@return r, int array representing the screen where the program should go, and if the profile should be shown
	 */
	public int[] logout(int s) {
		int[] r= new int[2];
		r[0]=s;
		r[1]=1;
		if(app.mouseX>1028 && app.mouseX<1280 &&app.mouseY>309 && app.mouseY<345) {
			r[0]=1;
			r[1]=1;
		}
		return r;
	}
	
	
	
}
