/**
 * 
 */
package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import backend.turtle.Turtle;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class IsPenDown extends TurtleCommandNoParams {

	/* (non-Javadoc)
	 * @see backend.command_abstraction.TurtleCommandNoParams#execute(turtle.Turtle)
	 */
	@Override
	public double execute(Turtle turtle) {
		// TODO Auto-generated method stub
		if (turtle.isPenDown()) return Constants.TRUE;
		return Constants.FALSE;
	}

}
