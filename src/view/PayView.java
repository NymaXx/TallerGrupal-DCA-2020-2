package view;

import controlP5.ControlP5;
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
	private PImage payScreen, navBar;
	private PImage payButtonUI, paySuccess;
	private boolean purchased;
	private PApplet app;
	private String CardNumber;
	private String MMDD;
	private String CVV;
	private String White;
	private String[] inputs;
	private ControlP5 cp5;
	private int passanger = 1;
	//precio prueba
	private int price = 2500;
	

	public PayView(PApplet app) {
		controller= new Controller();
		this.app = app;
		
		payScreen = app.loadImage("../image/screens/payScreen.png");
		navBar= app.loadImage("../image/interactive/navBar.png");
		paySuccess = app.loadImage("../image/interactive/paySuccessfull.png");
		payButtonUI= app.loadImage("../image/interactive/payButtonUI.png");
		purchased=false;
		cp5 = new ControlP5(app);
		inputs = new String[7];
		initializeTextFields();
	}
	
	private void initializeTextFields() {
		inputs[0] = "Card Number";
		inputs[1] = "MM/DD";
		inputs[2] = "CVV";
		inputs[3] = " ";
		
		cp5.addTextfield(inputs[0]).setPosition(155,360).setSize(631, 43).setAutoClear(true);
		cp5.addTextfield(inputs[1]).setPosition(155,468).setSize(238, 43).setAutoClear(true);
		cp5.addTextfield(inputs[2]).setPosition(548,468).setSize(238, 43).setAutoClear(true);
		cp5.addTextfield(inputs[3]).setPosition(155,576).setSize(238, 43).setAutoClear(true);
	}
	
	public void hide() {
		cp5.hide();
	}
	
	public void drawScreen() {
		
		if(purchased==true) {
			app.image(payScreen, -4, 0);
			app.image(navBar, -4, 0);
			app.fill(0,95);
			app.rect(0,0,1280, 720);
			app.image(paySuccess,394, 182);
		}else {
			app.image(payScreen, -4, 0);
			app.image(navBar, -4, 0);
			if(app.mouseX>886 && app.mouseX<1236 &&app.mouseY>578 && app.mouseY<632) {
				app.image(payButtonUI, 886, 578);
			}
			
		}
		
		app.fill(0);
		app.textSize(18);
		app.text(passanger, 1017, 400);
		
		app.text(price *passanger, 1080, 493);
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
			if(app.mouseX>740 && app.mouseX<875 &&app.mouseY>28 && app.mouseY<43) {
				screen=9;
			}
			if(app.mouseX>886 && app.mouseX<1236 &&app.mouseY>578 && app.mouseY<632) {
				purchased=true;
			}
			
			if(app.mouseX>1045 && app.mouseX<1059 &&app.mouseY>387 && app.mouseY<396) {
				passanger++;
			}
			//Multiplicar el precio por pasageros 
			if(app.mouseX>1060 && app.mouseX<1072 &&app.mouseY>387 && app.mouseY<396) {
				passanger++;
				if(passanger-->=3) {
					passanger--;
				}
			}
		}
		return screen;
	}
	
}
