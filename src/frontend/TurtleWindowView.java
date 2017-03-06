/**
 * 
 */
package frontend;

import java.util.ArrayList;
import java.util.List;

import backend.TurtleInfo;
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

/**
 * @author harirajan
 *
 */
public class TurtleWindowView {

	private Group myRoot;
	private Rectangle myRectangle;
	
	private List<TurtleView> myTurtles;
//	private TurtleView myTurtle;


	public TurtleWindowView() {
		myRoot = new Group();
		myRectangle = new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE,
				Constants.TURTLE_WINDOW_COLOR);
		myRoot.getChildren().add(myRectangle);
		myTurtles = new ArrayList<>();
		TurtleView firstTurtle = new TurtleView();
		myTurtles.add(firstTurtle);
		firstTurtle.setUpDisplay();
		myRoot.getChildren().add(firstTurtle.getNode());
	}
	
	private void displayTurtles() {
//		myTurtles = new ArrayList<>();
//		myTurtles.add(myTurtle);
		for (TurtleView turtle : myTurtles) {
			myRoot.getChildren().remove(turtle.getNode());
			for (Line l : turtle.getLinesToDraw()) {
//				System.out.println(l);
				myRoot.getChildren().add(l);
			}
			turtle.getTurtleModel().prepareForNextCommand();
			turtle.setUpDisplay();
			myRoot.getChildren().add(turtle.getNode());
		}
	}
	
	public Group getNode() {
		return myRoot;
	}

//	public void updateTurtlePosition(TurtleInfo newTurtleInfo) {
//		nextTurtleInfo = new TurtleInfo(newTurtleInfo);
//		System.out.println(currentTurtleInfo);
//		System.out.println(newTurtleInfo);
//		moveTurtle();
//		myTurtle.setVisible(nextTurtleInfo.isVisible());
//		currentTurtleInfo = new TurtleInfo(nextTurtleInfo);
//		nextTurtleInfo = null;
//	}
//
//
//	private void moveTurtle() {
////		if (nextTurtleInfo.getX() >= 0 && nextTurtleInfo.getX() <= Constants.TURTLE_WINDOW_SIZE) {
////			myTurtle.setX(nextTurtleInfo.getX());
////		} else {
////			myTurtle.setX(nextTurtleInfo.getX() % Constants.TURTLE_WINDOW_SIZE);
////			if (myTurtle.getX() < 0) myTurtle.setX(myTurtle.getX() + Constants.TURTLE_WINDOW_SIZE);
////		}
////		if (nextTurtleInfo.getY() >= 0 && nextTurtleInfo.getY() <= Constants.TURTLE_WINDOW_SIZE) {
////			myTurtle.setY(nextTurtleInfo.getY());
////		} else {
////			myTurtle.setY(nextTurtleInfo.getY() % Constants.TURTLE_WINDOW_SIZE);
////			if (myTurtle.getY() < 0) myTurtle.setY(myTurtle.getY() + Constants.TURTLE_WINDOW_SIZE);
////		}
//		if (nextTurtleInfo.isPenDown()) {
//			practiceDrawLine();
//		}
//		myTurtle.setX(nextTurtleInfo.getX());
//		myTurtle.setY(nextTurtleInfo.getY());
//		myTurtle.setRotate(nextTurtleInfo.getHeading());
//	}
//
//	private void drawLine() {
//		Line line = new Line(currentTurtleInfo.getX() + Constants.BUFFER, currentTurtleInfo.getY() + Constants.BUFFER,
//				nextTurtleInfo.getX() + Constants.BUFFER, nextTurtleInfo.getY() + Constants.BUFFER);
//		line.setFill(currentTurtleInfo.getColor());
//		myRoot.getChildren().add(line);
//	}
//
//	private void practiceDrawLine() {
//	}
//
//
//	private void wrap(boolean isOutOfBounds) {
//		if (isOutOfBounds) {
//			// currentCoords = currentCoords.wrap();
//			double slope = calculateSlope();
//			drawSlope(slope);
//
//		}
//	}
//
//	private double calculateSlope() {
//		double slope = (currentTurtleInfo.getY() - currentTurtleInfo.getY())
//				/ (nextTurtleInfo.getX() - nextTurtleInfo.getX());
//		return slope;
//	}
//
//	private void drawSlope(double slope) {
//
//	}
//
//	private boolean checkIfOutOfBounds() {
//		return (currentTurtleInfo.getX() < 0 || currentTurtleInfo.getX() > 100 || currentTurtleInfo.getY() < 0
//				|| currentTurtleInfo.getY() > 100);
//	}
//
	public TurtleInfo getTurtleInfo() {
		return myTurtles.get(0).getTurtleInfo(); //FIXTHIS!!!!!!!! this wont work when we have multiple turtles
	}
	
	public void updateTurtle(TurtleInfo turtleInfo) {
		for (TurtleView turtle : myTurtles) turtle.setNext(turtleInfo);
		displayTurtles();
	}

}
