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
	
	private Language myLang;
	
	public SLogoController(Stage s) {
		myLang = Language.ENGLISH;
		mySlogoView = new SLogoView(s);
		Turtle firstTurtle = new Turtle(mySlogoView.getTurtleWindow().getRoot());
		mySlogoModel = new SLogoModel();
		mySlogoData = new SLogoData(firstTurtle);
		mySlogoData.addObserver(mySlogoView);
		mySlogoData.addObserver(mySlogoModel);
		Turtle secondTurtle = new Turtle(mySlogoView.getTurtleWindow().getRoot(), 
										new TurtleInfo(250, 200, 0, true, true, Color.BLACK));
		mySlogoData.addTurtle(secondTurtle);
		mySlogoModel.setLanguage(myLang);
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
	

}
