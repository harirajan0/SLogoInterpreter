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

	/* (non-Javadoc)
	 * @see backend.command_abstraction.MathCommandNoParams#execute()
	 */
	@Override
	protected double execute() {
		// TODO Auto-generated method stub
		return Math.PI;
	}

	/* (non-Javadoc)
	 * @see backend.command_abstraction.MathCommand#execute(java.util.List)
	 */
	@Override
	protected double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

}
