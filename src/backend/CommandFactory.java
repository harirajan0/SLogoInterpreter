/**
 * 
 */
package backend;

import commands.And;
import commands.Arctangent;
import commands.Command;
import commands.Cosine;
import commands.Difference;
import commands.Equal;
import commands.Forward;
import commands.Greater;
import commands.Less;
import commands.Log;
import commands.Minus;
import commands.Not;
import commands.NotEqual;
import commands.Or;
import commands.Power;
import commands.Product;
import commands.Quotient;
import commands.Random;
import commands.Remainder;
import commands.Sine;
import commands.Sum;
import commands.Tangent;


/**
 * @author harirajan
 *
 */
public class CommandFactory {

	public Command getString(String commandString) {
		switch (commandString) {
		case "Forward" : return new Forward();
//		case "Backward" : return new ;
//		case "Left" : return new ;
//		case "Right" : return new ;
//		case "SetHeading" : return new ;
//		case "SetTowards" : return new ;
//		case "SetPosition" : return new ;
//		case "PenDown" : return new ;
//		case "PenUp" : return new ;
//		case "ShowTurtle" : return new ;
//		case "HideTurtle" : return new ;
//		case "Forwards" : return new ;
//		case "Home" : return new ;
//		case "ClearScreen" : return new ;
//		case "XCoordinate" : return new ;
//		case "YCoordinate" : return new ;
//		case "Heading" : return new ;
//		case "IsPenDown" : return new ;
//		case "IsShowing" : return new ;
		case "Sum" : return new Sum();
		case "Difference" : return new Difference();
		case "Product" : return new Product();
		case "Quotient" : return new Quotient();
		case "Remainder" : return new Remainder();
		case "Minus" : return new Minus();
		case "Random" : return new Random();
		case "Sine" : return new Sine();
		case "Cosine" : return new Cosine();
		case "Tangent" : return new Tangent();
		case "ArcTangent" : return new Arctangent();
		case "NaturalLog" : return new Log();
		case "Power" : return new Power();
		case "LessThan" : return new Less();
		case "GreaterThan" : return new Greater();
		case "Equal" : return new Equal();
		case "NotEqual" : return new NotEqual();
		case "And" : return new And();
		case "Or" : return new Or();
		case "Not" : return new Not();
		default: throw new IllegalArgumentException();
		}
	}
}
