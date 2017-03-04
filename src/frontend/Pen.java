package frontend;

import constants.Constants;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class Pen {
	private Paint penColor;
	private boolean isDown;
	private double penWidth;
	
	public Pen(){    //default pen
		penColor=Constants.DEFAULT_PENCOLOR;
		isDown=true;
		penWidth=10;
	}

	public Line drawLine(double currentX, double currentY, double nextX, double nextY) {
		Line myLine=new Line(currentX, currentY, nextX, nextY);
		myLine.setStroke(penColor);
		myLine.setStrokeWidth(penWidth);
		// TODO Auto-generated method stub
		return myLine;
	}

}
