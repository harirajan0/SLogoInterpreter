/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.command_abstraction.MathCommandOneParam;

/**
 * @author harirajan
 *
 */
public class Minus extends MathCommandOneParam {

	

	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		return 0 - params.get(0);
	}
	

}
