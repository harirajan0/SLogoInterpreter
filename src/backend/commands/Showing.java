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
public class Showing extends TurtleCommandNoParams{


	@Override
	public double execute(Turtle turtle) {
		if (turtle.isVisible()) return Constants.TRUE;
		return Constants.FALSE;
	}

}
