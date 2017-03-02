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
public class Not extends NonTurtleCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Not", 1, input.size()));
		}
		if (input.get(0) == 0.0) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}
	
}
