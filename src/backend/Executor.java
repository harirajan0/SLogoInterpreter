/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commands.Command;
import commands.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class Executor {

	private CommandFactory commandFactory;
	private ProgramParser syntaxParser;
	private TurtleInfo myTurtleInfo;
	
	public Executor(TurtleInfo turtleInfo) {
		myTurtleInfo = turtleInfo;
		commandFactory = new CommandFactory();
		syntaxParser = new ProgramParser("Syntax");
	}
	

	public List<Double> parseText(List<String> input, String lang) throws IllegalArgumentException {
		ProgramParser parser = new ProgramParser(lang);

		if (input.size() == 0) {
			return new ArrayList<Double>();
		} else {
			if (syntaxParser.getSymbol(input.get(0)).equals("Command")) {
				Command cmd = commandFactory.getCommand(parser.getSymbol(input.get(0)));
				return new ArrayList<>(Arrays.asList(cmd.execute(parseText(input.subList(1, input.size()), lang), myTurtleInfo)));
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Variable")) {
				// look in variables map return
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Constant")) {
				List<Double> list = new ArrayList<>(Arrays.asList(Double.parseDouble(input.get(0))));
				list.addAll(parseText(input.subList(1, input.size()), lang));
				return list;

			} else {
				return new ArrayList<Double>();
			}
		}
		return null;

	}

	public static void main(String[] args) {
		String userInput = "fd difference 25 sum 10 quotient 750 product 5 fd 30";

		Executor executor = new Executor(new TurtleInfo());
		System.out.println(executor.parseText(new ArrayList<String>(Arrays.asList(userInput.split(" "))), "English"));
	}
}
