package turtle;

import java.util.List;

import backend.TurtleModel;
import resources.languages.Resources;

public class Right extends TurtleCommand{

	@Override
	public double execute(List<Double> arguments, TurtleModel turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Right", 1, arguments.size()));
		}
		double rotationAmount = arguments.get(0);
		turtle.setHeading(turtle.getHeading() + rotationAmount);
		return rotationAmount;
	}
}
