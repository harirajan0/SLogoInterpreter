package turtle;

import java.util.List;

import backend.TurtleModel;
import resources.languages.Resources;

public class Home extends TurtleCommand{

	@Override
	public double execute(List<Double> arguments, TurtleModel turtle) throws IllegalArgumentException {
		if (arguments.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Left", 2, arguments.size()));
		}
		turtle.setVisible(true);
		return 1;
	}
}
