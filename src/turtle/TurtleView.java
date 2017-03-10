/**
 * 
 */
package turtle;

import constants.Constants;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * @author harirajan
 *
 */
public class TurtleView {
	
	private ImageView myTurtleImage;
	private Group myRoot;
		
	public TurtleView(Group root) {
		myTurtleImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
		myTurtleImage.setFitWidth(Constants.TURTLE_SIZE);
		myTurtleImage.setFitHeight(Constants.TURTLE_SIZE);
		myTurtleImage.managedProperty().bind(myTurtleImage.visibleProperty());
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
	
	protected void changeImage(Image img) {
		myTurtleImage.setImage(img);
	}

	
}
