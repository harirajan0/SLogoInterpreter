/**
 * 
 */
package main;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import backend.SLogoModel;
import constants.Constants;

import frontend.SLogoView;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import screenElements.ExceptionListener;
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
			try {
				mySlogoModel.parse(mySlogoView.getUserInput().replace("\n", " ").trim());
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			mySlogoView.addCommandToHistory(mySlogoView.getUserInput());
			mySlogoView.clearCommandPrompt();
		});
		setUpMovementButtons();
		setUpImageLoader(s);
	}

	private void setUpMovementButtons(){
		
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
	
	private void setUpImageLoader(Stage s){
		mySlogoView.getCommandBox().getFileLoader().setOnAction(action -> {
			FileChooser myChooser = new FileChooser();
			myChooser.setTitle(Constants.DEFAULT_RESOURCE_BUNDLE.getString("fileChooserTitle"));
			File myFile = myChooser.showOpenDialog(s);
			try {
				BufferedImage bufferedImage = ImageIO.read(myFile);
				Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				if(myFile!=null){
					for(Turtle currTurtle: mySlogoData.getTurtles()){
						currTurtle.getNode().setImage(image);
					}
				}
			} catch (Exception e) {
				new ExceptionListener(e);
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