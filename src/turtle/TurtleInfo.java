/**
 * 
 */
package turtle;

import constants.Constants;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * @author harirajan
 *
 */
public class TurtleInfo {	
	
	private double myX;
	private double myY;
	private double myHeading;
	private boolean isPenDown;
	private boolean isVisible;
	
	private Color penColor;
		
	public TurtleInfo() {
		myX = Constants.TURTLE_WINDOW_SIZE / 2;
		myY = Constants.TURTLE_WINDOW_SIZE / 2;
		myHeading = 0;
		isPenDown = true;
		isVisible = true;
		penColor = Color.BLACK;
	}
	
	public TurtleInfo(TurtleInfo toCopy) {
		myX = toCopy.getX();
		myY = toCopy.getY();
		myHeading = toCopy.getHeading();
		isPenDown = toCopy.isPenDown();
		isVisible = toCopy.isVisible();
		penColor = toCopy.getColor();
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
	
	public void setColor(Color newColor) {
		penColor = newColor;
	}
	
	public Color getColor() {
		return penColor;
	}
	
	public String toString() {
		return String.format("X: %f; Y: %f, Heading: %f; penDown: %b; visible: %b", myX, myY, myHeading, isPenDown, isVisible);
	}
}