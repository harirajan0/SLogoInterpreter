/**
 * 
 */
package main;

import java.io.File;

import backend.SLogoData;
import backend.SLogoModel;
import backend.turtle.Turtle;
import constants.Constants;
import frontend.ExceptionAlert;
import frontend.SLogoView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @author harirajan
 *  * The controller is the center of our program. It contains an instance of SLogoModel, an instance of SLogoView, and an instance of SLogoData.
 * When the backend makes changes on our SLogoData, SLogoController gives our instance of SLogoView the updated data, and vice versa, when the frontend makes changes on the SLogoData, the controller allows the SLogoModel
 * to receive the updated data. To do this, we use observables (SLogoData is observable, and our instance of SLogoData in the controller is observed by SLogoModel and SlogoView).
 *
 * We also define the actions of the frontend's buttons/sliders in this class.
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
		setupEventHandlers();
	}
	
	private void setupEventHandlers() {
		setUpTurtleMovementButtonHandlers();
		setUpTurtleExecuteButtonHandler();
		setUpTurtleImageSelectionHandler();
		setUpVariableUpdateHandler();
		setUpViewSelectionGraphicallyHandler();
		setUpLanguageChoiceBoxHandler();
		setUpPenColorChoiceBoxHandler();
		setUpPenThicknessSliderHandler();
		setUpBackgroundColorPickerHandler();
		for (int i = 0; i < mySlogoView.getPaletteColorPickers().size(); i++) setUpColorPickerEventHandlers(i);
	}

	/**
	 * 
	 */
	private void setUpLanguageChoiceBoxHandler() {
		mySlogoView.getLanguageChoiceBox().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				mySlogoData.setLanguage(newValue);
			}
    	});
	}


	/**
	 * 
	 */
	private void setUpPenColorChoiceBoxHandler() {
		mySlogoView.getPenColorChoiceBox().getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mySlogoData.setPenColor((int) newValue);
			}
    	});
	}


	/**
	 * 
	 */
	private void setUpPenThicknessSliderHandler() {
		mySlogoView.getPenThicknessSlider().valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mySlogoData.setPenWidth((double) newValue);
			}
    	});
	}


	/**
	 * 
	 */
	private void setUpBackgroundColorPickerHandler() {
		mySlogoView.getBackgroundColorPicker().setOnAction(e -> mySlogoData.changeBackgroundColor(mySlogoView.getBackgroundColorPicker().getValue()));
	}


	/**
	 * 
	 */
	private void setUpViewSelectionGraphicallyHandler() {
		mySlogoView.getGraphicalDisplayButton().setOnAction(e -> {
			mySlogoView.toggleShowSelection();
			mySlogoData.showSelectedGraphically(mySlogoView.getShowSelected());
		});
	}


	/**
	 * 
	 */
	private void setUpVariableUpdateHandler() {
		mySlogoView.getVariableUpdateButton().setOnAction(e -> {
			mySlogoView.getVariablesView().updateVariables();
			mySlogoData.setVariables(mySlogoView.getVariablesView().getVariables());
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Variables Updated!");
			alert.setContentText("You successfully updated your variables!");
			alert.showAndWait();
		});	
	}


	/**
	 * 
	 */
	private void setUpTurtleImageSelectionHandler() {
		mySlogoView.getTurtleImageSelectionButton().setOnAction(e -> {
			FileChooser fc = new FileChooser();
	        fc.setTitle(Constants.IMAGE_CHOOSER_TITLE);
	        fc.setInitialDirectory(new File(System.getProperty("user.dir"), "./images"));
	        fc.getExtensionFilters().setAll(new ExtensionFilter("Images", "*.png"));
	        File imageFile;
	        if (!((imageFile = fc.showOpenDialog(null)) == null)){
	        	mySlogoData.changeImage(new Image(imageFile.getName()));
	        }
		});
	}


	/**
	 * 
	 */
	private void setUpTurtleExecuteButtonHandler() {
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
	}


	/**
	 * 
	 */
	private void setUpTurtleMovementButtonHandlers() {
		mySlogoView.getCommandBox().setForwards(e -> mySlogoData.moveSelectedTurtles(Constants.FORWARD_BUTTON_DISTANCE, 0));
		mySlogoView.getCommandBox().setBackwards(e -> mySlogoData.moveSelectedTurtles(Constants.BACKWARDS_BUTTON_DISTANCE, 0));
		mySlogoView.getCommandBox().setRotateLeft(e -> mySlogoData.moveSelectedTurtles(0, Constants.LEFT_BUTTON_ROTATION));
		mySlogoView.getCommandBox().setRotateRight(e -> mySlogoData.moveSelectedTurtles(0, Constants.RIGHT_BUTTON_ROTATION));
	}


	private void setUpColorPickerEventHandlers(int index) {
		mySlogoView.getPaletteColorPickers().get(index).setOnAction(e -> 
				mySlogoData.changeColor(index, mySlogoView.getPaletteColorPickers().get(index).getValue()));
		
	}
}