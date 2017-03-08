package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;

public class Left extends OneParam {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double rotationAmount = params.get(0);
		turtle.setHeading(turtle.getHeading() - rotationAmount);
		turtle.display();
		return rotationAmount;
	}

}
