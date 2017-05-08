package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.command_abstraction.TurtleCommand;
import backend.commands.Forward;
import backend.commands.Right;
import backend.turtle.Turtle;
import constants.Constants;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import languages.Language;
import languages.LanguageFactory;

/**
 * 
 */

/**
 * @author harirajan
 *
 *This class contains the essential data of the program, namely the list of turtles, list of variables,
 *list of functions, the language, the active colors, and other key information. 
 */
public class SLogoData extends Observable {

	private List<Turtle> myTurtles;
	private List<Variable> myVariables;
	private List<ASTNode> myFunctions;
	private Color myBackgroundColor;
	private int myBackgroundColorIndex;
	private List<Color> myColors;
	private Language myLanguage;
	private Group myRoot;
	private Group myStamps;
	private boolean showSelected;

	/**
	 * 
	 * @param firstTurtle The first turtle to create and add to the program
	 */
	public SLogoData(Turtle firstTurtle) {
		myTurtles = new ArrayList<>(Arrays.asList(firstTurtle));
		myVariables = new ArrayList<>();
		myFunctions = new ArrayList<>();
		myLanguage = LanguageFactory.getLang(Constants.DEFAULT_LANGUAGE);
		myColors = Constants.DEFAULT_PALLETE_COLORS;
		myBackgroundColor = Constants.TURTLE_WINDOW_COLOR;
		showSelected = false;
		myStamps = new Group();
	}
	
	/**
	 * 
	 * @param forwardDistance The distance for which to move the selected turtle
	 * @param headingDiff
	 */
	public void moveSelectedTurtles(double forwardDistance, double headingDiff) {
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				Forward fwd = new Forward();
				Right right = new Right();
				fwd.execute(new ArrayList<>(Arrays.asList(forwardDistance)), turtle);
				right.execute(new ArrayList<>(Arrays.asList(headingDiff)), turtle);
			}
		}
		notifyObservers();
	}

	/**
	 * 
	 * @param cmd The command to execute
	 * @param params The params with which to execute the command
	 * @return The return value of the command and the given parameters
	 */
	public double runCommand(TurtleCommand cmd, List<Double> params) {
		double ret = 0.0;
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				ret = cmd.execute(params, turtle);
				notifyObservers();
			}
		}
		return ret;
	}


	/**
	 * Part of the observable interface
	 */
	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		o.update(this, null);
	}
	
	/**
	 * Part of the observable interface
	 */
	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
	
	protected ASTNode getFunction(String functionName) {
		for (ASTNode func : myFunctions) {
			if (func.getFunctionName().equals(functionName)) {
				return func;
			}
		}
		throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("UndeclaredFunctionError")
				+ functionName);
	}
	
	/**
	 * 
	 * @param newFunction Add a new function to list of current user-defined functions
	 */
	public void addFunction(ASTNode newFunction) {
		for (ASTNode func : myFunctions) {
			if (newFunction.getFunctionName().equals(func.getFunctionName())) {
				myFunctions.remove(func);
				break;
			}
		}
		myFunctions.add(newFunction);
		notifyObservers();
	}

	/**
	 * 
	 * @param col New background color
	 */
	public void changeBackgroundColor(Color col) {
		myBackgroundColor = col;
		notifyObservers();
	}

	protected Variable getVariable(String name) {
		for (Variable var : myVariables) {
			if (var.getName().equals(name))
				return var;
		}
		throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("UninitializedVariableError")
				+ name);
	}

	/**
	 * 
	 * @param newVar A variable to be added to the program's list of variables
	 */
	public void addVariable(Variable newVar) {
		deleteVariable(newVar.getName());
		myVariables.add(newVar);
		notifyObservers();
	}
	
	/**
	 * 
	 * @param varName The name of the variable to delete from the program
	 */
	public void deleteVariable(String varName) {
		for (Variable var : myVariables) { 
			if (varName.equals(var.getName())) {
				myVariables.remove(var);
				break;
			}
		}
		notifyObservers();
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
	public List<Turtle> getTurtles() {
		return myTurtles;
	}
	
	/**
	 * 
	 * @return The numbers of turtles in the program
	 */
	public int getNumTurtles() {
		return myTurtles.size();
	}
	
	/**
	 * 
	 * @return THe list of all variables in the program
	 */
	public List<Variable> getVariables() {
		return myVariables;
	}
	
	/**
	 * 
	 * @param lang The new language to which to set the program
	 */
	public void setLanguage(String lang) {
		myLanguage = LanguageFactory.getLang(lang);
		notifyObservers();
	}
	
	/**
	 * 
	 * @param newVal The desired value of the width of the pen
	 */
	public void setPenWidth(Double newVal){
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) turtle.setPenWidth(newVal);
		}
		notifyObservers();
	}
	
	/**
	 * 
	 * @param index The index of the desired color of the pen
	 */
	public void setPenColor(int index){
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected())  turtle.setPenColor(index, myColors.get(index));
		}
		notifyObservers();
	}
	
	/**
	 * 
	 * @return THe current language of the program
	 */
	public Language getLanguage() {
		return myLanguage;
	}
	
	/**
	 * 
	 * @return THe current color of the program
	 */
	public Color getBackgroundColor() {
		return myBackgroundColor;
	}
	
	/**
	 * 
	 * @param index The index of the new color (between 0 and 3)
	 * @param newColor The new color to be added to the palette with the given index
	 */
	public void changeColor(int index, Color newColor) {
		myColors.set(index, newColor);
		for (Turtle turtle : myTurtles) if (turtle.getColorIndex() == index) turtle.setPenColor(index, newColor);
		notifyObservers();
	}
	
	/**
	 * 
	 * @param showSelected A boolean that determines whether turtles should be distinguished visually depending
	 * on whether they are selected 
	 */
	public void showSelectedGraphically(boolean showSelected) {
		this.showSelected = showSelected;
		for(Turtle turtle : myTurtles) turtle.setShowSelected(showSelected);
		notifyObservers();
	}
	
	/**
	 * 
	 * @param newVars A List og new variables to replace the current variables in the program
	 */
	public void setVariables(List<Variable> newVars) {
		myVariables = newVars;
		notifyObservers();
	}
	
	/**
	 * 
	 * @param index The index of the desired background color
	 */
	public void setBackgroundIndex(int index) {
		myBackgroundColorIndex = index;
		myBackgroundColor = myColors.get(index);
		notifyObservers();
	}
	
	/**
	 * 
	 * @param root The Group to become the root of the JavaFX stage
	 */
	public void setRoot(Group root) {
		myRoot = root;
		notifyObservers();
	}
	
	/**
	 * 
	 * @return The Group that is the current root in Javafx
	 */
	public Group getRoot() {
		return myRoot;
	}
	
	/**
	 * Undraw lines from the screen
	 */
	public void clearScreen() {
		myRoot.getChildren().clear();
		myTurtles.clear();
		myRoot.getChildren().add(new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE,
				Constants.TURTLE_WINDOW_COLOR));
		addTurtle(new Turtle(myRoot, 1));
		notifyObservers();
	}
	
	/**
	 * 
	 * @param img The image to replace the images of the currently selected turtles
	 */ 
	public void changeImage(Image img) {
		for (Turtle turtle : myTurtles) if (turtle.isSelected()) turtle.changeImage(img);
		notifyObservers();
	}
	
	public Group getStamps(){
		return myStamps;
	}
	
	public int addStamp(){
		for(Turtle turtle : myTurtles){
			if(turtle.isSelected()){
				ImageView tNode = turtle.getNode();
				ImageView node = new ImageView();
				node.setImage(tNode.getImage());
				node.setFitWidth(tNode.getFitWidth()); node.setFitHeight(tNode.getFitHeight());
				node.setX(tNode.getX()); node.setY(tNode.getY()); 
				node.setRotate(tNode.getRotate());
				myStamps.getChildren().add(node);
			}
		}
		notifyObservers();
		return myTurtles.get(0).getColorIndex();
	}
	
	public int clearStamps(){
		if(myStamps.getChildren().size() == 0){
			notifyObservers();
			return 0;
		}
		myStamps.getChildren().clear();
		notifyObservers();
		return 1;
	}
}
