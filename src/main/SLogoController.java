/**
 * 
 */
package main;

import backend.SLogoModel;
import constants.Constants;

import frontend.SLogoView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
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
		setUpMovementButtons();
	}

	public void setUpMovementButtons(){
		
		mySlogoView.getCommandBox().getForwardButton().setOnAction(action -> {
			mySlogoData.moveSelectedTurtles(Constants.FORWARD_BUTTON_DISTANCE, 0);
		});
		
		mySlogoView.getCommandBox().getRightRotate().setOnAction(action -> {
			mySlogoData.moveSelectedTurtles(0, Constants.RIGHT_BUTTON_ROTATION);
		});
		
		mySlogoView.getCommandBox().getLeftRotate().setOnAction(action -> {
			mySlogoData.moveSelectedTurtles(0, Constants.LEFT_BUTTON_ROTATION);
		});
		
		mySlogoView.getCommandBox().getBackwardsButton().setOnAction(action -> {
			mySlogoData.moveSelectedTurtles(Constants.BACKWARDS_BUTTON_DISTANCE, 0);
		});
	}
	
	public SLogoView getView() {
		return mySlogoView;
	}

	public SLogoModel getModel() {
		return mySlogoModel;
	}

}