package frontend;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PenSlider extends Stage{
	public PenSlider(){
	super();
	this.setTitle("Pen width");
    this.setResizable(false);
    BorderPane borderPaneOptionPane = new BorderPane();
    Slider mySlider = new Slider();
    mySlider.setMin(0);
    
    // The maximum value.
    mySlider.setMax(100);
     
    // Current value
    mySlider.setValue(Pen.getWidth());
     
    mySlider.setShowTickLabels(true);
    mySlider.setShowTickMarks(true);
     
    mySlider.setBlockIncrement(2);
    
    borderPaneOptionPane.setCenter(mySlider); // For example

    Button closeButton = new Button("Close");
    closeButton.setOnAction(event -> {
        this.hide();
    });

    borderPaneOptionPane.setPadding(new Insets(5));

    Scene s = new Scene(borderPaneOptionPane);
    this.setScene(s);
	//Label myLabel = new Label("Select pen width:");
    
    // The minimum value.

	}
}
