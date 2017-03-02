package commands;

import java.util.List;

import backend.TurtleInfo;
import resources.languages.Resources;

/**
 * 
 * @author Alex Boss
 *
 */
public class Back implements Command{

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Back", 1, arguments.size()));
		}
		double backAmount = arguments.get(0);
		turtle.setX(turtle.getX() - backAmount);
		return backAmount;
	}

}
