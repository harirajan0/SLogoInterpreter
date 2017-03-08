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
public class Sum extends LogicCommandTwoParams {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double totalSum = 0.0;
		for (double param : params) totalSum += param;
		return totalSum;
	}
	


}
