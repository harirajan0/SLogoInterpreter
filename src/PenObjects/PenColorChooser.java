package PenObjects;

import java.beans.EventHandler;

import constants.Constants;
import frontend.Pen;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PenColorChooser extends Stage{
	public PenColorChooser(){
		super();
		this.setTitle("Pen color");
	    this.setResizable(false);
	    BorderPane borderPaneOptionPane = new BorderPane();
	    final ColorPicker colorPicker = new ColorPicker((Color) Constants.DEFAULT_PENCOLOR);
	    colorPicker.setOnAction(event ->  {
	    	Pen.setColor(colorPicker.getValue());
	    });
	    borderPaneOptionPane.setTop(new Text("Change the pen color:"));
	    borderPaneOptionPane.setCenter(colorPicker);
	    Scene s = new Scene(borderPaneOptionPane);
	    this.setScene(s);
	    this.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
	}
	

}
