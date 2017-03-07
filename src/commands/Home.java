package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

public class Home implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		//THIS HAS TO BE FIXED
		turtle.setVisible(true);
		turtle.display();
		if (arg2 != null) arg2.evaluate();
		return 1;
	}
	
}
