/**
 * 
 */
package View;

import backend.TurtleInfo;
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
//	private ScrollPane myScrollPane;
	private Rectangle myRectangle;
	private ImageView myTurtle;
	
	private TurtleInfo currentTurtleInfo;
	private TurtleInfo nextTurtleInfo;
	
	private Color penColor;

	public TurtleWindowView() {
		myRectangle = new Rectangle(400, 400, Color.WHITE);
		myRoot = new Group();
//		myScrollPane = new ScrollPane();
//		myScrollPane.setPrefSize(400, 400);
//		myScrollPane.setContent(myRectangle);
		myTurtle = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE)));
		myTurtle.setFitWidth(40);
		myTurtle.setFitHeight(40);
//		myScrollPane.setContent(myTurtle);
		myTurtle.setX(200);
		myTurtle.setY(200);
		myRoot.getChildren().addAll(myRectangle, myTurtle);
		
		currentTurtleInfo = new TurtleInfo();
		currentTurtleInfo.setX(200);
		currentTurtleInfo.setY(200);
		penColor = Color.BLACK; //TODO: Add some chooser

	}
	
	public void updateTurtlePosition(TurtleInfo newTurtleInfo) {
		nextTurtleInfo = newTurtleInfo;
		System.out.println(currentTurtleInfo);
		System.out.println(nextTurtleInfo);
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
