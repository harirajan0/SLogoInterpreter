/**
 * 
 */
package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import backend.turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class YCoordinate extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) {
		return turtle.getY();
	}

}
