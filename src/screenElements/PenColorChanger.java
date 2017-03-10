package screenElements;

import javafx.scene.paint.Color;
import main.SLogoData;
import turtle.Turtle;

public class PenColorChanger extends ColorChanger<SLogoData> {

	@Override
	public void ColorChangeAction(Color selectedColor, SLogoData thingToBeChanged) {
		thingToBeChanged.setPenColor(selectedColor);
	}

}
