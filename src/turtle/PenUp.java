package turtle;

import java.util.List;

import backend.TurtleModel;
import resources.languages.Resources;

public class PenUp extends TurtleCommand {

	@Override
	public double execute(List<Double> arguments, TurtleModel turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Left", 1, arguments.size()));
		}
		turtle.setPenDown(false);
		return 0;
	}
}
