/**
 * 
 */
package nonTurtle;

import java.util.List;

import commands.Command;
import resources.languages.Constants;
import resources.languages.Resources;

/**
 * @author harirajan
 *
 */
public class Equal extends NonTurtleCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		if (input.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Equal", 2, input.size()));
		}
		if (input.get(0).equals(input.get(1))) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}

}
