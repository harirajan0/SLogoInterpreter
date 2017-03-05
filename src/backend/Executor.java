/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commands.Command;
import languages.Language;

/**
 * @author harirajan
 *
 */
public class Executor {

	private CommandFactory commandFactory;
	private ProgramParser syntaxParser;
	private TurtleInfo myTurtleInfo;
	
	Language myLang;
	
	public Executor(TurtleInfo turtleInfo) {
		myTurtleInfo = turtleInfo;
		commandFactory = new CommandFactory();
		syntaxParser = new ProgramParser(Language.SYNTAX);
	}
	

	public List<Double> parseText(List<String> input) throws IllegalArgumentException {
		ProgramParser parser = new ProgramParser(myLang);

		if (input.size() == 0) {
			return new ArrayList<Double>();
		} else {
			if (syntaxParser.getSymbol(input.get(0)).equals("Command")) {
				Command cmd = commandFactory.getCommand(parser.getSymbol(input.get(0)));
				return new ArrayList<>(Arrays.asList(cmd.execute(parseText(input.subList(1, input.size())), myTurtleInfo)));
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Variable")) {
				// look in variables map return
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Constant")) {
				List<Double> list = new ArrayList<>(Arrays.asList(Double.parseDouble(input.get(0))));
				list.addAll(parseText(input.subList(1, input.size())));
				return list;

			} else {
				return new ArrayList<Double>();
			}
		}
		return null;

	}
	
	public void setLanguage(Language lang) {
		myLang = lang;
	}
	
	public void setTurtleInfo(TurtleInfo turtleInfo) {
		myTurtleInfo = turtleInfo;
	}
}
