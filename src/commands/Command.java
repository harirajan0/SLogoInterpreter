/**
 * 
 */
package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public interface Command {
	
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4,
			Turtle turtle) throws IllegalArgumentException;
	
}
