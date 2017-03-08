package commands;

import java.util.List;
import command_abstractions.TurtleCommandTwoParams;
import turtle.Turtle;

public class Towards extends TurtleCommandTwoParams {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double x = params.get(0);
		double y = params.get(1);
		if (y >= turtle.getY()) {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))));
		} else {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))) + 180);
		}
		turtle.display();
		return 0.0;
	}
	
	
}
