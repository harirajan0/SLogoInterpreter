package View;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class TurtleView {
	
	public static final int SIZE = 300;

	public static final String TURTLE_IMAGE = "turtle.png";
	
	private ImageView turtleImage;
	private Point currentCoords;
	private Point nextCoords;
	private int myRotation;
	private boolean penDown;
	private boolean isVisible;
	private Group myRoot;
	
	public TurtleView(Point initialPoint, Group root){
		currentCoords = initialPoint;
		myRotation = 0;
		penDown = false;
		myRoot = root;
		initializeTurtle(myRoot);
	}
	
	public void updateTurtle(Command myCommand){
		Point newPoint = new Point(myCommand.getX(), myCommand.getY());
		
		updatePen(myCommand.getPenStatus());
		updateVisibility(myCommand.getVisibility());
		setTurtleLocation(newPoint);
		setTurtleRotation(myCommand.getRotate());
	}
	
	private void setTurtleLocation(Point newPoint){
		nextCoords = newPoint;
		turtleImage.setX(newPoint.getX());
		turtleImage.setY(newPoint.getY());
		if(penDown){
			drawLine(myRoot);
		}
		currentCoords = nextCoords;
		nextCoords = null;
	}
	
	private void setTurtleRotation(int newRotation){
		myRotation = newRotation;
	}
	
	private void updatePen(boolean penStatus){
		penDown = penStatus;
	}
	
	private void updateVisibility(boolean visibilityStatus){
		isVisible = visibilityStatus;
		if(!isVisible){
			turtleImage.setVisible(false);
		}
		else{
			turtleImage.setVisible(true);
		}
	}
	
	private void drawLine(Group root){
		int oldX = currentCoords.getX();
		int oldY = currentCoords.getY();
		int currentX = nextCoords.getX();
		int currentY = nextCoords.getY();
		Line lineToDraw = new Line(oldX, oldY, currentX, currentY);
		root.getChildren().add(lineToDraw);
	}
	
	
	
	private void initializeTurtle(Group root){
		int startingX = currentCoords.getX();
		int startingY = currentCoords.getY();
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
        turtleImage = new ImageView(image);
        turtleImage.setFitHeight(100);
        turtleImage.setFitWidth(100);
        turtleImage.setX(startingX);
        turtleImage.setY(startingY);
        turtleImage.setRotate(myRotation);
        root.getChildren().add(turtleImage);
	}
	
}
