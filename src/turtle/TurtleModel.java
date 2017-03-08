/**
 * 
 */
package turtle;

import constants.Constants;
import javafx.scene.shape.Line;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author harirajan
 *
 */
public class TurtleModel {

	private TurtleInfo currentTurtleInfo;
	private TurtleInfo nextTurtleInfo;
	
	public TurtleModel(TurtleInfo turtleInfo) {
		currentTurtleInfo = turtleInfo;
		nextTurtleInfo = turtleInfo;
	}
	
	public List<Line> calculateLinesToDraw() {
		List<Line> linesToDraw = new ArrayList<>();
		if (nextTurtleInfo == null) return linesToDraw;
		Line top = new Line(0, 0, Constants.TURTLE_WINDOW_SIZE, 0);
		Line bottom = new Line(0, Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE);
		Line left = new Line(0, 0, 0, Constants.TURTLE_WINDOW_SIZE);
		Line right = new Line(Constants.TURTLE_WINDOW_SIZE, 0, Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE);
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
			} else if (Line2D.linesIntersect(
					lineToDraw.getStartX(), lineToDraw.getStartY(), lineToDraw.getEndX(), lineToDraw.getEndY(), 
					top.getStartX(), top.getStartY(), top.getEndX(), top.getEndY()) 
					&& currentTurtleInfo.getY() != 0) {
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
				System.out.println("right");
				endX = Constants.TURTLE_WINDOW_SIZE;
				nextX = 0;
				endY = currentTurtleInfo.getY() - 
						((Constants.TURTLE_WINDOW_SIZE - currentTurtleInfo.getX()) / 
						Math.tan(Math.toRadians(currentTurtleInfo.getHeading())));
				nextY = endY;
				nextTurtleInfo.setX(nextTurtleInfo.getX() - Constants.TURTLE_WINDOW_SIZE);
			}  else { break; }
			Line line = new Line(currentTurtleInfo.getX(), currentTurtleInfo.getY(), endX, endY);
			line.setFill(nextTurtleInfo.getColor());
			linesToDraw.add(line);
			currentTurtleInfo.setX(nextX);
			currentTurtleInfo.setY(nextY);
		}
		Line line = new Line(currentTurtleInfo.getX(), currentTurtleInfo.getY(),
				nextTurtleInfo.getX(), nextTurtleInfo.getY());
		line.setFill(currentTurtleInfo.getColor());
		linesToDraw.add(line);
		return linesToDraw;
	}
	
	private boolean turtleInBounds() {
		return 	nextTurtleInfo.getX() >= 0 &&
				nextTurtleInfo.getX() <= Constants.TURTLE_WINDOW_SIZE &&
				nextTurtleInfo.getY() >= 0 &&
				nextTurtleInfo.getY() <= Constants.TURTLE_WINDOW_SIZE;			
	}
	
	public TurtleInfo getCurrentTurtleInfo() {
		return currentTurtleInfo;
	}
	
	public TurtleInfo getNextTurtleInfo() {
		return nextTurtleInfo;
	}
	
	public void setNext(TurtleInfo turtleInfo) {
		nextTurtleInfo = new TurtleInfo(turtleInfo);
	}
	
	public void prepareForNextCommand() {
		currentTurtleInfo = new TurtleInfo(nextTurtleInfo);
//		nextTurtleInfo = null;
	}


}
