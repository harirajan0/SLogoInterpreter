/**
 * 
 */
package screenElements;

import java.util.List;
import constants.Constants;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import turtle.Turtle;

/**
 * @author harirajan
 * @author Daniel
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
		for (Turtle turtle : myTurtles) turtle.display();
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

	
	public void updateTurtle(List<Turtle> newTurtles) {
		for (int i = 0; i < myTurtles.size(); i++ ) {
			myTurtles.get(i).setNext(newTurtles.get(i).getTurtleInfo());
		}
		displayTurtles();
	}
	
	public void changeBackgroundColor(Paint color) {
		myRectangle.setFill(color);
	}
	
	public Rectangle getBackgroundRectangle(){
		return myRectangle;
	}
	

}
