/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.List;

import command_abstractions.Command;
import commands.CommandFactory;
import constants.Constants;
import languages.Language;

/**
 * @author harirajan
 *
 */
public class Executor {

	private CommandFactory commandFactory;
	private RegexParser syntaxParser;
	private Language myLang;
	
	
	public Executor() {
		commandFactory = new CommandFactory();
		syntaxParser = new RegexParser(Language.SYNTAX);
		
	}
	
	public ASTNode parseTextAsFunction(SLogoData slogoData, List<String> input) {
		RegexParser languageParser = new RegexParser(myLang);
		List<ASTNode> arguments = new ArrayList<>();
		String functionName;
		if (input.size() == 0) {
			return null;
		} else {
			if (languageParser.getSymbol(input.get(0)).equals("PossibleFunction")) {
				functionName = input.get(0);
				input.remove(0);
			} else {
				return null; //throw exception; illegal function name
			}
			if (syntaxParser.getSymbol(input.get(0)).equals("ListStart")) {
				int listEndIndex = getIndexOfBracketMatch(input);
				List<String> block = new ArrayList<>(input.subList(0, listEndIndex + 1));
				removeToIndex(input, listEndIndex);
				arguments.add(parseText(slogoData, block));
			} else {
				return null; //throw exception; illegal format for defining funciton
			}
			if (syntaxParser.getSymbol(input.get(0)).equals("ListStart")) {
				int listEndIndex = getIndexOfBracketMatch(input);
				List<String> block = new ArrayList<>(input.subList(0, listEndIndex + 1));
				removeToIndex(input, listEndIndex);
				arguments.add(parseText(slogoData, block));
			} else {
				return null; //throw exception; illegal format for defining funciton
			}
		}
		return new ASTNode(null, null, functionName, 0, arguments, slogoData, false);
	}
	

	public ASTNode parseText(SLogoData slogoData, List<String> input) throws IllegalArgumentException {
		RegexParser languageParser = new RegexParser(myLang);
		List<ASTNode> arguments = new ArrayList<>();
		if (input.size() == 0) return null;
		else {
			if (syntaxParser.getSymbol(input.get(0)).equals("Command")) {
				if (languageParser.getSymbol(input.get(0)).equals("PossibleFunction")) {
					ASTNode function = slogoData.getFunction(input.get(0));
					input.remove(0);
					if (syntaxParser.getSymbol(input.get(0)).equals("ListStart")) {
						int listEndIndex = getIndexOfBracketMatch(input);
						List<String> block = new ArrayList<>(input.subList(0, listEndIndex + 1));
						function.addArgument(parseText(slogoData, block));
						removeToIndex(input, listEndIndex);
					}
					return function;
				}
				Command cmd = commandFactory.getCommand(languageParser.getSymbol(input.get(0)));
				input.remove(0);
				if (cmd.getClass().getSimpleName().equals("MakeUserInstruction")) {
					arguments.add(parseTextAsFunction(slogoData, input));
				}
				while (input.size() > 0) {
					if (cmd.isMathCommand()) {
						if (parseText(slogoData, new ArrayList<>(input)).hasMathValue() || arguments.size() == 0) {
							arguments.add(parseText(slogoData, input));
						} else {
							return new ASTNode(cmd, null, null, 0, arguments, slogoData, false);
						}
					} else {
						arguments.add(parseText(slogoData, input));
					}
				}
				return new ASTNode(cmd, null, null, 0, arguments, slogoData, false);
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Variable")) {
				String var = input.get(0).substring(1);
				input.remove(0);
				return new ASTNode(null, var, null, 0, arguments, slogoData, false);
			} else if (syntaxParser.getSymbol(input.get(0)).equals("Constant")) {
				double value = Double.parseDouble(input.get(0));
				input.remove(0);
				return new ASTNode(null, null, null, value, arguments, slogoData, false);
			} else if (syntaxParser.getSymbol(input.get(0)).equals("ListStart")) {
				int listEndIndex = getIndexOfBracketMatch(input);
				List<String> block = new ArrayList<>(input.subList(1, listEndIndex));
				removeToIndex(input, listEndIndex);
				while (block.size() > 0) {
					arguments.add(parseText(slogoData, block));
				}
				return new ASTNode(null, null, null, 0, arguments, slogoData, true);
			} 
			else {
				if(syntaxParser.getSymbol(input.get(0)).equals("ListEnd")){
					throw new IllegalArgumentException(
							Constants.DEFAULT_RESOURCE_BUNDLE.getString("MissingOpenDelimiter"));
				}
				else{
					throw new IllegalArgumentException(
							Constants.DEFAULT_RESOURCE_BUNDLE.getString("InvalidSyntaxError") + input.get(0));
				}
			}
		}
	}
	
	public int getIndexOfBracketMatch(List<String> input) {
		int count = 0;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).equals("[")) {
				count++;
			} else if (input.get(i).equals("]")) {
				count --;
				if (count == 0) return i;
			}
		}
		return 0;
	}
	
	public void setLanguage(Language lang) {
		myLang = lang;
	}
	
	private void removeToIndex(List<String> list, int index) {
		while (index >= 0) {
			list.remove(0);
			index--;
		}
	}

}
