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
public class Heading extends TurtleCommandNoParams {


	@Override
	public double execute(Turtle turtle) {
		return turtle.getHeading();
	}

}
