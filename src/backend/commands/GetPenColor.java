/**
 * 
 */
package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class GetPenColor extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) {
		return turtle.getColorIndex();
	}

}
