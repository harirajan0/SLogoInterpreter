/**
 * 
 */
package main;

import backend.SLogoData;
import backend.SLogoModel;
import frontend.ExceptionAlert;
import frontend.SLogoView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import resources.Constants;
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
		mySlogoData.setRoot(mySlogoView.getTurtleWindow().getRoot());
		mySlogoModel.setLanguage(mySlogoData.getLanguage());
		mySlogoView.getExecuteButton().setOnAction(action -> {
			if (!mySlogoView.getUserInput().replace("\n", " ").trim().equals(""))
				try {
					mySlogoModel.parse(mySlogoView.getUserInput().replace("\n", " ").trim());
				} catch (Exception e) {
					new ExceptionAlert(e);
				}
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
		mySlogoView.getVariableUpdateButton().setOnAction(e -> {
			mySlogoView.getVariablesView().updateVariables();
			mySlogoData.setVariables(mySlogoView.getVariablesView().getVariables());
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Variables Updated!");
			alert.setContentText("You successfully updated your variables!");
			alert.showAndWait();
		});
		mySlogoView.getGraphicalDisplayButton().setOnAction(e -> {
			mySlogoView.toggleSlowSelection();
			mySlogoData.showSelectedGraphically(mySlogoView.getShowSelected());
		});
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

	private void setUpColorPickerEventHandlers(int index) {
		mySlogoView.getPaletteColorPickers().get(index).setOnAction(e -> 
				mySlogoData.changeColor(index, mySlogoView.getPaletteColorPickers().get(index).getValue()));
		
	}
}