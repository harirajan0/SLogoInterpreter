/**
 * 
 */
package frontend;

import backend.TurtleInfo;
import constants.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
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
 * @author Daniel
 * @author Belal Taher
 */
public class TurtleWindowView {

	private Group myRoot;
	private Rectangle myRectangle;
	private ImageView myTurtle;
	
	private TurtleInfo currentTurtleInfo;
	private TurtleInfo nextTurtleInfo;
	
	//private Paint penColor;
	private Pen myPen;

	public TurtleWindowView(Group root) {
		myRoot = root;
		setUpTurtleWindowView();
		myRoot.getChildren().add(myTurtle);
	}
	
	private void setUpTurtleWindowView() {

		myTurtle = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
		myTurtle.setFitWidth(Constants.TURTLE_SIZE);
		myTurtle.setFitHeight(Constants.TURTLE_SIZE);
		currentTurtleInfo = new TurtleInfo();
		currentTurtleInfo.setX((Constants.TURTLE_WINDOW_SIZE / 2) - Constants.BUFFER);
		currentTurtleInfo.setY((Constants.TURTLE_WINDOW_SIZE / 2) - Constants.BUFFER);
		myTurtle.setX(currentTurtleInfo.getX());
		myTurtle.setY(currentTurtleInfo.getY());
		myPen=new Pen();
		//penColor = Constants.DEFAULT_PENCOLOR; //TODO: Add some chooser
	}
	
	public void updateTurtlePosition(TurtleInfo newTurtleInfo) {
		nextTurtleInfo = new TurtleInfo(newTurtleInfo);
		System.out.println(currentTurtleInfo);
		System.out.println(newTurtleInfo);
		moveTurtle();
		myTurtle.setVisible(nextTurtleInfo.isVisible());
		currentTurtleInfo = new TurtleInfo(nextTurtleInfo);
		nextTurtleInfo = null;
	}
	
	private void moveTurtle() {
		myTurtle.setX(nextTurtleInfo.getX());
		myTurtle.setY(nextTurtleInfo.getY());
		myTurtle.setRotate(nextTurtleInfo.getHeading());
		if (nextTurtleInfo.isPenDown()) {
			myRoot.getChildren().addAll(myPen.drawLine(currentTurtleInfo.getX(), currentTurtleInfo.getY(), nextTurtleInfo.getX(), nextTurtleInfo.getY(), nextTurtleInfo.getHeading()));
			//drawLine();
		}
	}
	
//	private void drawLine() {
//		Line line = new Line(currentTurtleInfo.getX() + Constants.BUFFER, currentTurtleInfo.getY() + Constants.BUFFER, 
//				nextTurtleInfo.getX() + Constants.BUFFER, nextTurtleInfo.getY() + Constants.BUFFER);
//		line.setFill(penColor);
//		myRoot.getChildren().add(line);
//	}
//	
//	private void updatePenColor(Color newColor){
//		penColor = newColor;
//	}

	
	public Pen getPen(){
		return myPen;
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
