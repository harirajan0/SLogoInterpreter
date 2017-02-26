package View;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleView {
	
	public static final int SIZE = 300;

	  public static final String TURTLE_IMAGE = "turtle.png";
	
	private ImageView turtleImage;
	private Point currentCoords;
	private int myRotation;
	private boolean penDown;
	
	public TurtleView(Point initialPoint, Group root){
		currentCoords = initialPoint;
		myRotation = 0;
		penDown = false;
		initializeTurtle(root);
	}
	
	public void updateTurtle(Command myCommand){
		Point newPoint = new Point(myCommand.getX(), myCommand.getY());
		setTurtleLocation(newPoint);
		setTurtleRotation(myCommand.getRotate());
		updatePen(myCommand.getPenStatus());
	}
	
	private void setTurtleLocation(Point newPoint){
		turtleImage.setX(newPoint.getX());
		turtleImage.setY(newPoint.getY());
	}
	
	private void setTurtleRotation(int newRotation){
		myRotation = newRotation;
	}
	
	private void updatePen(boolean penStatus){
		penDown = penStatus;
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
