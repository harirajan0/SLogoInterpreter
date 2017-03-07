package commands;

import java.util.List;

import turtle.TurtleInfo;

public class Goto implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if ( arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		double x = arg1.evaluate();
		double y = arg2.evaluate();
		double distance = Math.sqrt( (Math.pow(turtle.getX() - x, 2) + Math.pow(turtle.getY() - y, 2)));
		turtle.setX(x);
		turtle.setY(y);
		return distance;
	}
}
