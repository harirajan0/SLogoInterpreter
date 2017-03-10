package screenElements;

import com.sun.javafx.geom.Rectangle;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BackgroundColorChanger extends ColorChanger<TurtleWindowView>{
	/**
	 * @author Daniel
	 */
	
	public void ColorChangeAction(Color selectedColor, TurtleWindowView thingToBeChanged) {
		thingToBeChanged.changeBackgroundColor(selectedColor);
	}

}
