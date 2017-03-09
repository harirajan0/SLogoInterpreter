package commands;

import java.util.List;

import command_abstractions.TurtleCommandOneParam;
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
