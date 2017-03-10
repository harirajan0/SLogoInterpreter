package backend.commands;

import backend.command_abstraction.TurtleCommandNoParams;
import turtle.Turtle;

public class Home extends TurtleCommandNoParams {

	@Override
	public double execute(Turtle turtle) throws IllegalArgumentException {
		turtle.setX(200);
		turtle.setY(200);
		return Math.sqrt((Math.pow(turtle.getX() - 200, 2)) + (Math.pow(turtle.getY() - 200, 2)));
	}
	

	
}
