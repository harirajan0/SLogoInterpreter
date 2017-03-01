package View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ViewInitializer {
	public static final String TITLE = "SLogo";
	public static final int SIZE = 800;
	public static final Paint BACKGROUND = Color.WHITE;
	private Scene myScene;
	private Stage myStage;
	private Group root;
	
	public Stage getInitializedStage(Stage s){
		root = new Group();
		CommandPromptView commandBox=new CommandPromptView(root, SIZE);
		VariablesView variables=new VariablesView(root);
		ExceptionListener errorBox=new ExceptionListener();
		Point initialPoint = new Point(SIZE/2, SIZE/2);
		TurtleView myTurtle = new TurtleView(initialPoint, root);
		
		//just a test case to move the turtle a bit:
		//myTurtle.updateTurtle(50, 50); 
		
		myStage = s;
		myScene = new Scene(root, SIZE, SIZE, Color.PALEGREEN);
		s.setScene(myScene);
		s.setTitle(TITLE);
		s.show();
		errorBox.receiveAndDisplayError(new NullPointerException()); //test case

		return s;
	}


}
