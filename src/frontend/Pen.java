package frontend;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class Pen {
	private Paint penColor;
	private boolean isDown;
	private static double penWidth;
	private double screenSize=Constants.TURTLE_WINDOW_SIZE;
	
	public Pen(){    //default pen
		penColor=Constants.DEFAULT_PENCOLOR;
		isDown=true;
		penWidth=Constants.DEFAULT_PEN_WIDTH;
	}

	public List<Line> drawLine(double currentX, double currentY, double nextX, double nextY, double headingAngle) {
		List<Line> myLines=new ArrayList<Line>();
		myLines.add(generateLine(currentX, currentY, nextX, nextY, headingAngle));
		// TODO Auto-generated method stub
		return myLines;
	}

	private Line generateLine(double currentX, double currentY, double nextX, double nextY, double headingAngle) {
		Line myLine=new Line(currentX, currentY, nextX, nextY);
		myLine.setStroke(penColor);
		myLine.setStrokeWidth(penWidth);
		return myLine;
	}
	
	public static double getWidth(){
		return penWidth;
	}
	
	public static void changeWidth(double newWidth){
		penWidth=newWidth;
	}

}
