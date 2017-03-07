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
 * @author Daniel
 *
 */
public class SLogoController {
	
	private SLogoView mySlogoView;
	private SLogoModel mySlogoModel;
	
	private static Language myLang;
	
	public SLogoController(Stage s) {
		mySlogoView = new SLogoView(s);
		myLang = Language.ENGLISH; //DEFAULT
		mySlogoModel = new SLogoModel(new TurtleInfo(mySlogoView.getTurtleBox().getCurrentTurtle().getTurtleInfo()));
		mySlogoModel.setLanguage(myLang);
		mySlogoView.getExecuteButton().setOnAction(action -> {
			mySlogoModel.parse(mySlogoView.getUserInput().trim().replace("\n", " "));
			mySlogoView.addCommandToHistory(mySlogoView.getUserInput());
			mySlogoView.clearCommandPrompt();
			mySlogoView.getTurtleBox().getCurrentTurtle().updateTurtlePosition(mySlogoModel.getTurtleInfo());
		});
	}
	
	public SLogoView getView() {
		return mySlogoView;
	}
	
	public SLogoModel getModel() {
		return mySlogoModel;
	}
	
	
	public static void changeLanguage(Language newLanguage){
		myLang=newLanguage;
		//System.out.println("languageChanged");
	}
	

}
