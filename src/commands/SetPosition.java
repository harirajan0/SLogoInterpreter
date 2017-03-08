package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

public class SetPosition extends TwoParams {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double x = params.get(0);
		double y = params.get(1);
		double distance = Math.sqrt( (Math.pow(turtle.getX() - x, 2) + Math.pow(turtle.getY() - y, 2)));
		turtle.setX(x);
		turtle.setY(y);
		turtle.display();
		return distance;
	}	

}
