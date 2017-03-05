/**
 * 
 */
package commands;

import java.util.List;
/**
 * @author harirajan
 *
 */
public class Tangent extends LogicCommand {
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException();
		}
		
		return Math.toDegrees(Math.tan(Math.toRadians(input.get(0))));
	}
}