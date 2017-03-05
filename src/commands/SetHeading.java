package commands;

import java.util.List;

import backend.TurtleInfo;

public class SetHeading implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException();
		}
		double heading = arguments.get(0);
		turtle.setHeading(heading);
		return turtle.getHeading() - heading;
	}
}
