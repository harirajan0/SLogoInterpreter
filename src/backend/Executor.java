/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commands.Command;

/**
 * @author harirajan
 *
 */
public class Executor {

	private CommandFactory commandFactory = new CommandFactory();
	private ProgramParser syntaxParser = new ProgramParser("Syntax");

	public List<Double> parseText(List<String> input, String lang) throws IllegalArgumentException {
		ProgramParser parser = new ProgramParser(lang);

		if (input.size() == 0) {
			return new ArrayList<Double>();
		} else {
			if (syntaxParser.getSymbol(input.get(0)).equals("Command")) {
				Command cmd = commandFactory.getString(parser.getSymbol(input.get(0)));
				return new ArrayList<>(Arrays.asList(cmd.execute(parseText(input.subList(1, input.size()), lang))));
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Variable")) {
				// look in variables map return
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Constant")) {
				List<Double> list = parseText(input.subList(1, input.size()), lang);
				list.add(Double.parseDouble(input.get(0)));
				return list;

			} else {
				return new ArrayList<Double>();
			}
		}
		return null;

	}

	public static void main(String[] args) {
		String userInput = "fd fd product 5 fd 30";

		Executor executor = new Executor();
		System.out.println(executor.parseText(new ArrayList<String>(Arrays.asList(userInput.split(" "))), "English"));
	}
}
