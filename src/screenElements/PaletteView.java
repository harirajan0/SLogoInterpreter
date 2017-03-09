package screenElements;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import constants.Constants;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 *  @author Belal Taher
 *  @author Daniel
 */
public class PaletteView extends Stage{
	
	private VBox myColorsView;
	private Rectangle colorOne;
	private Rectangle colorTwo;
	private Rectangle colorThree;
	private Rectangle colorFour;
	
	private List<Paint> myColorsList;

			//Arrays.asList(colorOne.getFill(), colorTwo.getFill(), colorThree.getFill(), colorFour.getFill()));
	
	public PaletteView(){
		myColorsView = new VBox();
		
		colorOne = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		colorTwo = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING*2, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		colorThree = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING*3, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		colorFour = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING*4, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		
		colorOne.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color1"))));
		colorTwo.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color2"))));
		colorThree.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color3"))));
		colorFour.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color4"))));
		
		
		myColorsList = new ArrayList<Paint>(Arrays.asList(colorOne.getFill(), colorTwo.getFill(), 
				colorThree.getFill(), colorFour.getFill()));
		
		createHBoxForColor(colorOne, 1);
		createHBoxForColor(colorTwo, 2);
		createHBoxForColor(colorThree, 3);
		createHBoxForColor(colorFour, 4);
		
	    Scene s = new Scene(myColorsView);
	    this.setScene(s);
	    this.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
				
	}
	
	private void createHBoxForColor(Rectangle c, int index){
		HBox myBox = new HBox();
		ImageView number = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.DEFAULT_RESOURCE_BUNDLE.getString("num" + index))));
		number.setFitWidth(Constants.TURTLE_SIZE);
		number.setFitHeight(Constants.TURTLE_SIZE);
		myBox.getChildren().addAll(c, number);
		myColorsView.getChildren().add(myBox);
	}
	
	public Node getNode(){
		return myColorsView;
	}
	
	public Paint getColorAtIndex(int index){
		return myColorsList.get(index);
	}
	
	public void setColorOne(String rgbValue){
		colorOne.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + "(" + rgbValue + ")"));
	}
	
	public void setColorTwo(String rgbValue){
		colorTwo.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter")+ "(" + rgbValue + ")"));
	}
	
	public void setColorThree(String rgbValue){
		colorThree.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + "(" + rgbValue + ")"));
	}
	
	public void setColorFour(String rgbValue){
		colorFour.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + "(" + rgbValue + ")"));
	}
	
	private void displayPaletteTextFields(Group newRoot){  //NEEDS TO BE REFACTORED!!!
		Group newRoot2 = new Group();
		VBox textFields = new VBox();
		TextArea colorOneField = new TextArea("Color 1");
		colorOneField.setPrefHeight(10);
		TextArea colorTwoField = new TextArea("Color 2");
		colorTwoField.setPrefHeight(10);
		TextArea colorThreeField = new TextArea("Color 3");
		colorThreeField.setPrefHeight(10);
		TextArea colorFourField = new TextArea("Color 4");
		colorFourField.setPrefHeight(10);
		Button changeColors = new Button("Change colors");
		changeColors.setOnAction((event) -> {
			updateColors(colorOneField.getText(), colorTwoField.getText(), colorThreeField.getText(), colorFourField.getText());
		});
		textFields.getChildren().addAll(colorOneField, colorTwoField, colorThreeField, colorFourField, changeColors);
		newRoot.getChildren().add(textFields);
	}
	
	private void updateColors(String c1, String c2, String c3, String c4){
		this.setColorOne(c1);
		this.setColorTwo(c2);
		this.setColorThree(c3);
		this.setColorFour(c4);
	}
	
	public void displayPalettePicker(){
		Group newRoot = new Group();
		displayPaletteTextFields(newRoot);
		Stage paletteColorPicker = new Stage();
		paletteColorPicker.setTitle(Constants.DEFAULT_RESOURCE_BUNDLE.getString("palettePickerName"));
		paletteColorPicker.setScene(new Scene(newRoot, Constants.PALETTE_PICKER_SIZE, Constants.PALETTE_PICKER_SIZE, Constants.BACKGROUND_COLOR));
		paletteColorPicker.show();
	}
	
	/*public void setColorByIndex(){
		colorOne.setFill(Color.web(Constants.COLOR_DELIMITER + "(" + rgbValue + ")"));
	}*/
}