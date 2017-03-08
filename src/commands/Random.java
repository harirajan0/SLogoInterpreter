/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.MathCommandOneParam;


/**
 * @author harirajan
 *
 */
public class Random extends MathCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (params.get(0) < 0.0) {
			throw new IllegalArgumentException("Random only takes in a positive number, negative number given");
		}
		return Math.random() * params.get(0);
	}
	
	
}
