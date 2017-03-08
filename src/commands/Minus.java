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
public class Minus extends LogicCommandOneParam {

	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0 - params.get(0);
	}
	

}
