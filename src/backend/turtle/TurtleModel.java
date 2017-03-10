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
	
	protected List<Line> calculateLinesToDraw() {
		List<Line> linesToDraw = new ArrayList<>();
		if (nextTurtleInfo == null) return linesToDraw;
		Line top = new Line(0.3, 0.3, Constants.TURTLE_WINDOW_SIZE - 0.3, 0.3);
		Line bottom = new Line(0.3, Constants.TURTLE_WINDOW_SIZE - 0.3, Constants.TURTLE_WINDOW_SIZE - 0.3, Constants.TURTLE_WINDOW_SIZE - 0.3);
		Line left = new Line(0.3, 0.3, 0.3, Constants.TURTLE_WINDOW_SIZE - 0.3);
		Line right = new Line(Constants.TURTLE_WINDOW_SIZE -0.3, 0.3, Constants.TURTLE_WINDOW_SIZE - 0.3, Constants.TURTLE_WINDOW_SIZE - 0.3);
		while (!turtleInBounds()) {
			double endX = 0;
			double endY = 0;
			double nextX = 0;
			double nextY = 0;
			Line lineToDraw = new Line(currentTurtleInfo.getX(), currentTurtleInfo.getY(),
					nextTurtleInfo.getX(), nextTurtleInfo.getY());
			if (lineToDraw.contains(0, 0)) {
				endY = 0;
				nextY = Constants.TURTLE_WINDOW_SIZE;
				endX = 0;
				nextX = Constants.TURTLE_WINDOW_SIZE;
				nextTurtleInfo.setY(nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setX(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(0, Constants.TURTLE_WINDOW_SIZE)) {
				endY = Constants.TURTLE_WINDOW_SIZE;
				nextY = 0;
				endX = 0;
				nextX = Constants.TURTLE_WINDOW_SIZE;
				nextTurtleInfo.setY(nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setX(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE)) {
				endY = Constants.TURTLE_WINDOW_SIZE;
				nextY = 0;
				endX = Constants.TURTLE_WINDOW_SIZE;
				nextX = 0;
				nextTurtleInfo.setY(nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setX(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE);
			} else if (lineToDraw.contains(Constants.TURTLE_WINDOW_SIZE, 0)) {
				endY = 0;
				nextY = Constants.TURTLE_WINDOW_SIZE;
				endX = Constants.TURTLE_WINDOW_SIZE;
				nextX = 0;
				nextTurtleInfo.setY(nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setX(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE);
			} else if (currentTurtleInfo.getX() == 0 && nextTurtleInfo.getX() < 0) {
				currentTurtleInfo.setX(Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setX(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE);
				continue;
			} else if (currentTurtleInfo.getX() == Constants.TURTLE_WINDOW_SIZE && nextTurtleInfo.getX() > Constants.TURTLE_WINDOW_SIZE) {
				currentTurtleInfo.setX(0);
				nextTurtleInfo.setX(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE);
				continue;
			} else if (currentTurtleInfo.getY() == 0 && nextTurtleInfo.getY() < 0) {
				currentTurtleInfo.setY(Constants.TURTLE_WINDOW_SIZE);
				nextTurtleInfo.setY(nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
				continue;
			} else if (currentTurtleInfo.getY() == Constants.TURTLE_WINDOW_SIZE && nextTurtleInfo.getY() > Constants.TURTLE_WINDOW_SIZE) {
				currentTurtleInfo.setY(0);
				nextTurtleInfo.setY(nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
				continue;
			} else if (Line2D.linesIntersect(
					lineToDraw.getStartX(), lineToDraw.getStartY(), lineToDraw.getEndX(), lineToDraw.getEndY(), 
					top.getStartX(), top.getStartY(), top.getEndX(), top.getEndY()) && currentTurtleInfo.getY() != 0) 
			{
				endY = 0;
				nextY = Constants.TURTLE_WINDOW_SIZE;
				endX = currentTurtleInfo.getX() + (currentTurtleInfo.getY()
														* Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));
				nextX = endX;
				nextTurtleInfo.setY(nextTurtleInfo.getY() + Constants.TURTLE_WINDOW_SIZE);
			} else if (Line2D.linesIntersect(
					lineToDraw.getStartX(), lineToDraw.getStartY(), lineToDraw.getEndX(), lineToDraw.getEndY(), 
					bottom.getStartX(), bottom.getStartY(), bottom.getEndX(), bottom.getEndY()) 
					&& currentTurtleInfo.getY() != Constants.TURTLE_WINDOW_SIZE) {
				endY = Constants.TURTLE_WINDOW_SIZE;
				nextY = 0;
				endX = currentTurtleInfo.getX() - ((Constants.TURTLE_WINDOW_SIZE - currentTurtleInfo.getY())
														* Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));
				nextX = endX;
				nextTurtleInfo.setY(nextTurtleInfo.getY() - Constants.TURTLE_WINDOW_SIZE);
			} else if (Line2D.linesIntersect(
					lineToDraw.getStartX(), lineToDraw.getStartY(), lineToDraw.getEndX(), lineToDraw.getEndY(), 
					left.getStartX(), left.getStartY(), left.getEndX(), left.getEndY()) 
					&& currentTurtleInfo.getX() != 0) {
				endX = 0;
				nextX = Constants.TURTLE_WINDOW_SIZE;
				endY = currentTurtleInfo.getY() + (currentTurtleInfo.getX()	/ Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));	
				nextY = endY;
				nextTurtleInfo.setX(nextTurtleInfo.getX() + Constants.TURTLE_WINDOW_SIZE);
			} else if (Line2D.linesIntersect(
					lineToDraw.getStartX(), lineToDraw.getStartY(), lineToDraw.getEndX(), lineToDraw.getEndY(), 
					right.getStartX(), right.getStartY(), right.getEndX(), right.getEndY()) 
					&& currentTurtleInfo.getX() != Constants.TURTLE_WINDOW_SIZE) {
				endX = Constants.TURTLE_WINDOW_SIZE;
				nextX = 0;
				endY = currentTurtleInfo.getY() - 
						((Constants.TURTLE_WINDOW_SIZE - currentTurtleInfo.getX()) / 
						Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));
				nextY = endY;
				nextTurtleInfo.setX(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE);
			}  else { break; }
			Line line = new Line(currentTurtleInfo.getX(), currentTurtleInfo.getY(), endX, endY);
			line.setStroke(myPenColor);
			line.setStrokeWidth(myPenThickness);
			linesToDraw.add(line);
			currentTurtleInfo.setX(nextX);
			currentTurtleInfo.setY(nextY);
		}
		Line line = new Line(currentTurtleInfo.getX(), currentTurtleInfo.getY(),
				nextTurtleInfo.getX(), nextTurtleInfo.getY());
		line.setStroke(myPenColor);
		line.setStrokeWidth(myPenThickness);
		linesToDraw.add(line);
		return linesToDraw;
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
