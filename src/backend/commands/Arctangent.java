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
public class Arctangent extends MathCommandOneParam {

	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		return Math.toDegrees(Math.atan(Math.toRadians(params.get(0))));
	}
	
}
