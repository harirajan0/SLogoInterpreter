/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.command_abstraction.MathCommandTwoParams;

/**
 * @author harirajan
 *
 */
public class Power extends MathCommandTwoParams {
	
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return Math.pow(params.get(0), params.get(1));
	}

	

}
