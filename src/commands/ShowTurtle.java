package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

public class ShowTurtle extends NoParams {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		turtle.setVisible(true);
		turtle.display();
		return 1;
	}

}


