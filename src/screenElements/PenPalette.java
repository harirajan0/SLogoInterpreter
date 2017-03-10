package screenElements;

import constants.Constants;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PenPalette extends Palette<Color>{

	@Override
	public Rectangle getItem(int i) {
		Color currentColor=Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter") + (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color"+i)));
		Rectangle colorBox=new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING, Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
		myColors.add(currentColor);
		colorBox.setFill(currentColor);
		return null;
	}
	
	
	
	
	
//	int currentIndex = i;
//	HBox paletteElement = new HBox();
//	Color currentColor = Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter")
//			+ (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color" + i)));
//	if (Integer.parseInt(Constants.DEFAULT_RESOURCE_BUNDLE.getString("DefaultPenColorNumber")) == i) {
//		myCurrentColor = currentColor;
//	}
//	Rectangle colorBox = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING,
//			Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
//	myColors.add(currentColor);
//	colorBox.setFill(currentColor);
//	final ColorPicker colorPicker = new ColorPicker();
//	colorPicker.setValue(currentColor);
//	Label l = new Label(Integer.toString(i));
//	Button b = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penColor"));
//	colorPicker.setOnAction(event -> {
//		colorBox.setFill(colorPicker.getValue());
//		myColors.set(currentIndex, (Color) colorBox.getFill());
//	});
//	b.setOnAction(event -> {
//		myCurrentColor = colorPicker.getValue();
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setHeaderText(null);
//		alert.setContentText(Constants.DEFAULT_RESOURCE_BUNDLE.getString("onPenColorChange"));
//
//		alert.showAndWait();
//	});
//	
	
	

}
