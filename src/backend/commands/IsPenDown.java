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


	@Override
	public double execute(Turtle turtle) {

		if (turtle.isPenDown()) return Constants.TRUE;
		return Constants.FALSE;
	}

}
