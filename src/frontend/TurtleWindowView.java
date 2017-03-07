/**
 * 
 */
package frontend;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import turtle.Turtle;
import turtle.TurtleInfo;
import turtle.TurtleView;

/**
 * @author harirajan
 *
 */
public class TurtleWindowView {

	private Group myRoot;
	private Rectangle myRectangle;
	
	private List<Turtle> myTurtles;
//	private TurtleView myTurtle;


	public TurtleWindowView() {
		myRoot = new Group();
		myRectangle = new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE,
				Constants.TURTLE_WINDOW_COLOR);
		myRoot.getChildren().add(myRectangle);
		myTurtles = new ArrayList<>();
		Turtle firstTurtle = new Turtle();
		myTurtles.add(firstTurtle);
		firstTurtle.setUpDisplay();
		myRoot.getChildren().add(firstTurtle.getNode());
	}
	
	private void displayTurtles() {
//		myTurtles = new ArrayList<>();
//		myTurtles.add(myTurtle);
		for (Turtle turtle : myTurtles) {
			myRoot.getChildren().remove(turtle.getNode());
			for (Line l : turtle.getLinesToDraw()) {
//				System.out.println(l);
				myRoot.getChildren().add(l);
			}
			turtle.prepareForNextCommand();
			turtle.setUpDisplay();
			myRoot.getChildren().add(turtle.getNode());
		}
	}
	
	public Group getNode() {
		return myRoot;
	}

	public TurtleInfo getTurtleInfo() {
		return myTurtles.get(0).getTurtleInfo(); //FIXTHIS!!!!!!!! this wont work when we have multiple turtles
	}
	
	public void updateTurtle(List<Turtle> newTurtles) {
		for (int i = 0; i < myTurtles.size(); i++ ) {
			myTurtles.get(i).setNext(newTurtles.get(i).getTurtleInfo());
		}
		displayTurtles();
	}

}
