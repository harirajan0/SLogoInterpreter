package turtle;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		getClickSensorNode().setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Turtle Selected!");
				alert.setContentText("You chose turtle with ID: " + myID);
				alert.showAndWait();
				myTurtleModel.setSelected(true);
			}
			
		});
	}
	
	public void setNext(TurtleInfo turtleInfo) {
		myTurtleModel.setNext(turtleInfo);
	}
	
	public boolean isSelected() {
		return myTurtleModel.isSelected();
	}
	
	public void seSelected(boolean selected) {
		myTurtleModel.setSelected(selected);
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
	
	public Node getClickSensorNode(){
		return (Node) myTurtleView.getClickSensorNode();
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
