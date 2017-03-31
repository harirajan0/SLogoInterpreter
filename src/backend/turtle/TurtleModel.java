// This entire file is part of my masterpiece.
// HARI RAJAN

/**
 * 
 */
package backend.turtle;

import java.awt.geom.Line2D;
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
			double endX = 0, endY = 0, nextX = 0, nextY = 0;
			Line lineToDraw = new Line(currentTurtleInfo.getX(), currentTurtleInfo.getY(), nextTurtleInfo.getX(), nextTurtleInfo.getY());
			if (lineToDraw.contains(Constants.TOP_LEFT) || lineToDraw.contains(Constants.TOP_RIGHT)) nextX = Constants.TURTLE_WINDOW_SIZE;
			else if (lineToDraw.contains(Constants.TOP_RIGHT) || lineToDraw.contains(Constants.BOTTOM_RIGHT)) endY = Constants.TURTLE_WINDOW_SIZE;
			else if(lineToDraw.contains(Constants.TOP_LEFT) || lineToDraw.contains(Constants.BOTTOM_LEFT)) nextY = Constants.TURTLE_WINDOW_SIZE;
			else if (lineToDraw.contains(Constants.BOTTOM_LEFT) || lineToDraw.contains(Constants.BOTTOM_RIGHT)) endX = Constants.TURTLE_WINDOW_SIZE;
			if (lineToDraw.contains(Constants.TOP_LEFT)) {
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE, nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(Constants.TOP_RIGHT)) {
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE,nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(Constants.BOTTOM_RIGHT)) {
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE,nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(Constants.BOTTOM_LEFT)) {
				nextTurtleInfo.setCoordinates(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE,nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
			} else if (linesIntersect(lineToDraw, Constants.WINDOW_TOP)) {
				nextY = Constants.TURTLE_WINDOW_SIZE;
				endX = currentTurtleInfo.getX() + (currentTurtleInfo.getY() * Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));
				nextTurtleInfo.setY(nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
			} else if (linesIntersect(lineToDraw, Constants.WINDOW_BOTTOM)) {
				endY = Constants.TURTLE_WINDOW_SIZE;
				endX = currentTurtleInfo.getX() - ((Constants.TURTLE_WINDOW_SIZE - currentTurtleInfo.getY()) * Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));
				nextTurtleInfo.setY(nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
			} else if (linesIntersect(lineToDraw, Constants.WINDOW_LEFT)) {
				nextX = Constants.TURTLE_WINDOW_SIZE;
				endY = currentTurtleInfo.getY() + (currentTurtleInfo.getX()	/ Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));	
				nextTurtleInfo.setX(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE);
			} else if (linesIntersect(lineToDraw, Constants.WINDOW_RIGHT)) {
				endX = Constants.TURTLE_WINDOW_SIZE;
				endY = currentTurtleInfo.getY() - ((Constants.TURTLE_WINDOW_SIZE - currentTurtleInfo.getX()) / Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));
				nextTurtleInfo.setX(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE);
			}  else { break; }
			if (linesIntersect(lineToDraw, Constants.WINDOW_TOP) || linesIntersect(lineToDraw, Constants.WINDOW_BOTTOM)) nextX = endX;
			else if (linesIntersect(lineToDraw, Constants.WINDOW_RIGHT) || linesIntersect(lineToDraw, Constants.WINDOW_LEFT)) nextY = endY;
			addLine(linesToDraw, currentTurtleInfo.getX(), currentTurtleInfo.getY(), endX, endY);
			currentTurtleInfo.setCoordinates(nextX, nextY);
		}
		addLine(linesToDraw, currentTurtleInfo.getX(), currentTurtleInfo.getY(), nextTurtleInfo.getX(), nextTurtleInfo.getY());
		return linesToDraw;
	}
	
	private boolean linesIntersect(Line l1, Line l2) {
		return Line2D.linesIntersect(l1.getStartX(), l1.getStartY(), l1.getEndX(), l1.getEndY(), 
				l2.getStartX(), l2.getStartY(), l2.getEndX(), l2.getEndY());
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
