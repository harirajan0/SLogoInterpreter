/**
 * 
 */
package backend.turtle;

import constants.Constants;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * This class is the visual manifestation of the turte on the screen. It contains superficial data and JavaFX
 * classes related to the turtle's visuals
 * 
 *  @author Belal
 *
 */
public class TurtleView {
	
	private ImageView myTurtleImage;
	private Group myRoot;
		
	protected TurtleView(Group root) {
		myTurtleImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
		myTurtleImage.setFitWidth(Constants.TURTLE_SIZE);
		myTurtleImage.setFitHeight(Constants.TURTLE_SIZE);
		myTurtleImage.managedProperty().bind(myTurtleImage.visibleProperty());
		myRoot = root;
	}
	
	protected ImageView getNode() {
		return myTurtleImage;
	}
	
	protected Group getRoot() {
		return myRoot;
	}
	
	protected void display(double newX, double newY, double newHeading) {
		myTurtleImage.setX(newX - Constants.BUFFER);
		myTurtleImage.setY(newY - Constants.BUFFER);
		myTurtleImage.setRotate(newHeading);
		myRoot.getChildren().remove(getNode());
		myRoot.getChildren().add(getNode());
	}
	
	protected void changeImage(Image img) {
		myTurtleImage.setImage(img);
	}

	public ImageView getImage(){
		return myTurtleImage;
	}
	
}
