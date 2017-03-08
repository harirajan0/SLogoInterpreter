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
public abstract class LogicCommandNoParams extends NoParams {
	
	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		return execute(params);
	}

	@Override
	public boolean isLogicCommand() {
		return true;
	}
	
	public abstract double execute(List<Double> params) throws IllegalArgumentException;

}
