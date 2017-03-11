/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.MathCommandOneParam;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class Not extends MathCommandOneParam {


	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		if (params.get(0) == 0.0) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}

}
