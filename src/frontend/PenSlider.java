package frontend;
import constants.Constants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class PenSlider extends Stage{
	private Slider mySlider;
	public PenSlider(){
	this.setTitle(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penThickness"));
    this.setResizable(false);
    BorderPane borderPaneOptionPane = new BorderPane();
    mySlider = new Slider();
    mySlider.setMin(0);
    
    // The maximum value.
    mySlider.setMax(40);
     
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
    
    // The minimum value.
	}
public Slider getSlider(){
	return mySlider;
}
}