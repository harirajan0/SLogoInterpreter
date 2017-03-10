/**
 * 
 */
package commands;

import java.util.List;

import command_abstractions.MathCommandTwoParams;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class And extends MathCommandTwoParams {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		if ( params.get(0) == 1.0 && params.get(1) == 1.0) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}
	
}


