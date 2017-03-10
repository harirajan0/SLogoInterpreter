/**
 * 
 */
package constants;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
/**
 * @author harirajan
 * @author Daniel
 * @author Belal Taher
 */
public class Constants {
	//Application constants
	public static final String APPLICATION_TITLE = "SLogo Interpreter";
	public static final String TITLE_FONT = "Courier New";
	public static final int TITLE_FONT_SIZE = 36;
	public static final int WINDOW_SIZE = 825;
	public static final Paint BACKGROUND_COLOR = Color.GRAY;
	public static final String DEFAULT_LANGUAGE = "English";
	
	//CommandPromptView constants
	public static final int COMMAND_WINDOW_HEIGHT = 200;
	public static final int COMMAND_WINDOW_WIDTH = 600;
	public static final int COMMAND_BUTTON_WIDTH = 200;
	public static final int SMALL_BUTTON_SIZE= 32;

	
	//TurtleWindow constants
	public static final int TURTLE_WINDOW_SIZE = WINDOW_SIZE / 2;
	public static final Paint TURTLE_WINDOW_COLOR = Color.WHITE;
	
	//TurtleView constants
	public static final String TURTLE_IMAGE = "turtle.png";
	public static final String LEFT_ROTATE_IMAGE = "left_rotate.png";
	public static final String RIGHT_ROTATE_IMAGE = "right_rotate.png";
	public static final String FORWARD_IMAGE = "forward.png";
	public static final String BACK_IMAGE = "backward.png";
	public static final int TURTLE_SIZE = 20;
	public static final int BUFFER = TURTLE_SIZE / 2;
	public static final Paint DEFAULT_PENCOLOR = Color.BLACK;
	
	//pen width slider constants
	public static final int MIN_SLIDER_VALUE=0;
	public static final int MAX_SLIDER_VALUE=40;
	
	//Button movement values
	public static final int FORWARD_BUTTON_DISTANCE = 10;
	public static final int BACKWARDS_BUTTON_DISTANCE = -FORWARD_BUTTON_DISTANCE;
	public static final int RIGHT_BUTTON_ROTATION = 10;
	public static final int LEFT_BUTTON_ROTATION = -RIGHT_BUTTON_ROTATION;
	
	//True false constants
	public static final double TRUE = 1.0;
	public static final double FALSE = 0.0;
	
	//Resource Bundle constants
	public static final ResourceBundle DEFAULT_RESOURCE_BUNDLE = ResourceBundle.getBundle("myResources/resources");
	public static final ResourceBundle LANGUAGE_RESOURCE_BUNDLE = ResourceBundle.getBundle("myResources/languageNames");

	
	//PaletteView Constants
	public static final int PALETTE_SIDE_PADDING = 50;
	public static final int PALETTE_SIZE = 100;
	public static final int PALETTE_TOP_PADDING = 50;
	
	
	//Palette Picker constants
	public static final String PALETTE_PICKER_NAME = "Pick new colors for the palette";
	public static final int PALETTE_PICKER_SIZE = 400;
	public static final List<Color> DEFAULT_PALLETE_COLORS = new ArrayList<Color>() {{
		add(Color.WHITE);
		add(Color.BLACK);
		add(Color.BLUE);
		add(Color.RED);
	}};
}