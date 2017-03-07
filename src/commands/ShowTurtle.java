package commands;

import java.util.List;

import turtle.TurtleInfo;

public class ShowTurtle implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, TurtleInfo turtle) throws IllegalArgumentException {
		if ( arg2 != null || arg3 != null || arg4 != null ) {
			throw new IllegalArgumentException();
		}
		turtle.setVisible(true);
		return 1;
	}
}
