/**
 * 
 */
package command_abstractions;

import java.util.ArrayList;
import java.util.List;

import ASTNode.ASTNode;
import main.SLogoData;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public abstract class TurtleCommandNoParams extends TurtleCommand {
	
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		return slogoData.runCommand(this, new ArrayList<>());
	}
	
	@Override
	public double execute(List<Double> params, Turtle turtle) {
		return execute(turtle);
	}
	
	@Override
	public int getNumArgs() {
		return 0;
	}
	
	public abstract double execute(Turtle turtle);

}
