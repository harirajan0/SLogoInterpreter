/**
 * 
 */
package turtle;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import resources.Constants;

/**
 * @author harirajan
 */
public class TurtleInfo {	
	
	private double myX;
	private double myY;
	private double myHeading;
	private boolean isPenDown;
	private boolean isVisible;
	private int myPenColorIndex;
		
	public TurtleInfo() {
		myX = Constants.TURTLE_WINDOW_SIZE / 2;
		myY = Constants.TURTLE_WINDOW_SIZE / 2;
		myHeading = 0;
		isPenDown = true;
		isVisible = true;
		myPenColorIndex = 0;
	}
	
	public TurtleInfo(double X, double Y, double heading, boolean penDown, boolean visible, int penColorIndex) {
		myX = X;
		myY = Y;
		myHeading = heading;
		isPenDown = penDown;
		isVisible = visible;
		myPenColorIndex = penColorIndex;
	}
	
	public TurtleInfo(TurtleInfo toCopy) {
		this(toCopy.getX(), toCopy.getY(), toCopy.getHeading(), toCopy.isPenDown(), toCopy.isVisible(), toCopy.getColor());
	}
	
	public double getX() {
		return myX;
	}
	public double getY() {
		return myY;
	}
	public double getHeading() {
		return myHeading;
	}
	public boolean isPenDown() {
		return isPenDown;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setX(double newX) {
		myX = newX;
	}
	public void setY(double newY) {
		myY = newY;
	}
	
	public void setHeading(double newHeading) {
		if (newHeading >= 0) {
			myHeading = newHeading % 360;
		} else {
			myHeading = 360 + newHeading;
		}
	}
	public void setPenDown(boolean newPenDown) {
		isPenDown = newPenDown;
	}
	public void setVisible(boolean newVisible) {
		isVisible = newVisible;
	}
	
	public void setColor(int index) {
		myPenColorIndex = index;
	}
	
	
	public int getColor() {
		return myPenColorIndex;
	}
	
	public String toString() {
		return String.format("X: %f; Y: %f, Heading: %f; penDown: %b; visible: %b", myX, myY, myHeading, isPenDown, isVisible);
	}
}