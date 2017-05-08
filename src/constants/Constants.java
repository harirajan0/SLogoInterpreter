// This entire file is part of my masterpiece.
// HARI RAJAN

/**
 * 
 */
package constants;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 * 
 * This class contains some program-wide constants that need to be accessed from across the program
 *
 */
public class Constants {
	
	//Application constants
	public static final String APPLICATION_TITLE = "SLogo Interpreter";
	public static final String TITLE_FONT = "Courier New";
	public static final int TITLE_FONT_SIZE = 36;
	public static final int WINDOW_SIZE = 825;
	public static final Paint BACKGROUND_COLOR = Color.GRAY;
	public static final String DEFAULT_LANGUAGE = "English";
	public static final String VARIABLES_VIEW_TITLE = "Your Variables";
	public static final int DEFAULT_FONT_SIZE = 20;
	public static final String DEFAULT_FONT = "Verdana";
	public static final String IMAGE_CHOOSER_TITLE = "Image Chooser";
	public static final String PEN_COLOR_LABEL = "Pen Color: ";
	public static final String PALETTE_COLOR_LABEL = "Palette Color: ";
	public static final String BACKGROUND_COLOR_LABEL = "Background Color: ";
	public static final String POSSIBLE_FUNCTION = "PossibleFunction";
	
	//CommandPromptView constants
	public static final int COMMAND_WINDOW_HEIGHT = 200;
	public static final int COMMAND_WINDOW_WIDTH = 600;
	public static final int BIG_BUTTON_WIDTH = 200;
	public static final int SMALL_BUTTON_SIZE= 32;
	public static final int MEDIUM_BUTTON_SIZE= 50;
	public static final String PREVIOUS_COMMAND_PROMPT="See previous commands";
	
	//TurtleWindow constants
	public static final double LINE_BUFFER = 0.3;
	public static final int TURTLE_WINDOW_SIZE = WINDOW_SIZE / 2;
	public static final Color TURTLE_WINDOW_COLOR = Color.WHITE;
	public static final String TURTLE_SELECTED_TITLE = "Turtle Selected!";
	public static final String TURTLE_UNSELECTED_TITLE = "Turtle Unselected!";
	public static final String TURTLE_SELECTED_MESSAGE = "You chose turtle with ID: ";
	public static final String TURTLE_UNSELECTED_MESSAGE = "You unselected turtle with ID: ";
	public static final Line WINDOW_TOP = new Line(LINE_BUFFER, LINE_BUFFER, TURTLE_WINDOW_SIZE - LINE_BUFFER, LINE_BUFFER);
	public static final Line WINDOW_BOTTOM = new Line(LINE_BUFFER, TURTLE_WINDOW_SIZE - LINE_BUFFER, TURTLE_WINDOW_SIZE - LINE_BUFFER, TURTLE_WINDOW_SIZE - LINE_BUFFER);
	public static final Line WINDOW_LEFT = new Line(LINE_BUFFER, LINE_BUFFER, LINE_BUFFER, TURTLE_WINDOW_SIZE - LINE_BUFFER);
	public static final Line WINDOW_RIGHT = new Line(TURTLE_WINDOW_SIZE - LINE_BUFFER, LINE_BUFFER, TURTLE_WINDOW_SIZE - LINE_BUFFER, TURTLE_WINDOW_SIZE - LINE_BUFFER);
	public static final Point2D TOP_LEFT= new Point2D(0, 0);
	public static final Point2D TOP_RIGHT = new Point2D(TURTLE_WINDOW_SIZE, 0);
	public static final Point2D BOTTOM_LEFT = new Point2D(0, TURTLE_WINDOW_SIZE);
	public static final Point2D BOTTOM_RIGHT = new Point2D(TURTLE_WINDOW_SIZE, TURTLE_WINDOW_SIZE);
	
	//Turtle Image Selector Constants
	public static final int TURTLE_IMAGE_SELECTOR_WINDOW_HEIGHT = 100;
	public static final int TURTLE_IMAGE_SELECTOR_WINDOW_WIDTH = 200;
	public static final String TURTLE_IMAGE_SELECTOR_TITLE = "Turtle Image Selector";
	
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
	public static final int SLIDER_INCREMENT_VALUE = 5;
	public static final int MAX_SLIDER_VALUE = 20;
	
	//Button movement values
	public static final int FORWARD_BUTTON_DISTANCE = 10;
	public static final int BACKWARDS_BUTTON_DISTANCE = -FORWARD_BUTTON_DISTANCE;
	public static final int RIGHT_BUTTON_ROTATION = 10;
	public static final int LEFT_BUTTON_ROTATION = -RIGHT_BUTTON_ROTATION;
	
	//True false constants
	public static final double TRUE = 1.0;
	public static final double FALSE = 0.0;
	
	//Resource Bundle constants
	public static final ResourceBundle DEFAULT_RESOURCE_BUNDLE = ResourceBundle.getBundle("myresources/resources");

	//PaletteView Constants
	public static final String TURTLE_VIEW_OPTIONS_TITLE = "Turtle View Options";
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
	
	//Turtle opacity to show selection constants
	public static final double SELECTED = 1;
	public static final double NOT_SELECTED = SELECTED / 2;
	
	//Error
	public static final String START_ERROR_TITLE = "View Start Error";
	public static final String START_ERROR_HEADER = "Can't open!";
	public static final String START_ERROR_MESSAGE = "Unable to open the selected window";
	
}