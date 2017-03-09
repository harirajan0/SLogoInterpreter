package frontend;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import constants.Constants;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.SLogoData;

public class SLogoView implements Observer {
	
	public static final String TITLE = "SLogo";
	public static final int SIZE = 800;
	
	private SLogoData mySlogoData;
	
	private BorderPane myBorderPane;
	private Scene myScene;
	private Group myRoot;
	
	private CommandPromptView myCommandPrompt;
	private VariablesView myVariablesView;
	private TurtleWindowView myTurtleWindow;
	private MenuView myMenuBar;
	private VBox topVBox;
	private PaletteView myPaletteView;
	private Menu languageMenu;
	private Menu penColorMenu;
	private Menu penThicknessMenu;
	private MenuItem helpMenu;
	
	public SLogoView(Stage s) {
		myRoot = new Group();
		
		myCommandPrompt = new CommandPromptView();
		myVariablesView = new VariablesView();
		myBorderPane = new BorderPane();
		myTurtleWindow = new TurtleWindowView();
		myPaletteView = new PaletteView();
		
		myPaletteView.getNode().setOnMouseClicked(new EventHandler<Event>(){
			public void handle(Event event){
				displayPalettePicker();
			}
		});
		
		topVBox = new VBox();
		Text header = new Text(Constants.APPLICATION_TITLE);
		header.setFont(new Font(Constants.TITLE_FONT, Constants.TITLE_FONT_SIZE));
		myMenuBar = new MenuView(s);
		for (int i=0; i<myMenuBar.getNode().getMenus().size(); i++){
			MenuBar myMenu = myMenuBar.getNode();
			String menuName=myMenu.getMenus().get(i).getText().toString();
			if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("listOfCommandsContainedIn").equals(menuName)){
				for (int j=0; j<myMenu.getMenus().get(i).getItems().size(); j++){
					if (myMenu.getMenus().get(i).getItems().get(j).getText().equals(Constants.DEFAULT_RESOURCE_BUNDLE.getString("listPrompt"))){
						helpMenu=myMenu.getMenus().get(i).getItems().get(j);
					}
				}
			}
			
			helpMenu.setOnAction(actionEvent ->  {
				try {
					Desktop.getDesktop().browse(new URL(Constants.DEFAULT_RESOURCE_BUNDLE.getString("commandList")).toURI());
				} catch (IOException | URISyntaxException e) {
					new ExceptionListener(e);
				}
			});
			//System.out.println(myMenu.getMenus().get(i).getItems().toString());

		}
		myMenuBar.getNode().getMenus();
		//myMenuBar.getLanguageMenuItem().
		topVBox.getChildren().addAll(myMenuBar.getNode(), header);
		setUpBorderPane();
		myRoot.getChildren().addAll(myBorderPane);
		displayStage(s);
		
//		ExceptionListener errorBox=new ExceptionListener();
	}
	
	private void setUpBorderPane() {
		myBorderPane.setBottom(myCommandPrompt.getNode());
		myBorderPane.setLeft(myPaletteView.getNode());
		myBorderPane.setRight(myVariablesView.getNode());
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
		paletteColorPicker.setTitle(Constants.DEFAULT_RESOURCE_BUNDLE.getString("palettePickerName"));
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

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable slogoData, Object arg) {
		// TODO Auto-generated method stub
		mySlogoData = (SLogoData) slogoData;
		myVariablesView.setVariables(mySlogoData.getVariables());
		myTurtleWindow.setTurtles(mySlogoData.getTurtles());
		myTurtleWindow.changeBackgroundColor(myPaletteView.getColorAtIndex(mySlogoData.getBackgroundColorIndex()));
	}

}
