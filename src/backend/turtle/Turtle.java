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

/**
 * 
 * @author harirajan
 * 
 * This class is like a controller for the turtle. It contains a turtle model and turtle view and mediates
 * communication between them. Each Turtle class is responsible for exactly one turtle model and one turtle view.
 *
 */
public class Turtle {
	
	private TurtleModel myTurtleModel;
	private TurtleView myTurtleView;
	
	private boolean showSelected;
	private int myID;
	
	/**
	 * 
	 * @param root The group to which to add this Turtle class's TurtleView
	 * @param id The ID of this turtle
	 */
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
	
	/**
	 * @return Whether this turtle is selected
	 */
	public boolean isSelected() {
		return myTurtleModel.isSelected();
	}
	
	/**
	 * 
	 * @param selected The desired state of being selected or unselected
	 */
	public void setSelected(boolean selected) {
		myTurtleModel.setSelected(selected);
		display();
	}
	
	/**
	 * 
	 * @return The TurleInfo of this class's TurtleModel
	 */
	public TurtleInfo getTurtleInfo() {
		return myTurtleModel.getCurrentTurtleInfo();
	}
	
	/**
	 * 
	 * @return The node attached to this class's TurtleView
	 */
	public ImageView getNode() {
		return myTurtleView.getNode();
	}
	
	/**
	 * Adjusts the opacityof this Turtle's TurtleView based on its state of selected or unselected
	 */
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
	
	/**
	 * 
	 * @return THe X location of this turtle
	 */
	public double getX() {
		return myTurtleModel.getCurrentTurtleInfo().getX();
	}
	
	/**
	 * 
	 * @return The Y location of this turtle
	 */
	public double getY() {
		return myTurtleModel.getCurrentTurtleInfo().getY();
	}
	
	/**
	 * 
	 * @return The heading of this turtle
	 */
	public double getHeading() {
		return myTurtleModel.getCurrentTurtleInfo().getHeading();
	}
	
	/**
	 * 
	 * @return Boolean representing whether this turtle's pen is down
	 */
	public boolean isPenDown() {
		return myTurtleModel.getCurrentTurtleInfo().isPenDown();
	}
	
	/**
	 * 
	 * @return Boolean representing whether this turtle is visible
	 */
	public boolean isVisible() {
		return myTurtleModel.getCurrentTurtleInfo().isVisible();
	}
	
	/**
	 * 
	 * @param The new X location of this turtle
	 */
	public void setX(double newX) {
		myTurtleModel.getNextTurtleInfo().setX(newX);
	}
	
	/**
	 * 
	 * @param The new Y location of this turtle
	 */
	public void setY(double newY) {
		myTurtleModel.getNextTurtleInfo().setY(newY);
	}

	/**
	 * 
	 * @param The new heading of this turtle
	 */
	public void setHeading(double newHeading) {
		myTurtleModel.getNextTurtleInfo().setHeading(newHeading);
	}
	

	/**
	 * 
	 * @param The new pen state of this turtle
	 */
	public void setPenDown(boolean newPenDown) {
		myTurtleModel.getNextTurtleInfo().setPenDown(newPenDown);
	}
	

	/**
	 * 
	 * @param The new visibility state of this turtle
	 */
	public void setVisible(boolean newVisible) {
		myTurtleModel.getNextTurtleInfo().setVisible(newVisible);
		myTurtleView.getNode().setVisible(newVisible);
	}


	/**
	 * 
	 * @param The new pen color of this turtle
	 */
	public void setPenColor(int index, Color newColor) {
		myTurtleModel.setPenColor(index, newColor);
	}
	

	/**
	 * 
	 * @param The new pen width of this turtle
	 */
	public void setPenWidth(double newVal) {
		myTurtleModel.setPenWidth(newVal);
	}
	

	/**
	 * 
	 * @return The color index of this turtle
	 */
	public int getColorIndex() {
		return myTurtleModel.getColorIndex();
	}
	

	/**
	 * 
	 * @return The ID of this turtle
	 */
	public int getID() {
		return myID;
	}
	

	/**
	 * 
	 * @param The new selected state of this turtle
	 */
	public void setShowSelected(boolean showSelected) {
		this.showSelected = showSelected;
		display();
	}
	
	/**
	 * 
	 * @param img THe new image of this Turtle class' TurtleView
	 */
	public void changeImage(Image img) {
		myTurtleView.changeImage(img);
	}
	
	/**
	 * @return Tooltip information about this turtle
	 */
	public String toString() {
		return "ID: " + String.valueOf(myID) + "; Selcted: "  + String.valueOf(myTurtleModel.isSelected()) + "; " +
				myTurtleModel.getCurrentTurtleInfo().toString();
	}
	
	public int stamp(){
		return getColorIndex();
	}
	
	
}
