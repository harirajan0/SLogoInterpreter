package commands;

import java.util.List;

import backend.TurtleInfo;

public class HideTurtle implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if ( arg1 != null || arg2 != null || arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		turtle.setVisible(false);
		return 0;
	}
}
