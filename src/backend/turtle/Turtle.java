package backend.turtle;
import constants.Constants;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Turtle {
	
	private TurtleModel myTurtleModel;
	private TurtleView myTurtleView;
	
	private boolean showSelected;
	private int myID;
	
	public Turtle(Group root, int id) {
		this(root, new TurtleInfo(), id);
	}
	
	protected Turtle(Group root, TurtleInfo turtleInfo, int id) {
 		myTurtleModel = new TurtleModel(turtleInfo); 
		myTurtleView = new TurtleView(root);
		myID = id;
		showSelected = false;
		getNode().setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				myTurtleModel.setSelected(!myTurtleModel.isSelected());
				Alert alert = new Alert(AlertType.CONFIRMATION);
				if (myTurtleModel.isSelected()) {
					alert.setTitle(Constants.TURTLE_SELECTED_TITLE);
					alert.setContentText(Constants.TURTLE_SELECTED_MESSAGE + myID);
					alert.showAndWait();
				} else {
					alert.setTitle(Constants.TURTLE_UNSELECTED_TITLE);
					alert.setContentText(Constants.TURTLE_UNSELECTED_MESSAGE + myID);
					alert.showAndWait();
				}
				display();
			}
		});
	}
	
	public boolean isSelected() {
		return myTurtleModel.isSelected();
	}
	
	public void setSelected(boolean selected) {
		myTurtleModel.setSelected(selected);
		display();
	}
	
	public TurtleInfo getTurtleInfo() {
		return myTurtleModel.getCurrentTurtleInfo();
	}
	
	public ImageView getNode() {
		return myTurtleView.getNode();
	}
	
	public void display() {
		if (myTurtleModel.getPenDown()) {
			for (Line l : myTurtleModel.calculateLinesToDraw()) {
				l.setFill(myTurtleModel.getPenColor());
				myTurtleView.getRoot().getChildren().add(l);
			}
		}
		if(showSelected && !isSelected()) { 
			getNode().setOpacity(Constants.NOT_SELECTED);
		}
		else {
			getNode().setOpacity(Constants.SELECTED);
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
		myTurtleView.getNode().setVisible(newVisible);
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
	
	public void changeImage(Image img) {
		myTurtleView.changeImage(img);
	}
	
	public String toString() {
		return "ID: " + String.valueOf(myID) + "; Selcted: "  + String.valueOf(myTurtleModel.isSelected()) + "; " +
				myTurtleModel.getCurrentTurtleInfo().toString();
	}
	
}
