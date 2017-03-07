package frontend;

import java.util.ArrayList;
import java.util.Collection;

import backend.TurtleInfo;
import constants.Constants;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * @author Belal Taher
 */

public class TurtleBox {
	
	private Group myRoot;
	private Rectangle myRectangle;
	
	private Collection<TurtleWindowView> allTurtles;
	private TurtleWindowView currentTurtle;
	
	public TurtleBox(){
		allTurtles = new ArrayList<TurtleWindowView>();
		setUpTurtleWindowView();
		addTurtle();
	}
	
	public void addTurtle(){
		TurtleWindowView newTurtle = new TurtleWindowView(myRoot);
		allTurtles.add(newTurtle);
		currentTurtle = newTurtle;
	}
	
	public Group getNode() {
		return myRoot;
	}
	
	public TurtleWindowView getCurrentTurtle(){
		return currentTurtle;
	}
	
	private void setUpTurtleWindowView() {
		myRoot = new Group();
		myRectangle = new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_COLOR);
		myRoot.getChildren().add(myRectangle);
	}
	
	
	
}
