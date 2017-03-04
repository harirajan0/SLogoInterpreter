package frontend;

import constants.Constants;
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
	
	private BorderPane myBorderPane;
	private Scene myScene;
	private Group myRoot;
//	private TurtleView myTurtle;
	
	private CommandPromptView myCommandPrompt;
	private VariablesView myVariables;
	private TurtleWindowView myTurtleWindow;
	private MenuView myMenuBar;
	private VBox topVBox;
	
	public SLogoView(Stage s) {
		myRoot = new Group();
		myCommandPrompt = new CommandPromptView();
		myVariables = new VariablesView();
		myBorderPane = new BorderPane();
		myTurtleWindow = new TurtleWindowView();
		topVBox = new VBox();
		Text header = new Text(Constants.APPLICATION_TITLE);
		header.setFont(new Font(Constants.TITLE_FONT, Constants.TITLE_FONT_SIZE));
		myMenuBar = new MenuView(s);
		topVBox.getChildren().addAll(myMenuBar.getNode(), header);
		setUpBorderPane();
		myRoot.getChildren().addAll(myBorderPane);
		displayStage(s);
		
//		ExceptionListener errorBox=new ExceptionListener();
	}
	
	private void setUpBorderPane() {
		myBorderPane.setBottom(myCommandPrompt.getNode());
		myBorderPane.setLeft(new Rectangle(Constants.WINDOW_SIZE / 4, Constants.WINDOW_SIZE / 4, Constants.BACKGROUND_COLOR)); // to fill space on left 
		myBorderPane.setRight(myVariables.getNode());
		myBorderPane.setCenter(myTurtleWindow.getNode());
		myBorderPane.setTop(topVBox);
	}
	
	private void displayStage(Stage s){
		myScene = new Scene(myRoot, Constants.WINDOW_SIZE, Constants.WINDOW_SIZE, Constants.BACKGROUND_COLOR);
		s.setScene(myScene);
		s.setTitle(TITLE);
		s.show();
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
	
	public MenuView getMenuOptions(){
		return myMenuBar;
	}

}
