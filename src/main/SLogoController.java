/**
 * 
 */
package main;

import backend.SLogoModel;
import constants.Constants;

import frontend.SLogoView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import languages.LanguageFactory;
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
		
		setupEventHandlers();
	}

	
	public SLogoView getView() {
		return mySlogoView;
	}

	public SLogoModel getModel() {
		return mySlogoModel;
	}
	
	private void setupEventHandlers() {
		mySlogoView.getCommandBox().setForwards(e -> mySlogoData.moveSelectedTurtles(Constants.FORWARD_BUTTON_DISTANCE, 0));
		mySlogoView.getCommandBox().setBackwards(e -> mySlogoData.moveSelectedTurtles(Constants.BACKWARDS_BUTTON_DISTANCE, 0));
		mySlogoView.getCommandBox().setRotateLeft(e -> mySlogoData.moveSelectedTurtles(0, Constants.LEFT_BUTTON_ROTATION));
		mySlogoView.getCommandBox().setRotateRight(e -> mySlogoData.moveSelectedTurtles(0, Constants.RIGHT_BUTTON_ROTATION));
		mySlogoView.getBackgroundColorPicker().setOnAction(e -> mySlogoData.changeBackgroundColor(mySlogoView.getBackgroundColorPicker().getValue()));
		mySlogoView.getLanguageChoiceBox().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				mySlogoData.setLanguage(newValue);
			}
			
    	});
		mySlogoView.getPenColorChoiceBox().getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mySlogoData.setPenColor((int) newValue);
			}
    	});
		mySlogoView.getPenThicknessSlider().valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mySlogoData.setPenWidth((double) newValue);
			}
    	});
		for (int i = 0; i < mySlogoView.getPaletteColorPickers().size(); i++) setUpColorPickerEventHandlers(i);
	}

	public void setUpColorPickerEventHandlers(int index) {
		mySlogoView.getPaletteColorPickers().get(index).setOnAction(e -> 
				mySlogoData.changeColor(index, mySlogoView.getPaletteColorPickers().get(index).getValue()));
		
	}
}