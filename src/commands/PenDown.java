package commands;

import java.util.List;
import resources.languages.Resources;

public class PenDown implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Left", 1, arguments.size()));
		}
		turtle.setPenDown(true);
		return 1;
	}
}
