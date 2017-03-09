/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.Command;
import commands.CommandFactory;
import languages.Language;
import main.SLogoData;

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
	

	public ASTNode parseText(SLogoData slogoData, List<String> input) throws IllegalArgumentException {
		RegexParser parser = new RegexParser(myLang);
		List<ASTNode> arguments = new ArrayList<>();
		if (input.size() == 0) {
			return null;
		} else {
			if (syntaxParser.getSymbol(input.get(0)).equals("Command")) {
				Command cmd = commandFactory.getCommand(parser.getSymbol(input.get(0)));
				input.remove(0);
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
				while (listEndIndex >= 0)  {
					input.remove(0);
					listEndIndex--;
				}
				while (block.size() > 0) {
					arguments.add(parseText(slogoData, block));
				}
				return new ASTNode(null, null, null, 0, arguments, slogoData, true);
			} 
//			else if (syntaxParser.getSymbol(input.get(0)).equals("PossibleFunction")) {
//				ASTNode function = slogoData.getFunction(input.get(0));
//				input.remove(0);
//				function.runAsFunction(parseText(slogoData, input));
//				if (input.size() > 0) return parseText(slogoData, input);
//				return function;
//			}
			else {
				return null;
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

}
