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
public class Product extends LogicCommandTwoParams {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub		
		double totalProduct = 1.0;
		for (double param : params) totalProduct *= param;
		return totalProduct;
	}

	
}
