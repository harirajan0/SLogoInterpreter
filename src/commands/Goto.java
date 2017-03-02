package commands;

import java.util.List;

import backend.TurtleInfo;
import resources.languages.Resources;

public class Goto implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Left", 2, arguments.size()));
		}
		double x = arguments.get(0);
		double y = arguments.get(1);
		double distance = Math.sqrt( (Math.pow(turtle.getX() - x, 2) + Math.pow(turtle.getY() - y, 2)));
		turtle.setX(x);
		turtle.setY(y);
		return distance;
	}
}
