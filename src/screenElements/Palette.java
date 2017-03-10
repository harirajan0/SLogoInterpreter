package screenElements;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This palette allows the user to set preset colors that can be referred to by
 * index. The user can also change the pen color to one of these preset colors.
 * 
 * @author Daniel
 */

public class Palette extends Stage {
	private List<Color> myColors;
	private int numColors;
	private Color myCurrentColor;

	public Palette() {
		myColors = new ArrayList<Color>();
		VBox fullPalette = new VBox();
		ScrollPane colorsPane = new ScrollPane();
		numColors = Integer.parseInt(Constants.DEFAULT_RESOURCE_BUNDLE.getString("numColorsInPalette"));
		for (int i = 0; i < numColors; i++) {
			int currentIndex = i;
			HBox paletteElement = new HBox();
			Color currentColor = Color.web(Constants.DEFAULT_RESOURCE_BUNDLE.getString("colorDelimiter")
					+ (Constants.DEFAULT_RESOURCE_BUNDLE.getString("color" + i)));
			if (Integer.parseInt(Constants.DEFAULT_RESOURCE_BUNDLE.getString("DefaultPenColorNumber")) == i) {
				myCurrentColor = currentColor;
			}
			Rectangle colorBox = new Rectangle(Constants.PALETTE_SIDE_PADDING, Constants.PALETTE_TOP_PADDING,
					Constants.PALETTE_SIZE, Constants.PALETTE_SIZE);
			myColors.add(currentColor);
			colorBox.setFill(currentColor);
			final ColorPicker colorPicker = new ColorPicker();
			colorPicker.setValue(currentColor);
			Label l = new Label(Integer.toString(i));
			Button b = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penColor"));
			colorPicker.setOnAction(event -> {
				colorBox.setFill(colorPicker.getValue());
				myColors.set(currentIndex, (Color) colorBox.getFill());
			});
			b.setOnAction(event -> {
				myCurrentColor = colorPicker.getValue();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText(Constants.DEFAULT_RESOURCE_BUNDLE.getString("onPenColorChange"));

				alert.showAndWait();
			});

			paletteElement.getChildren().addAll(l, colorPicker, colorBox, b);
			fullPalette.getChildren().add(paletteElement);
		}
		colorsPane.setContent(fullPalette);
		Scene s = new Scene(colorsPane);
		this.setScene(s);
	}

	public List<Color> getPaletteList() {
		return myColors;
	}

	public Color getCurrentColor() {
		return myCurrentColor;
	}

}
