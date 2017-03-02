/**
 * 
 */
package frontend;

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
	
	public static final String TURTLE_IMAGE = "turtle.png";
	public static final int TURTLE_SIZE = 50;
	public static final int BUFFER = TURTLE_SIZE/2;

	private Group myRoot;
	private Rectangle myRectangle;
	private ImageView myTurtle;
	
	private TurtleInfo currentTurtleInfo;
	private TurtleInfo nextTurtleInfo;
	
	private Paint penColor;

	public TurtleWindowView() {
		myRoot = new Group();
		setUpTurtleWindowView();
		myRoot.getChildren().addAll(myRectangle, myTurtle);
	}
	
	private void setUpTurtleWindowView() {
		myRectangle = new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_COLOR);
		myTurtle = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
		myTurtle.setFitWidth(Constants.TURTLE_SIZE);
		myTurtle.setFitHeight(Constants.TURTLE_SIZE);
		currentTurtleInfo = new TurtleInfo();
		currentTurtleInfo.setX(Constants.TURTLE_WINDOW_SIZE / 2);
		currentTurtleInfo.setY(Constants.TURTLE_WINDOW_SIZE / 2);
		myTurtle.setX(currentTurtleInfo.getX());
		myTurtle.setY(currentTurtleInfo.getY());
		penColor = Constants.DEFAULT_PENCOLOR; //TODO: Add some chooser
	}
	
	public void updateTurtlePosition(TurtleInfo newTurtleInfo) {
		nextTurtleInfo = newTurtleInfo;
		moveTurtle();
		myTurtle.setVisible(nextTurtleInfo.isVisible());
		currentTurtleInfo = new TurtleInfo(nextTurtleInfo);
		nextTurtleInfo = null;
	}
	
	private void moveTurtle() {
		myTurtle.setX(nextTurtleInfo.getX());
		myTurtle.setY(nextTurtleInfo.getY());
		if (nextTurtleInfo.isPenDown()) {
			drawLine();
		}
		myTurtle.setRotate(nextTurtleInfo.getHeading());
	}
	
	private void drawLine() {
		Line line = new Line(currentTurtleInfo.getX() + BUFFER, currentTurtleInfo.getY() + BUFFER, nextTurtleInfo.getX() + BUFFER, nextTurtleInfo.getY() + BUFFER);
		line.setFill(penColor);
		myRoot.getChildren().add(line);
	}
	
	private void updatePenColor(Color newColor){
		penColor = newColor;
	}
	
	public Group getNode() {
		return myRoot;
	}
	
	
	private void wrap(boolean isOutOfBounds){
		if(isOutOfBounds){
			//currentCoords = currentCoords.wrap();
			double slope = calculateSlope();
			drawSlope(slope);
			
			
		}
	}
	
	private double calculateSlope(){
		double slope = (currentTurtleInfo.getY() - currentTurtleInfo.getY())/(nextTurtleInfo.getX() - nextTurtleInfo.getX());
		return slope;
	}
	
	private void drawSlope(double slope){
		
	}
	
	private boolean checkIfOutOfBounds(){
		return (currentTurtleInfo.getX() < 0 || currentTurtleInfo.getX() > 100 ||
				currentTurtleInfo.getY() < 0 || currentTurtleInfo.getY() > 100);
	}
	
	public TurtleInfo getTurtleInfo() {
		return currentTurtleInfo;
	}
	

}
