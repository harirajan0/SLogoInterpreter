/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.TurtleCommandOneParam;
import backend.turtle.Turtle;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class SetPenSize extends TurtleCommandOneParam {

	@Override
	public double execute(List<Double> params, Turtle turtle) {
	
		Double penSize = params.get(0);
		
		if(penSize < 0 || penSize > 3){
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("SetPenSizeError"));
		}
		turtle.setPenWidth(penSize);
		return penSize;
	}

}
