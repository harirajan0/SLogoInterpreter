package commands;

import java.util.List;

import backend.TurtleInfo;

public class PenDown implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException();
		}
		turtle.setPenDown(true);
		return 1;
	}
}
