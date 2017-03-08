package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

public class HideTurtle extends NoParams {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		turtle.setVisible(false);
		turtle.display();
		return 0;
	}
	

	
}
