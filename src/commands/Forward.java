/**
 * 
 */
package commands;

import java.util.ArrayList;
import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.TurtleCommandOneParam;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class Forward extends TurtleCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.lang.Double[])
	 */
//	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double totalAmount = 0;
		for (Double fwdAmount : params) {
			turtle.setX(turtle.getX() + fwdAmount * Math.sin(Math.toRadians(turtle.getHeading())));
			turtle.setY(turtle.getY() - fwdAmount * Math.cos(Math.toRadians(turtle.getHeading())));
			turtle.display();
			totalAmount += fwdAmount;
		}
		return totalAmount;
	}
	

	
}
