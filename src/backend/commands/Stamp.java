/**
 * 
 */
package backend.commands;

import java.util.Observable;
import java.util.Observer;

import backend.SLogoData;
import backend.command_abstraction.TurtleCommandNoParams;
import backend.turtle.Turtle;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 * @author Belal Taher
 *
 */
public class Stamp extends TurtleCommandNoParams implements Observer {

	private SLogoData mySLogoData;

	@Override
	public double execute(Turtle turtle) {
		Group root = mySLogoData.getRoot();
		ImageView turtleImage = turtle.getNode();
		turtleImage.setX(turtle.getX());
		turtleImage.setY(turtle.getY());
		root.getChildren().add(turtleImage);
		
		mySLogoData.addToStampCollection(turtleImage);
		
		return turtle.getID();
	}

	@Override
	public void update(Observable slogoData, Object arg1) {
		mySLogoData = (SLogoData) slogoData;
	}

}
