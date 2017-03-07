package commands;

import java.util.List;

import turtle.Turtle;

public class Left implements Command {

	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		double rotationAmount = arg1.evaluate();
		turtle.setHeading(turtle.getHeading() - rotationAmount);
		turtle.display();
		if (arg2 != null) arg2.evaluate();
		return rotationAmount;
	}
	

}
