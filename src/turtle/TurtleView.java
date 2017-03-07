/**
 * 
 */
package turtle;

import constants.Constants;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

import java.util.List;


/**
 * @author harirajan
 *
 */
public class TurtleView {
	
	private ImageView myTurtleImage;
	private Group myRoot;
	
	private boolean isSelected;	
	
	public TurtleView(Group root) {
		myTurtleImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
		myTurtleImage.setFitWidth(Constants.TURTLE_SIZE);
		myTurtleImage.setFitHeight(Constants.TURTLE_SIZE);
		myRoot = root;
	}
	
	public ImageView getNode() {
		return myTurtleImage;
	}
	
	public Group getRoot() {
		return myRoot;
	}
	
	public void display(double newX, double newY, double newHeading) {
		myTurtleImage.setX(newX - Constants.BUFFER);
		myTurtleImage.setY(newY - Constants.BUFFER);
		myTurtleImage.setRotate(newHeading);
		myRoot.getChildren().remove(getNode());
		myRoot.getChildren().add(getNode());
	}

	public boolean isSelected() {
		return isSelected;
	}
	
	public void toggleSelection() {
		isSelected = !isSelected;
	}
	
}
