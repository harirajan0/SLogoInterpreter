package turtle;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

/**
 * 
 */

/**
 * @author harirajan
 *
 */
public class Turtle {
	
	private TurtleModel myTurtleModel;
	private TurtleView myTurtleView;
	
	private int myID;
	
	public Turtle(Group root, int id) {
		this(root, new TurtleInfo(), id);
	}
	
	public Turtle(Group root, TurtleInfo turtleInfo, int id) {
 		myTurtleModel = new TurtleModel(turtleInfo); 
		myTurtleView = new TurtleView(root);
		myID = id;
	}
	
	public void setNext(TurtleInfo turtleInfo) {
		myTurtleModel.setNext(turtleInfo);
	}
	
	public boolean isSelected() {
		return myTurtleView.isSelected();
	}
	
	public void toggleSelection() {
		myTurtleView.toggleSelection();
	}
	
	public List<Line> getLinesToDraw() {
		return myTurtleModel.calculateLinesToDraw();
	}
	
	public TurtleInfo getTurtleInfo() {
		return myTurtleModel.getCurrentTurtleInfo();
	}
	
	public void prepareForNextCommand() {
		myTurtleModel.prepareForNextCommand();
	}
	
	public ImageView getNode() {
		return myTurtleView.getNode();
	}
	
	public void display() {
		for (Line l : myTurtleModel.calculateLinesToDraw()) {
			myTurtleView.getRoot().getChildren().add(l);
		}
		myTurtleView.display(myTurtleModel.getNextTurtleInfo().getX(), 
							myTurtleModel.getNextTurtleInfo().getY(), 
							myTurtleModel.getNextTurtleInfo().getHeading());
		myTurtleModel.prepareForNextCommand();
	}
	
	public double getX() {
		return myTurtleModel.getCurrentTurtleInfo().getX();
	}
	
	public double getY() {
		return myTurtleModel.getCurrentTurtleInfo().getY();
	}
	
	public double getHeading() {
		return myTurtleModel.getCurrentTurtleInfo().getHeading();
	}
	public boolean isPenDown() {
		return myTurtleModel.getCurrentTurtleInfo().isPenDown();
	}
	
	public boolean isVisible() {
		return myTurtleModel.getCurrentTurtleInfo().isVisible();
	}
	
	public void setX(double newX) {
		myTurtleModel.getNextTurtleInfo().setX(newX);
	}
	
	public void setY(double newY) {
		myTurtleModel.getNextTurtleInfo().setY(newY);
	}
	
	public void setHeading(double newHeading) {
		myTurtleModel.getNextTurtleInfo().setHeading(newHeading);
	}
	public void setPenDown(boolean newPenDown) {
		myTurtleModel.getNextTurtleInfo().setPenDown(newPenDown);
	}
	
	public void setVisible(boolean newVisible) {
		myTurtleModel.getNextTurtleInfo().setVisible(newVisible);
	}


	
}
