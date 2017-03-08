/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class Not extends LogicCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (params.get(0) == 0.0) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}

}
