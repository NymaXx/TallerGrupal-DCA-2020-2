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
	private PImage payButton,payButtonUI, paySuccess,navigation;
	private PApplet app;
	

	public PayView(PApplet app) {
		controller= new Controller();
		this.app = app;
		payScreen = app.loadImage("../image/screens/payScreen.png");
		navigation = app.loadImage("../image/screens/navigationBar.png");
		payButton= app.loadImage("../image/interactive/payButton.png");
		paySuccess = app.loadImage("../image/interactive/paySuccessfull.png");
		payButtonUI= app.loadImage("../image/interactive/payButtonUI.png");
	}
}
