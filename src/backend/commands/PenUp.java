package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import turtle.Turtle;

public class PenUp extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setPenDown(false);
		turtle.display();
		return 0;
	}

}
