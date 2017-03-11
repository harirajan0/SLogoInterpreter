* This class is a node of the abstract syntax tree. It contains information about itself (whether it 

 * represents a double value, a variable, or a command) and it also contains a List<ASTNode> of arguments.

 * Subtrees are evaluated recursively from the head node. 

 */

**public class ASTNode** {

	/**

	 * 

	 * @param command The command this node represents (if applicable) 

	 * @param variableName The name of the variable this node represents (if applicable) 

	 * @param functionName The name of the function this node represents (if applicable) 

	 * @param value The double value of this node (if applicable) 

	 * @param arguments The arguments to this node's function (if applicable) 

	 * @param slogoData The data of the program

	 * @param isBlock A boolean representing whether this node represents a "block" (a set of things between brackets)

	 */

	**public ASTNode**(Command command, String variableName, String functionName, double value,

			List<ASTNode> arguments, SLogoData slogoData, boolean isBlock) {

	}

	/**

	 * 

	 * @return The double value of the recrusively calculated value of this node. Returns its own double value

	 * if this node is a double or variable, else evaluates this node's function with its parameters. 

	 */

	**public double evaluate**() {

	}

	/**

	 * 

	 * @return The command this node represents, or null.

	 */

	**public Command getCommand()** {

	}

	

	/**

	 * 

	 * @return A boolean representing whether this node is a block expression

	 */

**	public boolean isBlock(){**

	}

	

	/**

	 * 

	 * @return A boolean representing whether this node represents a variable

	 */

	**public boolean isVariable()**{

	}

	/**

	 * 

	 * @return The name of the variable this node represents (if applicable) 

	 */

	**public String getVariableName()** {

	}

	/**

	 * 

	 * @return A list of this node children, or the arguments to its command (if applicable) 

	 */

	**public List<ASTNode> getArguments()** {

	}

-------------------------------------

 *This class contains the essential data of the program, namely the list of turtles, list of variables,

 *list of functions, the language, the active colors, and other key information. 

 */

**public class SLogoData extends Observable** {

	/**

	 * 

	 * @param firstTurtle The first turtle to create and add to the program

	 */

	**public SLogoData(Turtle firstTurtle)** {

		}

	

	/**

	 * 

	 * @param forwardDistance The distance for which to move the selected turtle

	 * @param headingDiff

	 */

	**public void moveSelectedTurtles(double forwardDistance, double headingDiff) {**	

}

	/**

	 * 

	 * @param cmd The command to execute

	 * @param params The params with which to execute the command

	 * @return The return value of the command and the given parameters

	 */

	**public double runCommand(TurtleCommand cmd, List<Double> params) {**

		}

	/**

	 * Part of the observable interface

	 */

	@Override

	**public void addObserver(Observer o)** {

	}

	

	/**

	 * Part of the observable interface

	 */

	@Override

	**public void notifyObservers()** {

		}

	

/**

	 * 

	 * @param newFunction Add a new function to list of current user-defined functions

	 */

	**public void addFunction(ASTNode newFunction) **{

		}

	**public void changeBackgroundColor(Color col)** {

	

	}

	/**

	 * 

	 * @param newVar A variable to be added to the program's list of variables

	 */

**	public void addVariable(Variable newVar)** 

	}

	

	/**

	 * 

	 * @param varName The name of the variable to delete from the program

	 */

	**public void deleteVariable(String varName)** {

		}

	/**

	 * 

	 * @param turtle The turtle to be added to the program

	 */

	public void addTurtle(Turtle turtle) {

		myTurtles.add(turtle);

		notifyObservers();

	}

	/**

	 * 

	 * @return A List of all turtles in the program

	 * 

	 */

	**public List<Turtle> getTurtles()** {

	}

	

	/**

	 * 

	 * @return The numbers of turtles in the program

	 */

	**public int getNumTurtles()** {

	}

	

	/**

	 * 

	 * @return THe list of all variables in the program

	 */

	p**ublic List<Variable> getVariables() **{

		}

	

	/**

	 * 

	 * @param lang The new language to which to set the program

	 */

	**public void setLanguage(String lang)** {

	}

	

	/**

	 * 

	 * @param newVal The desired value of the width of the pen

	 */

	**public void setPenWidth(Double newVal)**{

	}

	

	/**

	 * 

	 * @param index The index of the desired color of the pen

	 */

	**public void setPenColor(int index)**{

	}

	

	/**

	 * 

	 * @return The current language of the program

	 */

	**public Language getLanguage()** {

	}

	

	/**

	 * 

	 * @return The current color of the program

	 */

	**public Color getBackgroundColor()** {

	}

	

	/**

	 * 

	 * @param index The index of the new color (between 0 and 3)

	 * @param newColor The new color to be added to the palette with the given index

	 */

	**public void changeColor(int index, Color newColor)** {

		}

	

	/**

	 * 

	 * @param showSelected A boolean that determines whether turtles should be distinguished visually depending

	 * on whether they are selected 

	 */

	**public void showSelectedGraphically(boolean showSelected)** {

		}

	

	/**

	 * 

	 * @param newVars A List og new variables to replace the current variables in the program

	 */

	**public void setVariables(List<Variable> newVars)** {

	}

	

	/**

	 * 

	 * @param index The index of the desired background color

	 */

	**public void setBackgroundIndex(int index)** {

	}

	

	/**

	 * 

	 * @param root The Group to become the root of the JavaFX stage

	 */

	**public void setRoot(Group root)** {

	}

	

	/**

	 * 

	 * @return The Group that is the current root in Javafx

	 */

**	public Group getRoot()** {

	}

	

	/**

	 * Undraw lines from the screen

	 */

	**public void clearScreen()** {

	}

	

	/**

	 * 

	 * @param img The image to replace the images of the currently selected turtles

	 */ 

	**public void changeImage(Image img)** {

	}

}

----------------------------

* The main backend class which contains an instance of crucial program data (SlogoData class) and an executor

 * class

 */

**public class SLogoModel implements Observer** {

	

	/**

	 * Instantiate a new SLogoModel. Called once by Controller. 

	 */

	**public SLogoModel() {**

	}

	

	/**

	 * 

	 * @param lang The language in which the parser should parse commands

	 */

	**public void setLanguage(Language lang**) {

	}

	

	@SuppressWarnings("serial")

	**public void parse(String input) {**

	}

	

	/**

	 * Part of the observer interface

	 */

	@Override

**	public void update(Observable slogoData, Object arg)** {

	}

}

-------------------

 * A class encapsulating the idea of a variable, containing its name and value

 *

 */

**public class Variable **{

	

	/**

	 * 

	 * @param name Name of new variable

	 * @param value Value of new variable

	 */

	**public Variable(String name, double value)**{

	}

	

	/**

	 * 

	 * @return The name of this variable

	 */ 

	**public String getName(){**	}

	/**

	 * 

	 * @return The value of this variable

	 */

**	public double getValue(){**

	}

}

-----------------

* This interfaces provides 3 methods that all commands must implement. 

 */

**public interface Command {**

	

	/**

	 * 

	 * @param params Parameters of this command in the form of a List of ASTNodes 

	 * @param slogoData The current information about the program

	 * @return A double value that is the return value of the executed command with the given parameters

	 * @throws IllegalArgumentException If this command does not receive proper parameters

	 */

	**public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException;**

	

	/**

	 * 

	 * @return The minimum number of arguments that this command must receive

	 */

	**public int getMinNumArgs();**

	

	/**

	 * 

	 * @return A boolean that represents whether this command is mathematical or not

	 */

	**public boolean isMathCommand();**

	

}

---------------------

* This class is like a controller for the turtle. It contains a turtle model and turtle view and mediates

 * communication between them. Each Turtle class is responsible for exactly one turtle model and one turtle view.

 *

 */

**public class Turtle** {

	

	/**

	 * 

	 * @param root The group to which to add this Turtle class's TurtleView

	 * @param id The ID of this turtle

	 */

	**public Turtle(Group root, int id) {**

	}

	

	/**

	 * @return Whether this turtle is selected

	 */

	**public boolean isSelected() {**

	}

	

	/**

	 * 

	 * @param selected The desired state of being selected or unselected

	 */

	**public void setSelected(boolean selected) {**

	}

	

	/**

	 * 

	 * @return The TurleInfo of this class's TurtleModel

	 */

**	public TurtleInfo getTurtleInfo() {**

	}

	

	/**

	 * 

	 * @return The node attached to this class's TurtleView

	** */**

**	public ImageView getNode() {**

	}

	

	/**

	 * Adjusts the opacityof this Turtle's TurtleView based on its state of selected or unselected

	 */

	**public void display() 	}**

	

	/**

	 * 

	 * @return The X location of this turtle

	 */

	**public double getX() {**

	}

	

	/**

	 * 

	 * @return The Y location of this turtle

	 */

	**public double getY() {**

	}

	

	/**

	 * 

	 * @return The heading of this turtle

	 */

	**public double getHeading() {**

	}

	

	/**

	 * 

	 * @return Boolean representing whether this turtle's pen is down

	 */

	**public boolean isPenDown() {**

	}

	

	/**

	 * 

	 * @return Boolean representing whether this turtle is visible

	 */	}

**	public boolean isVisible() {**

	

	/**

	 * 

	 * @param The new X location of this turtle

	 */

**	public void setX(double newX) {**

	}

	

	/**

	 * 

	 * @param The new Y location of this turtle

	 */

	**public void setY(double newY) {**

	}

	/**

	 * 

	 * @param The new heading of this turtle

	 */

**	public void setHeading(double newHeading) {**

	}

	

	/**

	 * 

	 * @param The new pen state of this turtle

	 */

**	public void setPenDown(boolean newPenDown) {**

	}

	

	/**

	 * 

	 * @param The new visibility state of this turtle

**	 */**

**	public void setVisible(boolean newVisible) {**

	}

	/**

	 * 

	 * @param The new pen color of this turtle

	 */

**	public void setPenColor(int index, Color newColor) {**

	}

	

	/**

	 * 

	 * @param The new pen width of this turtle

	 */

**	public void setPenWidth(double newVal) {**

	}

	

	/**

	 * 

	 * @return The color index of this turtle

	 */

	**public int getColorIndex() {**

	}

	

	/**

	 * 

	 * @return The ID of this turtle

	 */

**	public int getID() {**

	}

	

	/**

	 * 

	 * @param The new selected state of this turtle

	 */

	**public void setShowSelected(boolean showSelected) {**

	}

	

	/**

	 * 

	 * @param img THe new image of this Turtle class' TurtleView

	 */

**	public void changeImage(Image img) {**

	}

	

	/**

	 * @return Tooltip information about this turtle

	 */

**	public String toString() {**

	}

---------------------

**public class CommandPromptView {**

	/**

	 * We use this class to store everything relating to what is happening in

	 * the command prompt. 

	 * We can type in commands or select a command from the history of commands.

	 * Using this class allows us to separate what is happening in the command prompt

	 * from everything else in the screen.

	 * This class also contains any buttons that allow the user to graphically

	 * perform a command on the turtle (move, rotate, change its appearance..).

	 * 

	 * @author Daniel

	 * 

	 */

**	public void setForwards(EventHandler<ActionEvent> handler) {**

		/** set action to be performed if forward button is clicked */

	}

**	public void setBackwards(EventHandler<ActionEvent> handler) {**

		/** set action to be performed if backwards button is clicked */

	}

	**public void setRotateLeft(EventHandler<ActionEvent> handler) {**

		/** set action to be performed if rotate left button is clicked */

	}

	**public void setRotateRight(EventHandler<ActionEvent> handler) {**

		/** set action to be performed if rotate right button is clicked */

	}

	

	**public void addCommandToHistory(String cmd) {**

		/** add a command to the history of commands */

	}

	**public String getUserInput() {**

		/** get the text that the user inputed in the command line */

	}

	

	**public Button getExecuteButton() {**

		/** get the execute button */

	}

	

	**public BorderPane getNode() {**

		/** get the entire border pane */

	}

	

	**public Button getForwardButton(){**

		/** get the forward button */

	}

	**public Button getBackwardsButton(){**

		/** get the backwards button */

	}

	

**	public Button getRightRotate(){**

		/** get the rotate right button */

	}

	

	**public Button getLeftRotate(){**

		/** get the rotate left button */

	}

	

	

	**public CheckBox getGraphicalDisplayButton(){**

		/** get the button that allows us to toggle whether to display active turtles differently

		 * from non-active ones*/

	}

	

	**public void setCommandPromptText(String text) {**

		/** set a different piece of text inside the command prompt view */

	}

	

	**protected Button getTurtleImageSelectionButton() {**

		/** get the 'load new image file' button */

	}

	

}

	

---------------------

* This class opens up a window that shows details

 * about an exception.

 */

**public class ExceptionAlert {**

	

**	public ExceptionAlert(Exception e){**

	}

	**public void receiveAndDisplayError(Exception e){**

		}

	

}

------------------------------

 *  This class contains all the elements on the screen (we initialize all

 *  screen elements from here).

 *  This class also contains an instance of SLogoData, which holds the

 *  information about the turtles, pen info, etc. Using observers,

 *  we update the display is mySlogoData changes from the backend,

 *  and backend receives updates if information is changed from 

 *  the frontend (ex: if pen color or variable values are changed).

 *  

 */

**public class SLogoView implements Observer {**

	**public SLogoView(Stage s) {**

	}

	

**	public ColorPicker getBackgroundColorPicker() {**

		/** get the background color picker */

	}

**	public CommandPromptView getCommandBox() {**

		/** get the command box */

	}

**	public TurtleWindowView getTurtleWindow() {**

		/** get the turtle window */

	}

**	public Button getExecuteButton() {**

		/** get the execute button */

	}

**	public String getUserInput() {**

		/** get the user's input in the command line as a string */

	}

**	public void addCommandToHistory(String cmd) {**

		/** add string to our command prompt's history */

	}

**	public void clearCommandPrompt() {**

		/** clear the command prompt */

	}

	

**	public ChoiceBox<String> getPenColorChoiceBox() {**

		/** get the pen color chooser */

	}

	

**	public Slider getPenThicknessSlider() {**

		/** get the 'choose pen thickness slider' *

	}

	

	**public List<ColorPicker> getPaletteColorPickers() {**

		/** get the list of color pickers contained in the palette

		 * (the currently selected color can be retrieved within each color picker) */

	}

	

**	public ChoiceBox<String> getLanguageChoiceBox() {**

		/** get the language choice box */

	}

	

**	public CheckBox getGraphicalDisplayButton(){**

		/** get the checkbox which enables us to display selected

		 * turtles differently from non-selected ones */

	}

**	**

**	public boolean getShowSelected() {**

		/** get the boolean value that tells us whether to display selected turtles differently */

	}

	

**	public void toggleShowSelection() {**

		/** change this boolean value that tells us whether to display selected turtles differently

		 * (set true to false and vice-versa) */

	}

**	public Button getVariableUpdateButton() {**

		/** get the button in the variables view that updates variable values with what the user has typed graphically */

	}

	

**	public VariablesView getVariablesView() {**

		/** get our entire variables view */

	}

	

	**public Button getTurtleImageSelectionButton() {**

		/** get the button that allows us to chose a new image for the turtle */

	}

	

	@Override

	**public void update(Observable slogoData, Object arg) {**

		/** 

		 * Using Observable, we make sure that we are always displaying the variables

		 * contained in SLogoData, the turtles contained in SlogoData, and the background

		 * in SLogoData.

		 */

}

}

------------------------

*This class displays the turtle(s) on the rectangle.

 *

 *We also implement the tooltips here (which allows us to see

 *the turtle's properties when we hover over it with a mouse).

 *

 */

**public class TurtleWindowView {**

**	**

**	public Group getRoot() {**

		/** getter for turtlewindow root */

	}

---------------------------

 * This class contains the display of variables.

 * It allows the user to display variables that they can

 * initialize and or modify through the command line. It also

 * allows them to update their values on the screen directly

 * in the display.

 */

**public class VariablesView{**

	

**public void updateVariables() {**

		/** updates variables being displayed and displays new variables if any new ones

		 * have been defined (through the command line) */

       }

    

  **  public List<Variable> getVariables() {**

		/** get a list of the variables */

    }

  }

