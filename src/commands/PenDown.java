package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

public class PenDown extends NoParams {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		turtle.setPenDown(true);
		turtle.display();
		return 1;
	}
	

}
