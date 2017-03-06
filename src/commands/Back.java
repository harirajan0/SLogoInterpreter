package commands;

import java.util.List;

import backend.TurtleInfo;

/**
 * 
 * @author Alex Boss
 *
 */
public class Back implements Command{

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if (  arg2 != null || arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		double backAmount = arg1.evaluate();
		turtle.setX(turtle.getX() - backAmount*Math.sin(Math.toRadians(turtle.getHeading())));
		turtle.setY(turtle.getY() + backAmount*Math.cos(Math.toRadians(turtle.getHeading())));
		return backAmount;
	}

}
