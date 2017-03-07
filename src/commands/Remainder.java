/**
 * 
 */
package commands;

import java.util.List;

/**
 * @author harirajan
 *
 */
public class Remainder extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if ( arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		double result = arg1.evaluate();
		while ((result - arg2.evaluate()) >= 0.0) result -= arg2.evaluate();
		return result;
	}
	
}
