/**
 * 
 */
package frontend;

import backend.TurtleInfo;
import backend.TurtleModel;
import constants.Constants;
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
	private boolean isSelected;
	
	private TurtleModel myTurtleModel;
	
	
	public TurtleView() {
		myTurtleImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(Constants.TURTLE_IMAGE)));
		myTurtleModel = new TurtleModel();
		myTurtleImage.setFitWidth(Constants.TURTLE_SIZE);
		myTurtleImage.setFitHeight(Constants.TURTLE_SIZE);
	}
	
	public void setNext(TurtleInfo turtleInfo) {
		myTurtleModel.setNext(turtleInfo);
	}
	
	public ImageView getNode() {
		return myTurtleImage;
	}
	
	public void setUpDisplay() {
		myTurtleImage.setX(myTurtleModel.getX() - Constants.BUFFER);
		myTurtleImage.setY(myTurtleModel.getY() - Constants.BUFFER);
		myTurtleImage.setRotate(myTurtleModel.getHeading());
	}

	public boolean isSelected() {
		return isSelected;
	}
	
	public void toggleSelection() {
		isSelected = !isSelected;
	}
	
	public List<Line> getLinesToDraw() {
		return myTurtleModel.calculateLinesToDraw();
	}
	
	public TurtleInfo getTurtleInfo() {
		return myTurtleModel.getTurtleInfo();
	}
	
	public TurtleModel getTurtleModel() {
		return myTurtleModel;
	}
	
	public void prepareForNextCommand() {
		myTurtleModel.prepareForNextCommand();
	}
	
}
