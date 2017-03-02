package commands;

import java.util.List;

import resources.languages.Resources;

public class SetHeading implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "SetHeading", 1, arguments.size()));
		}
		double heading = arguments.get(0);
		turtle.setHeading(heading);
		return turtle.getHeading() - heading;
	}
}
