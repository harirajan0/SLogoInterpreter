package turtle;

import java.util.List;

import backend.TurtleModel;
import commands.Command;

public abstract class TurtleCommand extends Command {

	public abstract double execute(List<Double> arguments, TurtleModel turtle) throws IllegalArgumentException;
}
