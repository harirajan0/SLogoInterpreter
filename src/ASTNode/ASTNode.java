/**
 * 
 */
package ASTNode;

import java.util.ArrayList;
import java.util.List;

import backend.Variable;
import commands.Command;
import commands.Sum;
import main.SLogoData;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class ASTNode {
	
	private Command myCommand;
	Variable myVariable;
	private double myValue;
//	private Turtle myTurtle;
	private SLogoData mySlogoData;
	
	private List<ASTNode> myArguments;
	
	
	public ASTNode(Command command, Variable variable, double value,
			List<ASTNode> arguments, SLogoData slogoData) {
		myCommand = command;
		myVariable = variable;
		myValue = value;
		myArguments = arguments;
//		myTurtle = turtle;
		mySlogoData = slogoData;
	}
	
	public double evaluate() {
		if (myVariable != null) return myVariable.getValue();
		if (myCommand == null) return myValue; // if its a double
		
		List<Double> paramList = new ArrayList<>();
		List<ASTNode> evaluateList = new ArrayList<>();		
		for (int i = 0; i < myArguments.size(); i++) {
			if (i >= myCommand.getNumArgs()) {
				if (myArguments.get(i).getCommand() != null) {
					if (!myArguments.get(i).getCommand().isLogicCommand()) { //change string to constant
						evaluateList.add(myArguments.get(i));
						continue;
					}
				}
			}
			paramList.add(myArguments.get(i).evaluate());
		}
		double ret = mySlogoData.runCommand(myCommand, paramList);
//		double ret = myCommand.execute(paramList, myTurtle, mySlogoData);
		for (ASTNode node : evaluateList) node.evaluate();
		return ret;
	}
	
	public Command getCommand() {
		return myCommand;
	}
	
	public double getValue() {
		return myValue;
	}
	
	public void setValue(double newValue) {
		myValue = newValue;
	}
	
	public String toString() {
		if (myCommand != null) return myCommand.getClass().getName();
		return String.valueOf(myValue);
	}

}
