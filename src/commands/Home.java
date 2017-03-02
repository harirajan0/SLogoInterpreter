package commands;

import java.util.List;

import resources.languages.Resources;

public class Home implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Left", 2, arguments.size()));
		}
		turtle.setVisible(true);
		return 1;
	}
}
