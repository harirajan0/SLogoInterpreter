package screenElements;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
  *  @author Daniel
 */

public class Palette extends Stage{
	private List<Color> myColors;
	private int numColors;
	public Palette(){
		myColors=new ArrayList<Color>();
		VBox fullPalette=new VBox();
		ScrollPane colorsPane = new ScrollPane();
		numColors=Integer.parseInt(Constants.DEFAULT_RESOURCE_BUNDLE.getString("numColorsInPalette"));
		for (int i=0; i<numColors; i++){
			int currentIndex=i;
			HBox paletteElement=new HBox();
			Rectangle colorBox=new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
			myColors.add(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color"+i))));
			colorBox.setFill(Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color"+i))));
			final ColorPicker colorPicker = new ColorPicker();
			Label l=new Label(Integer.toString(i));
			colorPicker.setOnAction(event ->  {
		    	colorBox.setFill(colorPicker.getValue());
		    	myColors.set(currentIndex, colorPicker.getValue());
		    });
			paletteElement.getChildren().addAll(l,colorPicker, colorBox);
			fullPalette.getChildren().add(paletteElement);
		}
		colorsPane.setContent(fullPalette);
		Scene s = new Scene(colorsPane);
		this.setScene(s);
	}
	
	public List<Color> getPaletteList(){
		return myColors;
	}
	
	
}
