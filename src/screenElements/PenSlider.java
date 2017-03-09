package screenElements;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Daniel
 */

public class PenSlider extends Stage {
	private Slider mySlider;

	public PenSlider() {
		this.setTitle(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penThickness"));
		this.setResizable(false);
		BorderPane borderPaneOptionPane = new BorderPane();
		mySlider = new Slider();
		mySlider.setMin(Constants.MIN_SLIDER_VALUE);

		// The maximum value.
		mySlider.setMax(Constants.MAX_SLIDER_VALUE);

		// Current value
		mySlider.setValue(Double.parseDouble(Constants.DEFAULT_RESOURCE_BUNDLE.getString("defaultPenThickness")));

		mySlider.setShowTickLabels(true);
		mySlider.setShowTickMarks(true);

		mySlider.setBlockIncrement(2);
		borderPaneOptionPane.setTop(new Label(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penThickness")));
		borderPaneOptionPane.setCenter(mySlider);
		borderPaneOptionPane.setPadding(new Insets(5));
		Scene s = new Scene(borderPaneOptionPane);
		this.setScene(s);
		this.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
	}

	public Slider getSlider() {
		return mySlider;
	}
}