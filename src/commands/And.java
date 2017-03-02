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
public class And extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> arguments) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (arguments.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "And", 2, arguments.size()));
		}
		if (arguments.get(0) == 1.0 && arguments.get(1) == 1.0) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}

}


