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
public class Product extends MathCommandTwoParams {


	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {	
		double totalProduct = 1.0;
		for (double param : params) totalProduct *= param;
		return totalProduct;
	}

	
}
