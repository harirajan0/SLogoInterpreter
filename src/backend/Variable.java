
package backend;

/**
 * 
 * @author Alex Boss
 * @author Hari Rajan
 * A class encapsulating the idea of a variable, containing its name and value
 *
 */
public class Variable {
	private String myName;
	private double myValue;
	
	/**
	 * 
	 * @param name Name of new variable
	 * @param value Value of new variable
	 */
	public Variable(String name, double value){
		myName = name;
		myValue = value;
	}
	
	/**
	 * 
	 * @return The name of this variable
	 */ 
	public String getName(){
		return myName;
	}
	/**
	 * 
	 * @return The value of this variable
	 */
	public double getValue(){
		return myValue;
	}
}
