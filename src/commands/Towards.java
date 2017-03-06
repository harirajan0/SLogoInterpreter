package commands;

import java.util.List;

import backend.TurtleInfo;

public class Towards implements Command{

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if (  arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		double x = arg1.evaluate();
		double y = arg2.evaluate();
		if (y >= turtle.getY()) {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))));
		} else {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))) + 180);
		}
		return 0.0;
		
		/*
		turtle.setHeading(turtle.getHeading() - rotationAmount);
		return rotationAmount;
		*/
	}
}
