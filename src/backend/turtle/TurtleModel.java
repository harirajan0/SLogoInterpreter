// This entire file is part of my masterpiece.
// HARI RAJAN

/**
 * 
 */
package backend.turtle;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import constants.Constants;

/**
 * @author harirajan
 *
 * This class contains instances of TurtleInfo and contains some basic information about the Turtle, but its
 * implementation is mostly hidden to the rest of the program
 */
public class TurtleModel {

	private TurtleInfo currentTurtleInfo;
	private TurtleInfo nextTurtleInfo;
	
	private Color myPenColor;
	private double myPenThickness;
	private boolean isSelected;
	
	protected TurtleModel(TurtleInfo turtleInfo) {
		currentTurtleInfo = turtleInfo;
		nextTurtleInfo = turtleInfo;
		isSelected = false;
		myPenThickness = 1;
		myPenColor = Color.BLACK;
	}
	
	protected List<Line> getLinesToDraw() {
		List<Line> linesToDraw = new ArrayList<>();
		if (nextTurtleInfo == null) return linesToDraw;
		while (!turtleInBounds()) {
			double endX = 0;
			double endY = 0;
			Line lineToDraw = new Line(currentTurtleInfo.getX(), currentTurtleInfo.getY(),
					nextTurtleInfo.getX(), nextTurtleInfo.getY());
			if (lineToDraw.contains(0, 0)) {
				currentTurtleInfo.setCoordinates(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE, nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(0, Constants.TURTLE_WINDOW_SIZE)) {
				endY = Constants.TURTLE_WINDOW_SIZE;
				currentTurtleInfo.setX(Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE, nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE)) {
				endY = Constants.TURTLE_WINDOW_SIZE;
				endX = Constants.TURTLE_WINDOW_SIZE;
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE, nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(Constants.TURTLE_WINDOW_SIZE, 0)) {
				currentTurtleInfo.setY(Constants.TURTLE_WINDOW_SIZE);
				endX = Constants.TURTLE_WINDOW_SIZE;
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE, nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
			}  else break;
			addLine(linesToDraw, currentTurtleInfo.getX(), currentTurtleInfo.getY(), endX, endY);
		}
		addLine(linesToDraw, currentTurtleInfo.getX(), currentTurtleInfo.getY(), nextTurtleInfo.getX(), nextTurtleInfo.getY());
		return linesToDraw;
	}
	
	private void addLine(List<Line> lines, double startX, double startY, double endX, double endY) {
		Line line = new Line(startX, startY, endX, endY);
		line.setStroke(myPenColor);
		line.setStrokeWidth(myPenThickness);
		lines.add(line);
	}
	private boolean turtleInBounds() {
		return 	nextTurtleInfo.getX() >= 0 &&
				nextTurtleInfo.getX() <= Constants.TURTLE_WINDOW_SIZE &&
				nextTurtleInfo.getY() >= 0 &&
				nextTurtleInfo.getY() <= Constants.TURTLE_WINDOW_SIZE;			
	}
	
	protected TurtleInfo getCurrentTurtleInfo() {
		return currentTurtleInfo;
	}
	
	protected TurtleInfo getNextTurtleInfo() {
		return nextTurtleInfo;
	}
	
	protected void prepareForNextCommand() {
		currentTurtleInfo = new TurtleInfo(nextTurtleInfo);
	}

	protected boolean isSelected() {
		return isSelected;
	}
	
	protected void setSelected(boolean selected) {
		isSelected = selected;
	}
	
	protected Color getPenColor() {
		return myPenColor;
	}
	
	protected void setPenColor(int index, Color newColor) {
		currentTurtleInfo.setColor(index);
		nextTurtleInfo.setColor(index);
		setPenColor(newColor);
	}
	
	protected void setPenColor(Color newColor) {
		myPenColor = newColor;
	}
	
	protected void setPenWidth(double newVal) {
		myPenThickness = newVal;
	}

	protected int getColorIndex() {
		return currentTurtleInfo.getColor();
	}
	
	protected boolean getPenDown() {
		return currentTurtleInfo.isPenDown();
	}
}
