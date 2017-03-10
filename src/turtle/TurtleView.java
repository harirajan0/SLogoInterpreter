/**
 * 
 */
package turtle;

import constants.Constants;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.List;


/**
 * @author harirajan
 *
 */
public class TurtleView {
	
	private ImageView myTurtleImage;
	private Group myRoot;
	
	private Rectangle clickSensor;
		
	public TurtleView(Group root) {
		myTurtleImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
		myTurtleImage.setFitWidth(Constants.TURTLE_SIZE);
		myTurtleImage.setFitHeight(Constants.TURTLE_SIZE);
		clickSensor = new Rectangle(0 - Constants.BUFFER,0 - Constants.BUFFER,Constants.TURTLE_SIZE, Constants.TURTLE_SIZE);
		clickSensor.setFill(Color.TRANSPARENT);
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
		myRoot.getChildren().remove(getClickSensorNode());
		clickSensor = new Rectangle(newX- Constants.BUFFER, newY - Constants.BUFFER, Constants.SENSOR_SIZE, Constants.SENSOR_SIZE);
		clickSensor.setFill(Color.TRANSPARENT);
		myRoot.getChildren().add(getClickSensorNode());
	}
	
	public Node getClickSensorNode(){
		return (Node) clickSensor;
	}

	
}
