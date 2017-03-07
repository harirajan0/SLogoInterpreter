package turtle;
import java.util.List;

import constants.Constants;
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
		
	public Turtle() {
		this(new TurtleModel(), new TurtleView());
	}
	
	public Turtle(TurtleModel turtleModel, TurtleView turtleView) {
		myTurtleModel = turtleModel;
		myTurtleView = turtleView;
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
		return myTurtleModel.getTurtleInfo();
	}
	
	public void prepareForNextCommand() {
		myTurtleModel.prepareForNextCommand();
	}
	
	public ImageView getNode() {
		return myTurtleView.getNode();
	}
	
	public void setUpDisplay() {
		myTurtleView.setUpDisplay(myTurtleModel.getX(), myTurtleModel.getY(), myTurtleModel.getHeading());
	}

	
}
