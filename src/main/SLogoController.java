/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import backend.SLogoModel;
import frontend.SLogoView;
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
	
	private Language myLang;
	
	public SLogoController(Stage s) {
		myLang = Language.ENGLISH;
		mySlogoView = new SLogoView(s);
		Turtle firstTurtle = new Turtle();
		firstTurtle.setNext(mySlogoView.getTurtleWindow().getTurtleInfo());
		firstTurtle.prepareForNextCommand();
		List<Turtle> turtles = new ArrayList<>();
		turtles.add(firstTurtle);
		mySlogoModel = new SLogoModel(turtles);
		mySlogoModel.setLanguage(myLang);
		mySlogoView.getExecuteButton().setOnAction(action -> {
			for (String input : mySlogoView.getUserInput().trim().split("\n")) {
				mySlogoModel.parse(input);
				mySlogoView.addCommandToHistory(mySlogoView.getUserInput());
				mySlogoView.clearCommandPrompt();
				mySlogoView.getTurtleWindow().updateTurtle(mySlogoModel.getTurtles());
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
