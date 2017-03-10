package commands;

import command_abstractions.TurtleCommandNoParams;
import turtle.Turtle;

public class PenDown extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setPenDown(true);
		turtle.display();
		return 1;
	}
	

}
