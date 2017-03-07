package commands;

import java.util.List;

import backend.TurtleInfo;

public class Right implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if ( arg2 != null || arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		double rotationAmount = arg1.evaluate();
		turtle.setHeading(turtle.getHeading() + rotationAmount);
		return rotationAmount;
	}
}
