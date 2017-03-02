/**
 * 
 */
package backend;

import constants.Constants;

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
	
	public TurtleInfo() {
		myX = 0;
		myY = 0;
		myHeading = 0;
		isPenDown = true;
		isVisible = true;
	}
	
	public TurtleInfo(TurtleInfo toCopy) {
		myX = toCopy.getX();
		myY = toCopy.getY();
		myHeading = toCopy.getHeading();
		isPenDown = toCopy.isPenDown();
		isVisible = toCopy.isVisible();
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
		if (newX >= 0 && newX <= Constants.TURTLE_WINDOW_SIZE) {
			myX = newX;
		} else {
			myX = newX % Constants.TURTLE_WINDOW_SIZE;
			if (myX < 0) myX += Constants.TURTLE_WINDOW_SIZE;
		}
	}
	public void setY(double newY) {
		if (newY >= 0 && newY <= Constants.TURTLE_WINDOW_SIZE) {
			System.out.println(newY);
			myY = newY;
		} else {
			myY = newY % Constants.TURTLE_WINDOW_SIZE;
			if (myY < 0) myY += Constants.TURTLE_WINDOW_SIZE;
		}
	}
	public void setHeading(double newHeading) {
		if (newHeading >= 0) {
			myHeading = newHeading % 360;
		} else {
			myHeading = 360 + newHeading;
		}
	}
	public void setPenDown(boolean upOrDown) {
		isPenDown = upOrDown;
	}
	public void setVisible(boolean hiddenOrShown) {
		isVisible = hiddenOrShown;
	}
	
	public String toString() {
		return String.format("X: %f; Y: %f, Heading: %f; penDown: %b; visible: %b", myX, myY, myHeading, isPenDown, isVisible);
	}
}