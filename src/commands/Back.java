package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * 
 * @author Alex Boss
 *
 */
public class Back implements Command{

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		double backAmount = arg1.evaluate();
		turtle.setX(turtle.getX() - backAmount*Math.sin(Math.toRadians(turtle.getHeading())));
		turtle.setY(turtle.getY() + backAmount*Math.cos(Math.toRadians(turtle.getHeading())));
		if (arg2 != null) arg2.evaluate();
		return backAmount;
	}
	

}
