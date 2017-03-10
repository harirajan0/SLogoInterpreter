package frontend;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.sun.prism.paint.Color;

import constants.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class CommandPromptView {
	/**
	 * We use this class to store everything relating to what is happening in
	 * the command prompt and send it to the backend via the controller. Using
	 * this class allows us to separate what is happening in the command prompt
	 * from everything else in the screen.
	 */
	
	
	private Button myExecuteButton;
	private String actualCommand = "";
	private ComboBox<String> myCommandHistory;
	private BorderPane myBorderPane;
	private VBox myVBox;
	private TextArea myCommandEntry;
	
	private Button forwardButton;
	private Button rightButton;
	private Button leftButton;
	private Button backButton;
	
	ObservableList<String> listOfCommands;
	

	public CommandPromptView() {
		myBorderPane = new BorderPane();
		setUpCommandEntry();
		setUpButtons();
		myBorderPane.setLeft(myCommandEntry);
		myBorderPane.setRight(myVBox);
	}
	
	private void setUpCommandEntry() {
		myCommandEntry = new TextArea();
		myCommandEntry.setPromptText("Please enter a command");
		System.out.println(myCommandEntry.getPromptText());
		myCommandEntry.setMinWidth(600);	//fix magic values for size	
		myCommandEntry.setMinHeight(100); 	//fix magic values for size
	}
	
	private void setUpButtons() {
		myVBox = new VBox(8);
		myVBox.setPrefWidth(200);
		myExecuteButton = new Button("Execute");
		createMovingButtons();
		setUpCommandHistory();
		sizeButtons(myVBox.getPrefWidth());

		
		myVBox.getChildren().addAll(myExecuteButton, forwardButton, backButton, rightButton, leftButton, myCommandHistory);
	}
	
	private void sizeButtons(double size){
		myExecuteButton.setMinWidth(myVBox.getPrefWidth());
		myCommandHistory.setMinWidth(myVBox.getPrefWidth());
		forwardButton.setMinWidth(myVBox.getPrefWidth());
		rightButton.setMinWidth(myVBox.getPrefWidth());
		leftButton.setMinWidth(myVBox.getPrefWidth());
		backButton.setMinWidth(myVBox.getPrefWidth());
	}
	
	private void createMovingButtons(){
		forwardButton = new Button(new String(Constants.DEFAULT_RESOURCE_BUNDLE.getString("forwardLabel")));
		rightButton = new Button(new String(Constants.DEFAULT_RESOURCE_BUNDLE.getString("rightLabel")));;
		leftButton = new Button(new String(Constants.DEFAULT_RESOURCE_BUNDLE.getString("leftLabel")));;
		backButton = new Button(new String(Constants.DEFAULT_RESOURCE_BUNDLE.getString("backLabel")));;
	}
	
	private void setUpCommandHistory() {
		listOfCommands = FXCollections.observableArrayList();
		myCommandHistory = new ComboBox<String>(listOfCommands);
		myCommandHistory.setPromptText("Previous Commands");
		myCommandHistory.setOnAction((event) -> {
			myCommandEntry.setText(myCommandHistory.getSelectionModel().getSelectedItem());
		});
	}
	
	public void addCommandToHistory(String cmd) {
		listOfCommands.add(cmd);
	}

	public String getUserInput() {
		return myCommandEntry.getText();
	}

	public void setCoordinates(int x, int y) {
		myBorderPane.setLayoutX(x);
		myBorderPane.setLayoutY(y);
	}

	public Button getExecuteButton() {
		return myExecuteButton;
	}
	
	public BorderPane getNode() {
		return myBorderPane;
	}
	
	public Button getForwardButton(){
		return forwardButton;
	}
	
	public Button getBackwardsButton(){
		return backButton;
	}
	
	public Button getRightRotate(){
		return rightButton;
	}
	
	public Button getLeftRotate(){
		return leftButton;
	}
	
	public void setCommandPromptText(String text) {
		myCommandEntry.setText(text);
	}
	// public void displayHistory(); // brings up the history of commands
	// public String sendHistoryItem(); // sends the selected history item to
	// the back end and then they create a turtleInfo object and send it back
}