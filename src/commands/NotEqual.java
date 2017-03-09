/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.MathCommandTwoParams;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class NotEqual extends MathCommandTwoParams {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (!params.get(0).equals(params.get(1))) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}


}
