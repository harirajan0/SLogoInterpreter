/**
 * 
 */
package backend;

import commands.Command;
import commands.Forward;
import commands.Product;

/**
 * @author harirajan
 *
 */
public class CommandFactory {

	public Command getString(String commandString) {
		if (commandString.equals("Forward")) {
			return new Forward();
		} else if (commandString.equals("Product")) {
			return new Product();
		}
		return null;
	}
}
