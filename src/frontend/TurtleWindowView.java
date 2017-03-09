/**
 * 
 */
package frontend;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class TurtleWindowView {

	private Group myRoot;
	private Rectangle myRectangle;
	
	private List<Turtle> myTurtles;


	public TurtleWindowView() {
		myRoot = new Group();
		myRectangle = new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE,
				Constants.TURTLE_WINDOW_COLOR);
		myRoot.getChildren().add(myRectangle);
	}
	
	public void setTurtles(List<Turtle> turtles) {
		myTurtles = turtles;
		for (Turtle turtle : turtles) turtle.display();
	}
	
	public Group getRoot() {
		return myRoot;
	}
	
	public void displayTurtles() {
		for (Turtle turtle : myTurtles) {
			for (Line l : turtle.getLinesToDraw()) {
				myRoot.getChildren().add(l);
			}
		}
	}
	
	public Group getNode() {
		return myRoot;
	}

//	public TurtleInfo getTurtleInfo() {
//		return myTurtles.get(0).getTurtleInfo(); //FIXTHIS!!!!!!!! this wont work when we have multiple turtles
//	}
	
	public void updateTurtle(List<Turtle> newTurtles) {
		for (int i = 0; i < myTurtles.size(); i++ ) {
			myTurtles.get(i).setNext(newTurtles.get(i).getTurtleInfo());
		}
		displayTurtles();
	}
	
	public void changeBackgroundColor(Paint color) {
		myRectangle.setFill(color);
	}
	
	public void setToolTips(){
		ArrayList<Turtle> allTurtles = (ArrayList<Turtle>) myTurtles;
		for(int currTurtle = 0; currTurtle < allTurtles.size(); currTurtle++){
			Tooltip.install(allTurtles.get(currTurtle).getNode(), new Tooltip(allTurtles.get(currTurtle).getTurtleInfo().toString()));
			
		}
	}

	

}
