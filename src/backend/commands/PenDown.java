package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import backend.turtle.Turtle;

public class PenDown extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setPenDown(true);
		return 1;
	}
	

}
