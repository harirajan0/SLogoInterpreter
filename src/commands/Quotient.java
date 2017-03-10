/**
 * 
 */
package commands;

import java.util.List;

import command_abstractions.MathCommandTwoParams;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 */
public class Quotient extends MathCommandTwoParams {

	/*
	 * (non-Javadoc)
	 * 
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		if (params.indexOf(0.0) != -1 && params.indexOf(0.0) != 0) {
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("QuotientError"));
		}

		double totalQuotient = params.get(0);
		params.remove(0);
		for (double param : params)
			totalQuotient /= param;
		return totalQuotient;
	}

}
