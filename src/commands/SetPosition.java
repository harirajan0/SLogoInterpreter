package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

public class SetPosition implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		double x = arg1.evaluate();
		double y = arg2.evaluate();
		double distance = Math.sqrt( (Math.pow(turtle.getX() - x, 2) + Math.pow(turtle.getY() - y, 2)));
		turtle.setX(x);
		turtle.setY(y);
		turtle.display();
		if (arg2 != null) arg2.evaluate();
		return distance;
	}
	

}
