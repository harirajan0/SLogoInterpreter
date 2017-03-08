package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import backend.Variable;
import commands.Command;
import javafx.scene.paint.Color;
import turtle.Turtle;

/**
 * 
 */

/**
 * @author harirajan
 *
 */
public class SLogoData extends Observable {
	
	private List<Turtle> myTurtles;
	private List<Variable> myVariables;
	
	private int myBackgroundColorIndex;
	
	
	public void runCommand(Command cmd, List<Double> params) {
		if (cmd.isLogicCommand()) cmd.execute(params, null);
		else {
			for (Turtle turtle : myTurtles) {
				if (turtle.isSelected()) {
	//				cmd.execute(params, turtle, this);
					setChanged();
				}
			}
		}
	}
	
	public void changeBackgroundColorIndex(int index) {
		myBackgroundColorIndex = index;
	}
	
	public int getBackgroundColorIndex() {
		return myBackgroundColorIndex;
	}
	
	public Variable getVariable(String name) {
		for (Variable var : myVariables) {
			if (var.getName().equals(name)) return var;
		}
		return null; //fix this to throw error when we cant find the variable
	}
	
	public void addVariable(Variable var) {
		myVariables.add(var);
	}
	
}
