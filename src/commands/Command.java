/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import main.SLogoData;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public interface Command {
	
	public double execute(List<Double> params,
			Turtle turtle, SLogoData slogoData) throws IllegalArgumentException;
	
	public int getNumArgs();
	
	public boolean isLogicCommand();
	
}
