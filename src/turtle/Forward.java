/**
 * 
 */
package turtle;

import java.util.List;

import backend.TurtleModel;
import resources.languages.Resources;

/**
 * @author harirajan
 * @author Alex Boss
 *
 */
public class Forward extends TurtleCommand {

	@Override
	public double execute(List<Double> arguments, TurtleModel turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Forward", 1, arguments.size()));
		}
		double fwdAmount = arguments.get(0);
		turtle.setX(turtle.getX() + fwdAmount);
		return fwdAmount;
	}

}
