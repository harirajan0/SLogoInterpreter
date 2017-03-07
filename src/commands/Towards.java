package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

public class Towards implements Command{

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		double x = arg1.evaluate();
		double y = arg2.evaluate();
		if (y >= turtle.getY()) {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))));
		} else {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))) + 180);
		}
		turtle.display();
		if (arg3 != null) arg3.evaluate();
		return 0.0;
	}
	
}
