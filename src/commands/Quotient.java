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
public class Quotient extends MathCommandTwoParams {

	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double totalQuotient = params.get(0);
		params.remove(0);
		for (double param : params) totalQuotient /= param;
		return totalQuotient;
	}


}
