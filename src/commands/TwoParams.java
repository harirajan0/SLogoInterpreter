/**
 * 
 */
package commands;

import java.util.List;

import main.SLogoData;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public abstract class TwoParams implements Command {
	
	
	@Override
	public double execute(List<Double> params, Turtle turtle, SLogoData slogoData) throws IllegalArgumentException {
		return execute(params, turtle);
	}
	
	public abstract double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException;
	
	@Override 
	public int getNumArgs() {
		return 2;
	}
	
	@Override
	public boolean isLogicCommand() {
		return true;
	}

}