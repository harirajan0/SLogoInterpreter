package frontend;

import constants.Constants;
import javafx.scene.Node;
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
		colorOne.setFill(Color.web(Constants.COLOR_DELIMITER + Constants.FIRST_COLOR));
		colorTwo.setFill(Color.web(Constants.COLOR_DELIMITER + Constants.SECOND_COLOR));
		colorThree.setFill(Color.web(Constants.COLOR_DELIMITER + Constants.THIRD_COLOR));
		colorFour.setFill(Color.web(Constants.COLOR_DELIMITER + Constants.FOURTH_COLOR));
		myColors.getChildren().addAll(colorOne, colorTwo, colorThree, colorFour);
				
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
		colorOne.setFill(Color.web(Constants.COLOR_DELIMITER + "(" + rgbValue + ")"));
	}
	
	public void setColorTwo(String rgbValue){
		colorTwo.setFill(Color.web(Constants.COLOR_DELIMITER + "(" + rgbValue + ")"));
	}
	
	public void setColorThree(String rgbValue){
		colorThree.setFill(Color.web(Constants.COLOR_DELIMITER + "(" + rgbValue + ")"));
	}
	
	public void setColorFour(String rgbValue){
		colorFour.setFill(Color.web(Constants.COLOR_DELIMITER + "(" + rgbValue + ")"));
	}
}
