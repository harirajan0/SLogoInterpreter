package frontend;

import constants.Constants;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *  @author Daniel Rubinstein
 *  @author Belal Taher
 */

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
	private PaletteView myPaletteView;
	
	private Button newWorkspace;
	
	public SLogoView(Stage s) {
		myRoot = new Group();
		myCommandPrompt = new CommandPromptView();
		myVariables = new VariablesView();
		myBorderPane = new BorderPane();
		myTurtleWindow = new TurtleWindowView();
		myPaletteView = new PaletteView();
		
		myPaletteView.getNode().setOnMouseClicked(new EventHandler<Event>(){
			public void handle(Event event){
				displayPalettePicker();
			}
		});
		
		newWorkspace = new Button();
		
		/*myTurtleWindow.getNode().setOnMouseClicked(new EventHandler<Event>(){
			public void handle(Event event){
				System.out.println("dick");
			}
		});*/
		
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
	
	public Button getWorkspaceButton(){
		return newWorkspace;
	}
	
	private void setUpBorderPane() {
		myBorderPane.setBottom(myCommandPrompt.getNode());
		myBorderPane.setLeft(myPaletteView.getNode());
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
	
	private void displayPalettePicker(){
		Group newRoot = new Group();
		displayPaletteTextFields(newRoot);
		Stage paletteColorPicker = new Stage();
		paletteColorPicker.setTitle(Constants.PALETTE_PICKER_NAME);
		paletteColorPicker.setScene(new Scene(newRoot, Constants.PALETTE_PICKER_SIZE, Constants.PALETTE_PICKER_SIZE, Constants.BACKGROUND_COLOR));
		paletteColorPicker.show();
	}
	
	private void displayPaletteTextFields(Group newRoot){
		VBox textFields = new VBox();
		TextArea colorOneField = new TextArea("Color 1");
		colorOneField.setPrefHeight(10);
		TextArea colorTwoField = new TextArea("Color 2");
		colorTwoField.setPrefHeight(10);
		TextArea colorThreeField = new TextArea("Color 3");
		colorThreeField.setPrefHeight(10);
		TextArea colorFourField = new TextArea("Color 4");
		colorFourField.setPrefHeight(10);
		Button changeColors = new Button("Change colors");
		changeColors.setOnAction((event) -> {
			updateColors(colorOneField.getText(), colorTwoField.getText(), colorThreeField.getText(), colorFourField.getText());
		});
		textFields.getChildren().addAll(colorOneField, colorTwoField, colorThreeField, colorFourField, changeColors);
		newRoot.getChildren().add(textFields);
	}
	
	private void updateColors(String c1, String c2, String c3, String c4){
		myPaletteView.setColorOne(c1);
		myPaletteView.setColorTwo(c2);
		myPaletteView.setColorThree(c3);
		myPaletteView.setColorFour(c4);
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
