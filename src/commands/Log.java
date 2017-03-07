/**
 * 
 */
package commands;

import java.util.List;

/**
 * @author harirajan
 *
 */
public class Log extends LogicCommand {
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if ( arg2 != null || arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		return Math.log(arg1.evaluate());
	}

}
