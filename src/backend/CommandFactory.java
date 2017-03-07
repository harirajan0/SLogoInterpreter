/**
 * 
 */
package backend;
import commands.And;
import commands.Arctangent;
import commands.Back;
import commands.Command;
import commands.Cosine;
import commands.Difference;
import commands.Equal;
import commands.Forward;
import commands.Goto;
import commands.Greater;
import commands.HideTurtle;
import commands.Home;
import commands.Left;
import commands.Less;
import commands.Log;
import commands.Minus;
import commands.Not;
import commands.NotEqual;
import commands.Or;
import commands.PenDown;
import commands.PenUp;
import commands.Power;
import commands.Product;
import commands.Quotient;
import commands.Random;
import commands.Remainder;
import commands.Right;
import commands.SetHeading;
import commands.ShowTurtle;
import commands.Sine;
import commands.Sum;
import commands.Tangent;
import commands.Towards;
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
		case "SetPosition" : return new Goto();
		case "PenDown" : return new PenDown();
		case "PenUp" : return new PenUp();
		case "ShowTurtle" : return new ShowTurtle();
		case "HideTurtle" : return new HideTurtle();
		case "Home" : return new Home();
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