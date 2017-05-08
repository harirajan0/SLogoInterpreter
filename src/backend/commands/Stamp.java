package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.Command;

public class Stamp implements Command{

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		return slogoData.addStamp();
	}

	@Override
	public int getMinNumArgs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMathCommand() {
		// TODO Auto-generated method stub
		return false;
	}

}
