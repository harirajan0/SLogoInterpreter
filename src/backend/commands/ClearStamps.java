/**
 * 
 */
package backend.commands;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import backend.SLogoData;
import backend.command_abstraction.TurtleCommandNoParams;
import backend.turtle.Turtle;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * @author Belal Taher
 *
 */
public class ClearStamps extends TurtleCommandNoParams implements Observer {

	private SLogoData mySLogoData;

	@Override
	public double execute(Turtle turtle) {
		if(mySLogoData.getStampCollection().isEmpty()){
			return 0;
		}
		else{
			Group root = mySLogoData.getRoot();
			Collection<Node> myChildren = root.getChildren();
			for(ImageView turtleImage: mySLogoData.getStampCollection()){
				if(myChildren.contains(turtleImage)){
					myChildren.remove(turtleImage);
				}
			}
			return 1;
		}
	}

	@Override
	public void update(Observable slogoData, Object arg1) {
		mySLogoData = (SLogoData) slogoData;
	}

}
