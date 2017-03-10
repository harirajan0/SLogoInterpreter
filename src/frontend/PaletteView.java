/**
 * 
 */
package frontend;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author harirajan
 *
 */
public class PaletteView {
	
	VBox myVBox;
	List<ColorPicker> myPickers;
	
	@SuppressWarnings("serial")
	public PaletteView() {
		myVBox = new VBox();
		myVBox.setAlignment(Pos.CENTER);
		myPickers = new ArrayList<ColorPicker>() {{
			for (int i = 0; i < Constants.DEFAULT_PALLETE_COLORS.size(); i++)
				add(new ColorPicker(Constants.DEFAULT_PALLETE_COLORS.get(i)));
		}};
		Text title = new Text("Your Palette");
		title.setFont(new Font("Verdana", 20));
		myVBox.getChildren().add(title);
		for (int i = 0; i < myPickers.size(); i++) {
			myPickers.get(i).setPrefWidth(200);
			myVBox.getChildren().add(setUpColorPickerNode(i));
		}
	}
	
	private HBox setUpColorPickerNode(int index) {
		HBox hb = new HBox();
		hb.getChildren().addAll(new Label(String.valueOf(index)), myPickers.get(index));
		return hb;
	}
	
	public Node getNode() {
		return myVBox;
	}
	
	public Color getColorAtIndex(int index) {
		return myPickers.get(index).getValue();
	}
	
	@SuppressWarnings("serial")
	public List<Color> getColors() {
		return new ArrayList<Color>() {{
			for (ColorPicker picker : myPickers) add(picker.getValue());
		}};
	}
	
	public List<ColorPicker> getColorPickers() {
		return myPickers;
	}

}
