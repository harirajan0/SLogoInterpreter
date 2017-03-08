package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * 
 * @author Alex Boss
 *
 */
public class Back extends OneParam {

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		double totalAmount = 0;
		for (double backAmount : params) {
			turtle.setX(turtle.getX() - backAmount*Math.sin(Math.toRadians(turtle.getHeading())));
			turtle.setY(turtle.getY() + backAmount*Math.cos(Math.toRadians(turtle.getHeading())));
			totalAmount += backAmount;
		}
		return totalAmount;
	}

	

}
