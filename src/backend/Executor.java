/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import ASTNode.ASTNode;
import command_abstractions.Command;
import languages.Language;
import main.SLogoData;
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
	private Language myLang;
	
	public Executor() {
		commandFactory = new CommandFactory();
		syntaxParser = new ProgramParser(Language.SYNTAX);
	}
	
	public void setInput( List<String> input) {
		myInput = input;
	}

	public ASTNode parseText(SLogoData slogoData) throws IllegalArgumentException {
		ProgramParser parser = new ProgramParser(myLang);
		List<ASTNode> arguments = new ArrayList<>();
		if (myInput.size() == 0) {
			return null;
		} else {
			if (syntaxParser.getSymbol(myInput.get(0)).equals("Command")) {
				Command cmd = commandFactory.getCommand(parser.getSymbol(myInput.get(0)));
				myInput.remove(0);
				while (myInput.size() > 0) {
					arguments.add(parseText(slogoData));
				}
				return new ASTNode(cmd, null, 0, arguments, slogoData);
			} else if (syntaxParser.getSymbol(myInput.get(0)).equals("Variable")) {
				Variable var = null; // get the variable
				myInput.remove(0);
				return new ASTNode(null, var, 0, arguments, slogoData);
			} else if (syntaxParser.getSymbol(myInput.get(0)).equals("Constant")) {
				double value = Double.parseDouble(myInput.get(0));
				myInput.remove(0);
				return new ASTNode(null, null, value, arguments, slogoData);
			} else {
				return null;
			}
		}
	}
	
	public void setLanguage(Language lang) {
		myLang = lang;
	}

}
