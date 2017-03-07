package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

public class PenDown implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		turtle.setPenDown(true);
		turtle.display();
		if (arg1 != null) arg1.evaluate();
		return 1;
	}
}
