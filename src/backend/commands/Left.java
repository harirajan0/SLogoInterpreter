package backend.commands;

import java.util.List;

import backend.command_abstraction.TurtleCommandOneParam;
import turtle.Turtle;

public class Left extends TurtleCommandOneParam {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double rotationAmount = params.get(0);
		turtle.setHeading(turtle.getHeading() - rotationAmount);
		turtle.display();
		return rotationAmount;
	}

}
