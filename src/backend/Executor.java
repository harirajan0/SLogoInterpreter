/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import commands.ASTNode;
import commands.Command;
import languages.Language;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class Executor {

	private CommandFactory commandFactory;
	private ProgramParser syntaxParser;
	private List<String> myInput;
	
	Language myLang;
	
	public Executor() {
		commandFactory = new CommandFactory();
		syntaxParser = new ProgramParser(Language.SYNTAX);
	}
	
	public void setInput( List<String> input) {
		myInput = input;
	}

	public ASTNode parseText(Turtle turtle) throws IllegalArgumentException {
		ProgramParser parser = new ProgramParser(myLang);

		if (myInput.size() == 0) {
			return null;
		} else {
			if (syntaxParser.getSymbol(myInput.get(0)).equals("Command")) {
				Command cmd = commandFactory.getCommand(parser.getSymbol(myInput.get(0)));
				myInput.remove(0);
				ASTNode arg1 = parseText(turtle);
				ASTNode arg2 = parseText(turtle);
				ASTNode arg3 = parseText(turtle);
				ASTNode arg4 = parseText(turtle);
				return new ASTNode(cmd, null, 0, arg1, arg2, arg3, arg4, turtle);
			} else if (syntaxParser.getSymbol(myInput.get(0)).equals("Variable")) {
				Variable var = null; // get the variable
				myInput.remove(0);
				return new ASTNode(null, var, 0, null, null, null, null, turtle);
			} else if (syntaxParser.getSymbol(myInput.get(0)).equals("Constant")) {
				double value = Double.parseDouble(myInput.get(0));
				myInput.remove(0);
				return new ASTNode(null, null, value, null, null, null, null, turtle);
			} else {
				return null;
			}
		}
	}
	
	public void setLanguage(Language lang) {
		myLang = lang;
	}

}
