/**
 * 
 */
package backend;

import commands.Command;
import nonTurtle.And;
import nonTurtle.Arctangent;
import nonTurtle.Cosine;
import nonTurtle.Difference;
import nonTurtle.Equal;
import nonTurtle.Greater;
import nonTurtle.Less;
import nonTurtle.Log;
import nonTurtle.Minus;
import nonTurtle.Not;
import nonTurtle.NotEqual;
import nonTurtle.Or;
import nonTurtle.Power;
import nonTurtle.Product;
import nonTurtle.Quotient;
import nonTurtle.Random;
import nonTurtle.Remainder;
import nonTurtle.Sine;
import nonTurtle.Sum;
import nonTurtle.Tangent;
import turtle.Forward;


/**
 * @author harirajan
 *
 */
public class CommandFactory {

	public Command getCommand(String commandString) {
		switch (commandString) {
//		case "Forward" : return new Forward();
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
