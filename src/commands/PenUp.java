package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

public class PenUp implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		turtle.setPenDown(false);
		turtle.display();
		if (arg1 != null) arg1.evaluate();
		return 0;
	}
}
