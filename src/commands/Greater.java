/**
 * 
 */
package commands;

import java.util.List;

import resources.languages.Constants;
import resources.languages.Resources;

/**
 * @author harirajan
 *
 */
public class Greater extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Greater", 2, input.size()));
		}
		if (input.get(0) > input.get(1)) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}

	
}
