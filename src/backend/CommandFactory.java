/**
 * 
 */
package backend;

import backend.command_abstraction.Command;
import backend.commands.And;
import backend.commands.Arctangent;
import backend.commands.Ask;
import backend.commands.Back;
import backend.commands.ClearScreen;
import backend.commands.Cosine;
import backend.commands.Difference;
import backend.commands.DoTimes;
import backend.commands.Equal;
import backend.commands.For;
import backend.commands.Forward;
import backend.commands.GetPenColor;
import backend.commands.Greater;
import backend.commands.Heading;
import backend.commands.HideTurtle;
import backend.commands.Home;
import backend.commands.ID;
import backend.commands.If;
import backend.commands.IfElse;
import backend.commands.IsPenDown;
import backend.commands.Left;
import backend.commands.Less;
import backend.commands.Log;
import backend.commands.MakeUserInstruction;
import backend.commands.MakeVariable;
import backend.commands.Minus;
import backend.commands.Not;
import backend.commands.NotEqual;
import backend.commands.Or;
import backend.commands.PenDown;
import backend.commands.PenUp;
import backend.commands.Pi;
import backend.commands.Power;
import backend.commands.Product;
import backend.commands.Quotient;
import backend.commands.Random;
import backend.commands.Remainder;
import backend.commands.Repeat;
import backend.commands.Right;
import backend.commands.SetBackground;
import backend.commands.SetHeading;
import backend.commands.SetPenColor;
import backend.commands.SetPenSize;
import backend.commands.SetPosition;
import backend.commands.ShowTurtle;
import backend.commands.Showing;
import backend.commands.Sine;
import backend.commands.Sum;
import backend.commands.Tangent;
import backend.commands.Tell;
import backend.commands.Towards;
import backend.commands.Turtles;
import backend.commands.XCoordinate;
import backend.commands.YCoordinate;
import constants.Constants;


/**
 * @author harirajan
 * @author Alex Boss
 * 
 * This class returns a new command represented by the String passed in, or throws an exception for a command
 * that doesn't exist. 
 */
public class CommandFactory {

	protected Command getCommand(String commandString) {
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
		case "ClearScreen" : return new ClearScreen();
		case "XCoordinate" : return new XCoordinate();
		case "YCoordinate" : return new YCoordinate();
		case "Heading" : return new Heading();
		case "IsPenDown" : return new IsPenDown();
		case "IsShowing" : return new Showing();
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
		case "Pi" : return new Pi();
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
		case "MakeUserInstruction" : return new MakeUserInstruction();
		case "SetBackground" : return new SetBackground();
		case "SetPenColor" : return new SetPenColor();
		case "SetPenSize" : return new SetPenSize();
		case "GetPenColor" : return new GetPenColor();
		case "ID" : return new ID();
		case "Turtles" : return new Turtles();
		case "Tell" : return new Tell();
		case "Ask" : return new Ask();
		default: 
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("UndeclaredFunctionError")
					+ commandString);
		}
	}
}
