/**
 * 
 */
package commands;

import java.util.List;

import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public abstract class LogicCommandTwoParams extends TwoParams {
	
	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		return execute(params);
	}
	
	@Override
	public boolean isLogicCommand() {
		return true;
	}

	public abstract double execute(List<Double> params) throws IllegalArgumentException;

}
