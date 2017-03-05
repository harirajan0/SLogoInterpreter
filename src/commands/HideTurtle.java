package commands;

import java.util.List;

import backend.TurtleInfo;

public class HideTurtle implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException();
		}
		turtle.setVisible(false);
		return 0;
	}
}
