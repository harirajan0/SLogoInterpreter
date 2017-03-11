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
public class Cosine extends MathCommandOneParam {

	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		return Math.toDegrees(Math.cos(Math.toRadians(params.get(0))));
	}

}
