/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.TurtleCommandOneParam;
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
		// TODO Auto-generated method stub
		//ALEX THROW EXCEPTION IS PARAMS.GET(0) IS NOT BETWEEN 1 AND 20
		Double penSize = params.get(0);
		turtle.setPenWidth(penSize);
		return penSize;
	}

}
