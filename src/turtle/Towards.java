package turtle;

import java.util.List;

import backend.TurtleModel;
import resources.languages.Resources;

public class Towards extends TurtleCommand{

	@Override
	public double execute(List<Double> arguments, TurtleModel turtle) throws IllegalArgumentException {
		if (arguments.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Towards", 2, arguments.size()));
		}
		double x = arguments.get(0);
		double y = arguments.get(1);
		
		/*
		turtle.setHeading(turtle.getHeading() - rotationAmount);
		return rotationAmount;
		/*
	}
}
