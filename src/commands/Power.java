/**
 * 
 */
package commands;

import java.util.List;

import backend.ASTNode;
import command_abstractions.MathCommandTwoParams;

/**
 * @author harirajan
 *
 */
public class Power extends MathCommandTwoParams {
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return Math.pow(params.get(0), params.get(1));
	}

	

}
