// This entire file is part of my masterpiece.
// HARI RAJAN

/**
 * 
 */
package backend.turtle;

import constants.Constants;

/**
 * @author harirajan
 * 
 * This class contains the data about a given turtle, like its coordinates and various states. 
 */
public class TurtleInfo {	
	
	private double myX;
	private double myY;
	private double myHeading;
	private boolean isPenDown;
	private boolean isVisible;
	private int myPenColorIndex;
	
	/**
	 * Instantiates a new TurtleInfo
	 */
	public TurtleInfo() {
		myX = Constants.TURTLE_WINDOW_SIZE / 2;
		myY = Constants.TURTLE_WINDOW_SIZE / 2;
		myHeading = 0;
		isPenDown = true;
		isVisible = true;
		myPenColorIndex = 0;
	}
	
	private TurtleInfo(double X, double Y, double heading, boolean penDown, boolean visible, int penColorIndex) {
		myX = X;
		myY = Y;
		myHeading = heading;
		isPenDown = penDown;
		isVisible = visible;
		myPenColorIndex = penColorIndex;
	}
	
	protected TurtleInfo(TurtleInfo toCopy) {
		this(toCopy.getX(), toCopy.getY(), toCopy.getHeading(), toCopy.isPenDown(), toCopy.isVisible(), toCopy.getColor());
	}
	
	protected double getX() {
		return myX;
	}
	
	protected double getY() {
		return myY;
	}
	
	protected double getHeading() {
		return myHeading;
	}
	
	protected boolean isPenDown() {
		return isPenDown;
	}
	
	protected boolean isVisible() {
		return isVisible;
	}
	
	protected void setX(double newX) {
		myX = newX;
	}
	
	protected void setY(double newY) {
		myY = newY;
	}
	
	protected void setCoordinates(double newX, double newY) {
		myX = newX;
		myY = newY;
	}
	
	protected void setHeading(double newHeading) {
		if (newHeading >= 0) {
			myHeading = newHeading % 360;
		} else {
			myHeading = 360 + newHeading;
		}
	}
	
	protected void setPenDown(boolean newPenDown) {
		isPenDown = newPenDown;
	}
	
	protected void setVisible(boolean newVisible) {
		isVisible = newVisible;
	}
	
	protected void setColor(int index) {
		myPenColorIndex = index;
	}
	
	protected int getColor() {
		return myPenColorIndex;
	}
	
	/**
	 * @return ToolTip information about this turtle
	 */
	public String toString() {
		return String.format("X: %f; Y: %f, Heading: %f; penDown: %b; visible: %b", myX, myY, myHeading, isPenDown, isVisible);
	}
	
}