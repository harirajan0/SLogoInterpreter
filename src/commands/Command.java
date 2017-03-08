/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public interface Command {
	
	public double execute(List<Double> params,
			Turtle turtle) throws IllegalArgumentException;
	
	public int getNumArgs();
	
	public boolean isLogicCommand();
	
}
