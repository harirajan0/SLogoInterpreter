/**
 * 
 */
package commands;

import command_abstractions.Command;


/**
 * @author harirajan
 *
 */
public class CommandFactory {

	public Command getCommand(String commandString) {
		switch (commandString) {
		case "Forward" : return new Forward();
		case "Backward" : return new Back();
		case "Left" : return new Left();
		case "Right" : return new Right();
		case "SetHeading" : return new SetHeading();
		case "SetTowards" : return new Towards();
		case "SetPosition" : return new SetPosition();
		case "PenDown" : return new PenDown();
		case "PenUp" : return new PenUp();
		case "ShowTurtle" : return new ShowTurtle();
		case "HideTurtle" : return new HideTurtle();
		case "Home" : return new Home();
		//implement these
		case "ClearScreen" : return new Home();
		case "XCoordinate" : return new Home();
		case "YCoordinate" : return new Home();
		case "Heading" : return new Home();
		case "IsPenDown" : return new Home();
		case "IsShowing" : return new Home();
		//
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
		//implement this
		case "Pi" : return new Home();
		//
		case "LessThan" : return new Less();
		case "GreaterThan" : return new Greater();
		case "Equal" : return new Equal();
		case "NotEqual" : return new NotEqual();
		case "And" : return new And();
		case "Or" : return new Or();
		case "Not" : return new Not();
		case "MakeVariable" : return new MakeVariable();
		case "Repeat" : return new Repeat();
		case "If" : return new If();
		case "IfElse" : return new IfElse();
		case "DoTimes" : return new DoTimes();
		case "For" : return new For();
		default: throw new IllegalArgumentException();
		}
	}
}
