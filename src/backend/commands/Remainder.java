/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.MathCommandTwoParams;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class Remainder extends MathCommandTwoParams {

	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		
		if(params.size() != 2){
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("RemainderError"));
		}
		
		double result = params.get(0);
		while ((result - params.get(1)) >= 0.0)
			result -= params.get(1);
		return result;
	}

}
