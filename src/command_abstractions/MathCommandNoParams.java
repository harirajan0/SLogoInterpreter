/**
 * 
 */
package command_abstractions;

import java.util.List;

import ASTNode.ASTNode;
import main.SLogoData;

/**
 * @author harirajan
 * @author Alex Boss
 *
 */
public abstract class MathCommandNoParams extends MathCommand  {
	
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		return execute();
	}
	
	@Override
	public int getNumArgs() {
		return 0;
	}
	
	protected abstract double execute();

}
