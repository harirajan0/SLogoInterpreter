/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.MathCommandTwoParams;

/**
 * @author harirajan
 *
 */
public class Sum extends MathCommandTwoParams {


	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		double totalSum = 0.0;
		for (double param : params) totalSum += param;
		return totalSum;
	}
	


}
