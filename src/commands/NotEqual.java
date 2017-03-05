/**
 * 
 */
package commands;

import java.util.List;

import constants.Constants;

/**
 * @author harirajan
 *
 */
public class NotEqual extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException();
		}
		if (!input.get(0).equals(input.get(1))) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}

}
