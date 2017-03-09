/**
 * 
 */
package ASTNode;

import java.util.ArrayList;
import java.util.List;

import backend.Variable;
import command_abstractions.Command;
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
		print();
		if (myVariable != null) return myVariable.getValue();
		if (myCommand == null) return myValue; // if its a double
		return myCommand.execute(myArguments, mySlogoData);
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
	
	public boolean hasMathValue() {
		if (myCommand == null) return true;
		return myCommand.isMathCommand();
	}
	
	public void print() {
		System.out.println();
		System.out.println(this);
		System.out.println(this.myArguments);
		System.out.println();
	}
	

}
