package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

public class SetHeading extends OneParam {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double heading = params.get(0);
		turtle.setHeading(heading);
		turtle.display();
		return turtle.getHeading() - heading;
	}
	
	
}
