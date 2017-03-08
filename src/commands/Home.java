package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

public class Home extends NoParams {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		//THIS HAS TO BE FIXED
		turtle.setVisible(true);
		turtle.display();
		return 1;
	}
	

	
}
