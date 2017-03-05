/**
 * 
 */
package commands;

import java.util.List;

import constants.Constants;

/**
 * @author harirajan
 *
 */
public class Equal extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4) throws IllegalArgumentException {
		if ( arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		if (arg1.evaluate() == arg2.evaluate()) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}

}