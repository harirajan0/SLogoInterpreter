package nonTurtle;

import java.util.List;

import commands.Command;

public abstract class NonTurtleCommand extends Command{
	
	public abstract double execute(List<Double> arguments) throws IllegalArgumentException;
}
