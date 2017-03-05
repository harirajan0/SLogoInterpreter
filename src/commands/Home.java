package commands;

import java.util.List;

import backend.TurtleInfo;

public class Home implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 2) {
			throw new IllegalArgumentException();
		}
		turtle.setVisible(true);
		return 1;
	}
}
