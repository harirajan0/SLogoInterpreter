// This entire file is part of my masterpiece.
// Daniel Rubinstein
package main;

import backend.SLogoData;
import backend.SLogoModel;
import backend.turtle.Turtle;
import frontend.SLogoView;
import javafx.stage.Stage;

/**
 * @authors: Daniel Rubinstein and Hari Rajan
 * The controller is the center of our program. It contains an instance of SLogoModel, an instance of 
 * SLogoView, and an instance of SLogoData. When the backend makes changes on our SLogoData, SLogoController
 * gives our instance of SLogoView the updated data, and vice versa. To do this, we use observables (SLogoData is observable).
 * This class shows how we combined backend and frontend in a concise and effective way.
 * This class is significantly shorter and cleaner than the original version. I did this by adding functionality to SLogoView,
 * and at the same time getting rid of all our getters and setters (better design).
 */

public class SLogoController {

	private SLogoView mySlogoView;
	private SLogoModel mySlogoModel;
	private SLogoData mySlogoData;
	
	public SLogoController(Stage s) {
		mySlogoView = new SLogoView(s, this);
		Turtle firstTurtle = new Turtle(mySlogoView.getTurtleWindow().getRoot(), 1);
		mySlogoData = new SLogoData(firstTurtle); //we always are using the same instance of SLogoData throughout the program's execution
		mySlogoModel = new SLogoModel();
		mySlogoData.addObserver(mySlogoView);
		mySlogoData.addObserver(mySlogoModel);
		mySlogoData.setRoot(mySlogoView.getTurtleWindow().getRoot());
		mySlogoModel.setLanguage(mySlogoData.getLanguage());
	}
	
	public SLogoData getMainSLogoData(){ //SLogoView needs to have access to our instance of SlogoData to be able to modify
										 //our controller's SLogoData via frontend (ex: by clicking on a button)
		return mySlogoData;
	}
	
	public SLogoModel getMainSlogoModel(){
		return mySlogoModel;
	}
}