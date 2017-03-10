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
public class ID extends TurtleCommandNoParams {

	/* (non-Javadoc)
	 * @see command_abstractions.TurtleCommandNoParams#execute(turtle.Turtle)
	 */
	@Override
	public double execute(Turtle turtle) {
		// TODO Auto-generated method stub
		return turtle.getID();
	}

}
