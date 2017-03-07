/**
 * 
 */
package commands;

import java.util.List;

import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public abstract class LogicCommand implements Command {
	
	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtleInfo) throws IllegalArgumentException {
		return execute(arg1, arg2, arg3, arg4);
	}

	public abstract double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4) throws IllegalArgumentException;
}
