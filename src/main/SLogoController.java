/**
 * 
 */
package main;

import backend.SLogoModel;
import backend.TurtleInfo;
import frontend.SLogoView;
import javafx.stage.Stage;
import languages.Language;

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
		mySlogoModel = new SLogoModel(new TurtleInfo(mySlogoView.getTurtleWindow().getTurtleInfo()));
		mySlogoModel.setLanguage(myLang);
		mySlogoView.getExecuteButton().setOnAction(action -> {
			mySlogoModel.parse(mySlogoView.getUserInput().trim().replace("\n", " "));
			mySlogoView.addCommandToHistory(mySlogoView.getUserInput());
			mySlogoView.clearCommandPrompt();
			mySlogoView.getTurtleWindow().updateTurtlePosition(mySlogoModel.getTurtleInfo());
		});
	}
	
	public SLogoView getView() {
		return mySlogoView;
	}
	
	public SLogoModel getModel() {
		return mySlogoModel;
	}
	

}
