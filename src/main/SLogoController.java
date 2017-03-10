/**
 * 
 */
package main;

import backend.SLogoModel;
import frontend.SLogoView;
import javafx.stage.Stage;
import turtle.Turtle;

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
		mySlogoModel.setLanguage(mySlogoData.getLanguage());
		mySlogoView.getExecuteButton().setOnAction(action -> {
			mySlogoModel.parse(mySlogoView.getUserInput().replace("\n", " ").trim());
			mySlogoView.addCommandToHistory(mySlogoView.getUserInput());
			mySlogoView.clearCommandPrompt();
		});
	}

	public SLogoView getView() {
		return mySlogoView;
	}

	public SLogoModel getModel() {
		return mySlogoModel;
	}

}
