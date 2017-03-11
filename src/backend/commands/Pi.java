/**
 * 
 */
package backend.commands;

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

}
