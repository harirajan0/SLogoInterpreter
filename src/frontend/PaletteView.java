/**
 * 
 */
package frontend;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import constants.Constants;

/**
 * @author harirajan
 * @author Daniel
 * @author Belal
 * 
 * This class contains a palette of colors that the user
 * can change and refer to by indexes.
 *
 */
public class PaletteView {
	VBox myVBox;
	List<ColorPicker> myPickers;
	
	@SuppressWarnings("serial")
	protected PaletteView() {
		/** generate the palette view with
		 * the initial color values determined by
		 * info specified in constants
		 */
		myVBox = new VBox();
		myVBox.setAlignment(Pos.CENTER);
		myPickers = new ArrayList<ColorPicker>() {{
			for (int i = 0; i < Constants.DEFAULT_PALLETE_COLORS.size(); i++)
				add(new ColorPicker(Constants.DEFAULT_PALLETE_COLORS.get(i)));
		}};
		Text title = new Text(Constants.TURTLE_VIEW_OPTIONS_TITLE);
		title.setFont(new Font(Constants.DEFAULT_FONT, 20));
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
	
	protected Node getNode() {
		/** get the initialized palette */
		return myVBox;
	}
	

	protected List<ColorPicker> getColorPickers() {
		/** get the list of color pickers
		 * (each color in the palette has its color picker,
		 * from which the value of the currently extracted color can
		 * be gotten)
		 *  */
		return myPickers;
	}

}
