package frontend;

import constants.Constants;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *  @author Belal Taher
 */

public class PaletteView {
	
	private VBox myColors;
	private Rectangle colorOne;
	private Rectangle colorTwo;
	private Rectangle colorThree;
	private Rectangle colorFour;
	
	public PaletteView(){
		myColors = new VBox();
		
		colorOne = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		colorTwo = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING*2, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		colorThree = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING*3, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		colorFour = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING*4, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		
		colorOne.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color1"))));
		colorTwo.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color2"))));
		colorThree.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color3"))));
		colorFour.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color4"))));
		
		createHBoxForColor(colorOne, 1);
		createHBoxForColor(colorTwo, 2);
		createHBoxForColor(colorThree, 3);
		createHBoxForColor(colorFour, 4);
				
	}
	
	private void createHBoxForColor(Rectangle c, int index){
		HBox myBox = new HBox();
		ImageView number = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.DEFAULT_RESOURCE_BUNDLE.getString("num" + index))));
		number.setFitWidth(Constants.TURTLE_SIZE);
		number.setFitHeight(Constants.TURTLE_SIZE);
		myBox.getChildren().addAll(c, number);
		myColors.getChildren().add(myBox);
	}
	
	public Node getNode(){
		return myColors;
	}
	
	public Paint getColorOne(){
		return colorOne.getFill();
	}
	
	public Paint getColorTwo(){
		return colorTwo.getFill();
	}
	
	public Paint getColorThree(){
		return colorThree.getFill();
	}
	
	public Paint getColorFour(){
		return colorFour.getFill();
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
	
	/*public void setColorByIndex(){
		colorOne.setFill(Color.web(Constants.COLOR_DELIMITER + "(" + rgbValue + ")"));
	}*/

}
