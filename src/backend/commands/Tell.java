/**
 * 
 */
package backend.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.Command;
import backend.turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class Tell implements Command {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		double turtleNum = 0.0;
		Set<Integer> selectTurtles = new HashSet<>();
		int initialTurtleNum = slogoData.getNumTurtles();
		for (ASTNode node : params.get(0).getArguments()) {
			turtleNum = node.evaluate();
			if (turtleNum > slogoData.getNumTurtles() ) {
				for (int i = slogoData.getNumTurtles(); i < turtleNum; i++) {
					Turtle newTurtle = new Turtle(slogoData.getRoot(), i + 1);
					newTurtle.setSelected(true);
					slogoData.addTurtle(newTurtle);
				}
			} else {
				selectTurtles.add(((int) turtleNum) - 1);
			}
		}
		for (int i = 0; i < initialTurtleNum; i++) {
			if (selectTurtles.contains(i)) slogoData.getTurtles().get(i).setSelected(true);
			else slogoData.getTurtles().get(i).setSelected(false);
		}
		return turtleNum;
	}

	@Override
	public int getMinNumArgs() {
		return 1;
	}


	@Override
	public boolean isMathCommand() {
		return false;
	}

}
