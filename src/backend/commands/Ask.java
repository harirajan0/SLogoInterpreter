/**
 * 
 */
package backend.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.Command;

/**
 * @author harirajan
 *
 */
public class Ask implements Command {


	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		Set<Integer> selectTurtles = new HashSet<>();
		List<Boolean> initialSelection = new ArrayList<>();
		for (ASTNode node : params.get(0).getArguments()) selectTurtles.add(((int) node.evaluate()) - 1);
		for (int i = 0; i < slogoData.getNumTurtles(); i++) {
			initialSelection.add(slogoData.getTurtles().get(i).isSelected());
			if (selectTurtles.contains(i)) {
				slogoData.getTurtles().get(i).setSelected(true);
			} else {
				slogoData.getTurtles().get(i).setSelected(false);
			}
		}
		double ret = params.get(1).evaluate();
		for (int i = 0; i < slogoData.getNumTurtles(); i++) slogoData.getTurtles().get(i).setSelected(initialSelection.get(i));
		return ret;
	}

	@Override
	public int getMinNumArgs() {
		// TODO Auto-generated method stub
		return 2;
	}


	@Override
	public boolean isSimpleEvaluation() {
		// TODO Auto-generated method stub
		return false;
	}

}
