package commands;

import java.util.List;

import turtle.Turtle;

public class Right extends OneParam {//TurtleOneParam?

	@Override
	public double execute(List<Double> params, Turtle turtle) throws IllegalArgumentException {
		Double totalRotation = 0.0;
		for(Double d : params){
			totalRotation += d;
		}
		turtle.setHeading(turtle.getHeading() + totalRotation);
		turtle.display();
		return totalRotation;
	}
	
}
