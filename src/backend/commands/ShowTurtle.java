package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import backend.turtle.Turtle;

public class ShowTurtle extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setVisible(true);
		return 1;
	}

}


