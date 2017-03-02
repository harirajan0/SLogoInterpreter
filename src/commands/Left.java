package commands;

import java.util.List;

import resources.languages.Resources;

public class Left implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Left", 1, arguments.size()));
		}
		double rotationAmount = arguments.get(0);
		turtle.setHeading(turtle.getHeading() - rotationAmount);
		return rotationAmount;
	}
}
