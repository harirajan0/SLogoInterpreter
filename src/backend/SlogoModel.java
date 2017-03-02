/**
 * 
 */
package backend;

/**
 * @author Alex Boss
 *
 */
public class SlogoModel {

	private TurtleModel turtleModel;
	private Executor executor;
	
	public SlogoModel(){
		turtleModel = new TurtleModel();
		executor = new Executor();
	}
	
	public double parse(String input) throws IllegalArgumentException{
		return executor.parseText(input, lang); // what to pass for lang?
	}
	
}
