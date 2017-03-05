package PenObjects;

import constants.Constants;
import frontend.Pen;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Daniel
 *
 */

public class PenSlider extends Stage{
	public PenSlider(){
	super();
	this.setTitle("Pen width");
    this.setResizable(false);
    BorderPane borderPaneOptionPane = new BorderPane();
    Slider mySlider = new Slider();
    mySlider.setMin(0);
    
    // The maximum value.
    mySlider.setMax(40);
     
    // Current value
    mySlider.setValue(Pen.getWidth());
     
    mySlider.setShowTickLabels(true);
    mySlider.setShowTickMarks(true);
     
    mySlider.setBlockIncrement(2);
    mySlider.valueProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
            Number old_val, Number new_val) {
            Pen.changeWidth(new_val.doubleValue());
        }
    });
    borderPaneOptionPane.setTop(new Label("Select pen width:"));
    borderPaneOptionPane.setCenter(mySlider);
    borderPaneOptionPane.setPadding(new Insets(5));

    Scene s = new Scene(borderPaneOptionPane);
    this.setScene(s);
    this.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
    
    // The minimum value.

	}
}
