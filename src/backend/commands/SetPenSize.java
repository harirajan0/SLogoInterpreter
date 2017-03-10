/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.TurtleCommandOneParam;
import constants.Constants;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class SetPenSize extends TurtleCommandOneParam {

	/* (non-Javadoc)
	 * @see command_abstractions.TurtleCommand#execute(java.util.List, turtle.Turtle)
	 */
	@Override
	public double execute(List<Double> params, Turtle turtle) {
		Double penSize = params.get(0);
		
		if(penSize < 0 || penSize > 20){
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("PenSizeError"));
		}
		turtle.setPenWidth(penSize);
		return penSize;
	}

}