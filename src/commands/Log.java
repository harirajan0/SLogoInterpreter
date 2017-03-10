/**
 * 
 */
package commands;

import java.util.List;

import command_abstractions.MathCommandOneParam;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 *
 */
public class Log extends MathCommandOneParam {
	
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		
		if(params.get(0) < 0){
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("LogError"));
		}
		
		return Math.log(params.get(0));
	}
	

}
