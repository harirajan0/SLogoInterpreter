package turtle;
import java.util.List;

import constants.Constants;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
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
	
	private boolean showSelected;
	private int myID;
	
	public Turtle(Group root, int id) {
		this(root, new TurtleInfo(), id);
	}
	
	public Turtle(Group root, TurtleInfo turtleInfo, int id) {
 		myTurtleModel = new TurtleModel(turtleInfo); 
		myTurtleView = new TurtleView(root);
		myID = id;
		showSelected = false;
		getNode().setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				myTurtleModel.setSelected(!myTurtleModel.isSelected());
				Alert alert = new Alert(AlertType.CONFIRMATION);
				if (myTurtleModel.isSelected()) {
					alert.setTitle("Turtle Selected!");
					alert.setContentText("You chose turtle with ID: " + myID);
					alert.showAndWait();
				} else {
					alert.setTitle("Turtle Unselected!");
					alert.setContentText("You unselected turtle with ID: " + myID);
					alert.showAndWait();
				}
				display();
			}
		});
	}
	
	public void setNext(TurtleInfo turtleInfo) {
		myTurtleModel.setNext(turtleInfo);
	}
	
	public boolean isSelected() {
		return myTurtleModel.isSelected();
	}
	
	public void setSelected(boolean selected) {
		myTurtleModel.setSelected(selected);
		display();
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
			l.setFill(myTurtleModel.getPenColor());
			myTurtleView.getRoot().getChildren().add(l);
		}
		if(showSelected && !isSelected()) { 
			getNode().setOpacity(Constants.NOT_SELECTED);
		}
		else {
			getNode().setOpacity(Constants.SELECTED);
		}
		System.out.println("hello");
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

	public void setPenColor(int index, Color newColor) {
		myTurtleModel.setPenColor(index, newColor);
	}
	
	public void setPenWidth(double newVal) {
		myTurtleModel.setPenWidth(newVal);
	}
	
	public int getColorIndex() {
		return myTurtleModel.getColorIndex();
	}
	
	public int getID() {
		return myID;
	}
	
	public void setShowSelected(boolean showSelected) {
		this.showSelected = showSelected;
		display();
	}
	
}
