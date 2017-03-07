/**
 * 
 */
package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import backend.SLogoModel;
import backend.TurtleInfo;
import frontend.SLogoView;
import frontend.TurtleView;
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
		TurtleView firstTurtle = new TurtleView();
		firstTurtle.setNext(mySlogoView.getTurtleWindow().getTurtleInfo());
		firstTurtle.prepareForNextCommand();
		List<TurtleView> turtles = new ArrayList<>();
		turtles.add(firstTurtle);
		mySlogoModel = new SLogoModel(turtles);
		mySlogoModel.setLanguage(myLang);
		mySlogoView.getExecuteButton().setOnAction(action -> {
			for (String input : mySlogoView.getUserInput().trim().split("\n")) {
				mySlogoModel.parse(input);
				mySlogoView.addCommandToHistory(mySlogoView.getUserInput());
				mySlogoView.clearCommandPrompt();
				mySlogoView.getTurtleWindow().updateTurtlePosition(mySlogoModel.getTurtleInfo());
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