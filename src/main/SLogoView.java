package main;

import View.CommandPromptView;
import View.MenuView;
import View.TurtleWindowView;
import View.VariablesView;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SLogoView {
	
	public static final String TITLE = "SLogo";
	public static final int SIZE = 800;
	public static final Paint BACKGROUND = Color.WHITE;
	
	private BorderPane myBorderPane;
	private Scene myScene;
	private Stage myStage;
	private Group myRoot;
//	private TurtleView myTurtle;
	
	private CommandPromptView myCommandPrompt;
	private VariablesView myVariables;
	private TurtleWindowView myTurtleWindow;
	private MenuView myMenuBar;
	
	public SLogoView(Stage s) {
		myRoot = new Group();
		myCommandPrompt = new CommandPromptView();
		myVariables = new VariablesView();
		myBorderPane = new BorderPane();
		myTurtleWindow = new TurtleWindowView();
		VBox topVBox = new VBox();
		Text header = new Text("SLogo Interpreter");
		header.setFont(new Font("Courier New", 36));
		myMenuBar = new MenuView(s);
		myBorderPane.setBottom(myCommandPrompt.getNode());
		myBorderPane.setLeft(new Rectangle(200, 200, Color.GRAY)); // to fill space on left 
		myBorderPane.setRight(myVariables.getNode());
		myBorderPane.setCenter(myTurtleWindow.getNode());
		topVBox.getChildren().addAll(myMenuBar.getNode(), header);
		myBorderPane.setTop(topVBox);
		myRoot.getChildren().addAll(myBorderPane);
		
//		ExceptionListener errorBox=new ExceptionListener();
	}
	
	public Stage getInitializedStage(Stage s){
		
		

		myStage = s;
		myScene = new Scene(myRoot, SIZE, SIZE, Color.GRAY);
		s.setScene(myScene);
		s.setTitle(TITLE);
		s.show();
		

		return s;
	}
	
	//FIX THIS
	
	public CommandPromptView getCommandBox() {
		return myCommandPrompt;
	}
	
	public TurtleWindowView getTurtleWindow() {
		return myTurtleWindow;
	}
	
	public Button getExecuteButton() {
		return myCommandPrompt.getExecuteButton();
	}

	public String getUserInput() {
		return myCommandPrompt.getUserInput();
	}
	
	public void addCommandToHistory(String cmd) {
		myCommandPrompt.addCommandToHistory(cmd);
	} 
	
	public void clearCommandPrompt() {
		myCommandPrompt.setCommandPromptText("");
	}

}
