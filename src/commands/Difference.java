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
public class Difference extends LogicCommandTwoParams {
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return params.get(0) - params.get(1);
	}

	
}
