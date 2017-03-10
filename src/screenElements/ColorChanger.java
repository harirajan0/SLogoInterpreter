package screenElements;

import java.util.Collection;


import constants.Constants;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class ColorChanger<T> extends Stage {
	/**
	 * @author Daniel
	 */	
	
	private BorderPane borderPaneOptionPane;
	private T myThingToChange;
	
	public ColorChanger(){
			this.setTitle(Constants.DEFAULT_RESOURCE_BUNDLE.getString("genericColorLabel"));
		    this.setResizable(false);
		    borderPaneOptionPane = new BorderPane();
//		    final ColorPicker colorPicker = new ColorPicker();
//		    colorPicker.setOnAction(event ->  {
//		    	ColorChangeAction(colorPicker.getValue(), myThingToChange);
//		    });
		    borderPaneOptionPane.setTop(new Text(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penColor")));
		    borderPaneOptionPane.setCenter(colorPickerObject());
		    Scene s = new Scene(borderPaneOptionPane);
		    this.setScene(s);
		    this.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
	 }
	
	public ColorChanger(Palette p){
		p.show();

	}
	
	public Node colorPickerObject(){
		   final ColorPicker colorPicker = new ColorPicker();
		    colorPicker.setOnAction(event ->  {
		    	ColorChangeAction(colorPicker.getValue(), myThingToChange);
		    });
		    return colorPicker;
	}
	
	public void setTitleAndPrompt(String title, String prompt){
		this.setTitle(title);
		borderPaneOptionPane.setTop(new Text(prompt));
	}
	
	public void setObjectToChangeColorOf(T o){
		myThingToChange=o;
	}
	
	public abstract void ColorChangeAction(Color selectedColor, T thingToBeChanged);

}
