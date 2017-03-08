/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import backend.SLogoModel;
import frontend.SLogoView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import languages.Language;
import turtle.Turtle;
import turtle.TurtleInfo;
import turtle.TurtleView;

/**
 * @author harirajan
 *
 */
public class SLogoController {
	
	private SLogoView mySlogoView;
	private SLogoModel mySlogoModel;
	private SLogoData mySlogoData;
	
	
	public SLogoController(Stage s) {
		mySlogoView = new SLogoView(s);
		Turtle firstTurtle = new Turtle(mySlogoView.getTurtleWindow().getRoot(), 1);
		mySlogoModel = new SLogoModel();
		mySlogoData = new SLogoData(firstTurtle);
		mySlogoData.addObserver(mySlogoView);
		mySlogoData.addObserver(mySlogoModel);
		Turtle secondTurtle = new Turtle(mySlogoView.getTurtleWindow().getRoot(), 
										new TurtleInfo(250, 200, 0, true, true, Color.BLACK), 2);
		mySlogoData.addTurtle(secondTurtle);
		mySlogoModel.setLanguage(mySlogoData.getLanguage());
		mySlogoView.getExecuteButton().setOnAction(action -> {
			for (String input : mySlogoView.getUserInput().trim().split("\n")) {
				mySlogoModel.parse(input);
				mySlogoView.addCommandToHistory(mySlogoView.getUserInput());
				mySlogoView.clearCommandPrompt();
			}
		});
	}
	
	public SLogoView getView() {
		return mySlogoView;
	}
	
	public SLogoModel getModel() {
		return mySlogoModel;
	}
	
	public void changeLanguage(Language newLanguage){
		myLang=newLanguage;
	}

}
