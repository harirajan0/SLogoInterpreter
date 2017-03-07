/**
 * 
 */
package commands;

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
	public double execute(ASTNode arg1, ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtleInfo)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println(arg1.evaluate());
		while (arg1.evaluate() > 0) {
			System.out.println(arg2.getCommand().getClass().getName());
			System.out.println(arg2.getArg1().getValue());
			arg2.evaluate();
			arg1.setValue(arg1.getValue() - 1);
		}
		return 0;
	}
	
	

}
