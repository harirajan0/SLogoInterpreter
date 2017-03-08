/**
 * 
 */
package command_abstractions;

import java.util.List;

import ASTNode.ASTNode;
import main.SLogoData;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public abstract class MathCommandNoParams extends MathCommand {
	
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		return execute();
	}
	
	@Override
	public int getNumArgs() {
		return 0;
	}
	
	public abstract double execute();

}
