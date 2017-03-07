/**
 * 
 */
package commands;
import java.util.List;
import backend.TurtleInfo;

/**
 * @author harirajan
 *
 */
public interface Command {
	
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4,
			TurtleInfo turtleInfo) throws IllegalArgumentException;
	
}