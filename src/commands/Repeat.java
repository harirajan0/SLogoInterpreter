/**
 * 
 */
package commands;

import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class Repeat implements Command {

	/* (non-Javadoc)
	 * @see commands.Command#execute(commands.ASTNode, commands.ASTNode, commands.ASTNode, commands.ASTNode, backend.TurtleInfo)
	 */
	@Override
	public double execute(ASTNode arg1, ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtleInfo)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		while (arg1.evaluate() > 0) {
			arg2.evaluate();
			arg1.setValue(arg1.getValue() - 1);
		}
		return 0;
	}


}
