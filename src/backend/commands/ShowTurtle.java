package backend.commands;

import java.util.List;

import backend.command_abstraction.TurtleCommandNoParams;
import turtle.Turtle;

public class ShowTurtle extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setVisible(true);
		turtle.display();
		return 1;
	}

}


