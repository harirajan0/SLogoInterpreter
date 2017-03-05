/**
 * 
 */
package commands;

import java.util.List;

/**
 * @author harirajan
 *
 */
public class Power extends LogicCommand{
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException(String.format(
					"%s command takes exactly %d argument, %d given", "Power", 2, input.size()));
		}
		return Math.pow(input.get(0), input.get(1));
	}

}
