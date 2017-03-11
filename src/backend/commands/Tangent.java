/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.MathCommandOneParam;
/**
 * @author harirajan
 *
 */
public class Tangent extends MathCommandOneParam {
	

	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		return Math.toDegrees(Math.tan(Math.toRadians(params.get(0))));
	}


}
