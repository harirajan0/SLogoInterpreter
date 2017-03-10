package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import turtle.Turtle;

public class HideTurtle extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setVisible(false);
		return 0;
	}
	

	
}
