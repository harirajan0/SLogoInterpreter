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
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class Tell implements Command {

	/* (non-Javadoc)
	 * @see command_abstractions.Command#execute(java.util.List, backend.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double turtleNum = 0.0;
		Set<Integer> selectTurtles = new HashSet<>();
		int initialTurtleNum = slogoData.getNumTurtles();
		for (ASTNode node : params.get(0).getArguments()) {
			turtleNum = node.evaluate();
			System.out.println(turtleNum);
			if (turtleNum > slogoData.getNumTurtles() ) {
				for (int i = slogoData.getNumTurtles(); i <= turtleNum; i++) {
					Turtle newTurtle = new Turtle(slogoData.getRoot(), i);
					newTurtle.setSelected(true);
					slogoData.addTurtle(newTurtle);
					System.out.println("hello");
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
	public int getNumArgs() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public boolean isMathCommand() {
		// TODO Auto-generated method stub
		return false;
	}

}
