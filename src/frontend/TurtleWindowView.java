/**
 * 
 */
package frontend;

import java.util.ArrayList;
import java.util.List;

import backend.turtle.Turtle;
import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import constants.Constants;

/**
 * @author harirajan
 * @author Daniel
 *
 *This class displays the turtle(s) on the rectangle.
 *
 *We also implement the tooltips here (which allows us to see
 *the turtle's properties when we hover over it with a mouse).
 *
 */
public class TurtleWindowView {

	private Group myRoot;
	private Rectangle myRectangle;
	
	private List<Turtle> myTurtles;


	protected TurtleWindowView() {
		myRoot = new Group();
		myRectangle = new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE,
				Constants.TURTLE_WINDOW_COLOR);
		myRoot.getChildren().add(myRectangle);
	}
	
	protected void setTurtles(List<Turtle> turtles) {
		myTurtles = turtles;
		for (Turtle turtle : myTurtles) turtle.display();
	}
	
	public Group getRoot() {
		return myRoot;
	}
	
	protected void setToolTips(){
		ArrayList<Turtle> allTurtles = (ArrayList<Turtle>) myTurtles;
		for(int currTurtle = 0; currTurtle < allTurtles.size(); currTurtle++){
			Tooltip.install(allTurtles.get(currTurtle).getNode(), new Tooltip(allTurtles.get(currTurtle).toString()));
			
		}
	}
	
	protected Group getNode() {
		return myRoot;
	}

	
	protected void changeBackgroundColor(Paint color) {
		myRectangle.setFill(color);
	}

}
