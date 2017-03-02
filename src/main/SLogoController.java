/**
 * 
 */
package main;

import backend.TurtleInfo;
import javafx.stage.Stage;

/**
 * @author harirajan
 *
 */
public class SLogoController {
	
	private SLogoView mySlogoView;
	private SLogoModel mySlogoModel;
	
	public SLogoController(Stage s) {
		mySlogoView = new SLogoView(s);
		mySlogoModel = new SLogoModel("English", new TurtleInfo(mySlogoView.getTurtleWindow().getTurtleInfo()));
		mySlogoView.getExecuteButton().setOnAction(action -> {
			mySlogoModel.parse(mySlogoView.getUserInput());
			mySlogoView.clearCommandPrompt();
			mySlogoView.getTurtleWindow().updateTurtlePosition(mySlogoModel.getTurtleInfo());
			System.out.println("BUTTON CLICKED");
		});
	}
	
	public SLogoView getView() {
		return mySlogoView;
	}
	
	public SLogoModel getModel() {
		return mySlogoModel;
	}
	

}
