package backend.commands;

import java.util.List;

import backend.command_abstraction.TurtleCommandOneParam;
import turtle.Turtle;

public class SetHeading extends TurtleCommandOneParam {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double heading = params.get(0);
		turtle.setHeading(heading);
		turtle.display();
		return turtle.getHeading() - heading;
	}
	
	
}
