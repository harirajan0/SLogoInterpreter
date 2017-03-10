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
public class Heading extends TurtleCommandNoParams {

	/* (non-Javadoc)
	 * @see backend.command_abstraction.TurtleCommandNoParams#execute(turtle.Turtle)
	 */
	@Override
	public double execute(Turtle turtle) {
		// TODO Auto-generated method stub
		return turtle.getHeading();
	}

}
