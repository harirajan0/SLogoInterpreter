/**
 * 
 */
package backend.command_abstraction;

import java.util.ArrayList;
import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.turtle.Turtle;

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
