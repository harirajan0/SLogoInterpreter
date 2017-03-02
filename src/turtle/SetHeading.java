package turtle;

import java.util.List;

import backend.TurtleModel;
import resources.languages.Resources;

public class SetHeading extends TurtleCommand{

	@Override
	public double execute(List<Double> arguments, TurtleModel turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "SetHeading", 1, arguments.size()));
		}
		double heading = arguments.get(0);
		turtle.setHeading(heading);
		return turtle.getHeading() - heading;
	}
}
