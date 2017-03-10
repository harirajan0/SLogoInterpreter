package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import turtle.Turtle;

public class Home extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		//THIS HAS TO BE FIXED
		turtle.setVisible(true);
		turtle.display();
		return 1;
	}
	

	
}
