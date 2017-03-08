/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;

/**
 * @author harirajan
 *
 */
public class Remainder extends LogicCommandTwoParams {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double result = params.get(0);
		while ((result - params.get(1)) >= 0.0) result -= params.get(1);
		return result;
	}

	
}
