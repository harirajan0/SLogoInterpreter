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
public class Cosine extends LogicCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		return Math.toDegrees(Math.cos(Math.toRadians(params.get(0))));
	}

}
