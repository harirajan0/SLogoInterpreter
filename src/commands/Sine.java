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
public class Sine extends LogicCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return Math.toDegrees(Math.sin(Math.toRadians(params.get(0))));
	}
	
}
