package View;

import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class TurtleView {

	public static final String TURTLE_IMAGE = "turtle.png";
	public static final int TURTLE_SIZE = 50;
	public static final int BUFFER = TURTLE_SIZE/2;
	
	private ImageView turtleImage;
	private Point2D oldCoords;
	private Point2D currentCoords;
	private Point2D nextCoords;
	private int myRotation;
	private boolean penDown;
	private boolean isVisible;
	private Group myRoot;
	private Rectangle turtleBox;
	private Color penColor;
	
	
	public TurtleView(Point2D initialPoint, Group root){
		currentCoords = initialPoint;
		oldCoords = initialPoint;
		myRotation = 0;
		penDown = true;
		myRoot = root;
		penColor = Color.BLACK; //TODO: Add some chooser
		initializeTurtlePane(myRoot);
		//initializeTurtle(turtleBox);
	}
	
	public void updateTurtle(int x, int y){
		Point2D newPoint = new Point2D(x,y);
		
		//updatePenColor(myCommand.getPenColor());
		//updatePen(myCommand.getPenStatus());
		//updateVisibility(myCommand.getVisibility());
		setTurtleLocation(newPoint);
		//setTurtleRotation(myCommand.getRotate());
		wrap(checkIfOutOfBounds());
	}
	
	private void setTurtleLocation(Point2D newPoint){
		nextCoords = newPoint;
		turtleImage.setX(newPoint.getX());
		turtleImage.setY(newPoint.getY());
		if(penDown){
			drawLine();
		}
		oldCoords = currentCoords; 
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
	
	private void updatePenColor(Color newColor){
		penColor = newColor;
	}
	
	private void drawLine(){
		Point2D oldPoint = currentCoords;
		Point2D newPoint = nextCoords;
		Line lineToDraw=new Line();
		lineToDraw = new Line(oldPoint.getX(), oldPoint.getY(), newPoint.getX() + BUFFER, newPoint.getY() + BUFFER);
		lineToDraw.setFill((Paint) penColor);
		myRoot.getChildren().add(lineToDraw);
	}
	
	
	
	private void initializeTurtle(Pane root){
		double startingX = currentCoords.getX();
		double startingY = currentCoords.getY();
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
        turtleImage = new ImageView(image);
        turtleImage.setFitHeight(TURTLE_SIZE);
        turtleImage.setFitWidth(TURTLE_SIZE);
        turtleImage.setX(startingX);
        turtleImage.setY(startingY);
        turtleImage.setRotate(myRotation);
        root.getChildren().add(turtleImage);
	}
	
	private void wrap(boolean isOutOfBounds){
		if(isOutOfBounds){
			//currentCoords = currentCoords.wrap();
			double slope = calculateSlope(oldCoords, currentCoords);
			drawSlope(slope);
			
			
		}
	}
	
	private double calculateSlope(Point2D oldCoords, Point2D currentCoords){
		double slope = (oldCoords.getY() - currentCoords.getY())/(oldCoords.getX() - currentCoords.getX());
		return slope;
	}
	
	private void drawSlope(double slope){
		
	}
	
	private boolean checkIfOutOfBounds(){
		boolean isOut = false;
		double currentX = currentCoords.getX();
		double currentY = currentCoords.getY();
		if(currentX < 0 || currentX > 100){
			isOut = true;
		}
		if(currentY < 0 || currentY > 100){
			isOut = true;
		}
		return isOut;
	}
	
	private void initializeTurtlePane(Group root){
		turtleBox=new Rectangle(400,400);
		double startingX = currentCoords.getX();
		double startingY = currentCoords.getY();
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
        turtleImage = new ImageView(image);
        turtleImage.setFitHeight(TURTLE_SIZE);
        turtleImage.setFitWidth(TURTLE_SIZE);
        turtleImage.setX(startingX);
        turtleImage.setY(startingY);
        turtleImage.setRotate(myRotation);
        turtleBox.setFill(Color.WHITE);
        turtleBox.setLayoutX(100);
        turtleBox.setLayoutY(100);
		myRoot.getChildren().add(turtleImage);
		root.getChildren().add(turtleBox);
		
	}
	
}
