/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.command_abstraction.MathCommandOneParam;
import constants.Constants;


/**
 * @author harirajan
 *
 */
public class Random extends MathCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (params.get(0) < 0.0) {
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("RandomError"));
		}
		
		return Math.random() * params.get(0);
	}
	
	
}
