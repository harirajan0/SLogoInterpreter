/**
 * 
 */
package constants;
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
	public static final int WINDOW_SIZE = 800;
	public static final Paint BACKGROUND_COLOR = Color.GRAY;
	
	//CommandPromptView constants
	public static final int COMMAND_WINDOW_HEIGHT = 200;
	public static final int COMMAND_WINDOW_WIDTH = 600;
	public static final int COMMAND_BUTTON_WIDTH=200;

	
	//TurtleWindow constants
	public static final int TURTLE_WINDOW_SIZE = WINDOW_SIZE / 2;
	public static final Paint TURTLE_WINDOW_COLOR = Color.WHITE;
	
	//TurtleView constants
	public static final String TURTLE_IMAGE = "turtle.png";
	public static final int TURTLE_SIZE = 20;
	public static final int BUFFER = TURTLE_SIZE / 2;
	public static final Paint DEFAULT_PENCOLOR = Color.BLACK;
	
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
}