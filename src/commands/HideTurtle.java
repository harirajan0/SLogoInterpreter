package commands;

import command_abstractions.TurtleCommandNoParams;
import turtle.Turtle;

public class HideTurtle extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setVisible(false);
		turtle.display();
		return 0;
	}
	

	
}
