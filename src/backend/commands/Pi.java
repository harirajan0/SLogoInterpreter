/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.MathCommandNoParams;

/**
 * @author harirajan
 *
 */
public class Pi extends MathCommandNoParams {


	@Override
	protected double execute() {
		return Math.PI;
	}

	@Override
	protected double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

}
