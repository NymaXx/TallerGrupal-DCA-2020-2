package view;

import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Main class Final Version

 * @author: Juan Pablo Sanin

 * @version: 1.6 11/16/2020

 */

public class Main extends PApplet {
	private int screen;
	private LoginView lv;
	private RegisterView rv;
	private HomeView hv;
	private MarsView mv;
	private MoonView mnv;
	private EarthView ev;
	private PayView pv;
	private ContactView cv;
	private ContactRegisterView crv;
	private ProfileView pfv;

	private boolean showProfile;
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	/** 
	 * 
	 *	Settings method in the main class <br>
		<b> pre: </b> <br>
		<b> post: </b> Creates the program screen dimensions<br>
	 */
	public void settings() {
		size(1280, 720);

	}

	/** 
	 * 
	 *	Setup method in the main class<br>
		<b> pre: </b> <br>
		<b> post: </b>Initializes all views and screen attribute<br>
	 */
	public void setup() {
		screen=1;
		lv= new LoginView(this);
		rv= new RegisterView(this);
		hv= new HomeView(this);
		mv= new MarsView(this);
		mnv=new MoonView(this);
		ev= new EarthView(this);
		pv=new PayView(this);
		cv= new ContactView(this);
		crv= new ContactRegisterView(this);
		pfv= new ProfileView(this);
		showProfile=false;

	}

	/** 
	 * 
	 *	Draw method in the main class<br>
		<b> pre: </b> <br>
		<b> post: </b>Visualizes the program and allows it fun function<br>
	 */
	public void draw() {
		background(0);

		switch(screen) {
		case 1:
			
			lv.drawScreen();
			if(lv.isError() || lv.isCannotLoginError()) {
				lv.getCp5().hide();
			}else {
				lv.getCp5().show();
			}
			rv.getCp5().hide();
			crv.getCp5().hide();
			pv.getCp5().hide();
	
			
			break;
		case 2:
			
			rv.drawScreen();
			if(rv.isError() || rv.isRegisterError() || rv.isPasswordMatchError()) {
				rv.getCp5().hide();
			}else {
				rv.getCp5().show();
			}
			lv.getCp5().hide();
			crv.getCp5().hide();
			pv.getCp5().hide();

			break;
		case 3:
			hv.drawScreen();
			lv.getCp5().hide();
			rv.getCp5().hide();
			crv.getCp5().hide();
			pv.getCp5().hide();
			break;
		case 4:
			mv.drawScreen();
			lv.getCp5().hide();
			rv.getCp5().hide();
			crv.getCp5().hide();
			pv.getCp5().hide();
			break;
		case 5:
			mnv.drawScreen();
			lv.getCp5().hide();
			rv.getCp5().hide();
			crv.getCp5().hide();
			pv.getCp5().hide();
			break;
		case 6:
			ev.drawScreen();
			lv.getCp5().hide();
			rv.getCp5().hide();
			crv.getCp5().hide();
			pv.getCp5().hide();
			break;
		case 7:
			pv.drawScreen();
			if(pv.isPurchased()||pv.isPaymentError()) {
				pv.getCp5().hide();
			}else {
				pv.getCp5().show();
			}
			lv.getCp5().hide();
			rv.getCp5().hide();
			crv.getCp5().hide();
			break;
		case 8:
			cv.drawScreen();
			crv.getCp5().hide();
			lv.getCp5().hide();
			rv.getCp5().hide();
			pv.getCp5().hide();
			
			break;
		case 9:
			crv.drawScreen();
			if(crv.isError() || crv.isContactAdded()) {
				crv.getCp5().hide();
			}else {
				crv.getCp5().show();
			}
			rv.getCp5().hide();
			lv.getCp5().hide();
			pv.getCp5().hide();
			break;
		}
		if(showProfile==true) {
			pfv.drawProfile();
		}
		fill(255,255);
		text(mouseX+","+mouseY, mouseX, mouseY);

	}


	
	/** 
	 * 
	 *	Mouse  pressed method in the main class<br>
		<b> pre: </b> <br>
		<b> post: </b>Registers clicks and acts based on where it happened<br>
	 */
	public void mousePressed() {
		if(showProfile==true) {
			if(!(mouseX>1028 && mouseX<1280 &&mouseY>72 && mouseY<344)) {
				showProfile=false;
			}
			int[] r= new int[2];
			r[1]=0;
			r=pfv.logout(screen);
			if(r[0]==1) {
				hv.setHomeY(0);
				hv.setCardsY(800);
				hv.setDrawArrow(true);
			}
			screen=r[0];
			if(r[1]==1) {
				showProfile=false;
			}
		}else {
			if(screen!=1 && screen!=2 &&mouseX>1112 && mouseX<1225 &&mouseY>28 && mouseY<43) {
				showProfile=true;
			}
			switch(screen) {
			case 1:
				screen=lv.changeScreen();
				rv.clearTextFields();
				pv.clearTextFields();
				crv.clearTextFields();
				break;
			case 2:
				screen=rv.changeScreen();
				lv.clearTextFields();
				pv.clearTextFields();
				crv.clearTextFields();
				break;
			case 3:
				screen=hv.changeScreen();
				lv.clearTextFields();
				rv.clearTextFields();
				pv.clearTextFields();
				crv.clearTextFields();
				break;
			case 4:
				screen=mv.changeScreen();
				lv.clearTextFields();
				rv.clearTextFields();
				pv.clearTextFields();
				crv.clearTextFields();
				break;
			case 5:
				screen=mnv.changeScreen();
				lv.clearTextFields();
				rv.clearTextFields();
				pv.clearTextFields();
				crv.clearTextFields();
				break;
			case 6:
				screen=ev.changeScreen();
				lv.clearTextFields();
				rv.clearTextFields();
				pv.clearTextFields();
				crv.clearTextFields();
				break;
			case 7:
				screen=pv.changeScreen();
				lv.clearTextFields();
				rv.clearTextFields();
				crv.clearTextFields();
				break;
			case 8:
				screen=cv.changeScreen();
				lv.clearTextFields();
				rv.clearTextFields();
				pv.clearTextFields();
				crv.clearTextFields();
				break;
			case 9:
				screen=crv.changeScreen();
				lv.clearTextFields();
				rv.clearTextFields();
				pv.clearTextFields();
				break;
			}
		}

	}

	
	
	
	/** 
	 * 
	 *	Mouse wheel method in the main class<br>
		<b> pre: </b> <br>
		<b> post: </b>Allows users to scroll depending on the screen<br>
	 */
	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();
		switch(screen) {
		case 3:
			hv.scroll(e);
			break;
		case 8:
			cv.scroll(e);
			break;
		}


	}

}
