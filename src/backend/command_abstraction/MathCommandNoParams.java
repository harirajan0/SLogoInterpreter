/**
 * 
 */
package backend.command_abstraction;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;

/**
 * @author harirajan
 * @author Alex Boss
 *
 */
public abstract class MathCommandNoParams extends MathCommand  {
	
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		return execute(null);
	}
	
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		return execute();
	}
	
	@Override
	public int getNumArgs() {
		return 0;
	}
	
	protected abstract double execute();

}
