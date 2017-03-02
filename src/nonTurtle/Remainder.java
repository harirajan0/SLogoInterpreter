/**
 * 
 */
package nonTurtle;

import java.util.List;

import commands.Command;
import resources.languages.Resources;

/**
 * @author harirajan
 *
 */
public class Remainder extends NonTurtleCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Remainder", 2, input.size()));
		}
		double result = input.get(0);
		while ((result - input.get(1)) >= 0.0) result -= input.get(1);
		return result;
	}
}
