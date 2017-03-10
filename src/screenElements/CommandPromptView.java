package screenElements;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
	 * 
	 * @author Daniel
	 * @author Belal Taher
	 */
	
	private Button myExecuteButton;
	private ComboBox<String> myCommandHistory;
	private BorderPane myBorderPane;
	private VBox myVBox;
	private TextArea myCommandEntry;
	private Button forwardButton;
	private Button rightButton;
	private Button leftButton;
	private Button backButton;
	private Button fileLoader;
	private CheckBox showSelectedTurtlesButton;
	
	ObservableList<String> listOfCommands;
	

	public CommandPromptView() {
		myBorderPane = new BorderPane();
		setUpCommandEntry();
		setUpButtons();
		resizeButtons();
		myBorderPane.setLeft(myCommandEntry);
		myBorderPane.setRight(myVBox);
	}
	
	private void setUpCommandEntry() {
		myCommandEntry = new TextArea();
		myCommandEntry.setMinWidth(Constants.COMMAND_WINDOW_WIDTH);
		myCommandEntry.setMinHeight(Constants.COMMAND_WINDOW_HEIGHT);
	}
	
	private void resizeButtons(){
		fileLoader.setMinWidth(myVBox.getPrefWidth());
		myExecuteButton.setMinWidth(myVBox.getPrefWidth());
		myCommandHistory.setMinWidth(myVBox.getPrefWidth());
		forwardButton.setMinWidth(myVBox.getPrefWidth());
		rightButton.setMinWidth(myVBox.getPrefWidth());
		leftButton.setMinWidth(myVBox.getPrefWidth());
		backButton.setMinWidth(myVBox.getPrefWidth());
	}
	
	private void setUpButtons() {
		myVBox = new VBox(Constants.BUTTON_SPACING);
		showSelectedTurtlesButton = new CheckBox(Constants.DEFAULT_RESOURCE_BUNDLE.getString("selectedTurtlesButton"));
		fileLoader = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("fileLoaderLabel"));
		myVBox.setPrefWidth(Constants.COMMAND_BUTTON_WIDTH);
		myExecuteButton = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("executeCommandLabel"));
		setUpCommandHistory();
		createMovingButtons();
		myVBox.getChildren().addAll(myExecuteButton, myCommandHistory, rightButton, leftButton, forwardButton, backButton, fileLoader, showSelectedTurtlesButton);	}
	
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
	
	public Button getFileLoader(){
		return fileLoader;
	}
	
	public CheckBox getGraphicalDisplayButton(){
		return showSelectedTurtlesButton;
	}
	
	public void addCommandToHistory(String cmd) {
		listOfCommands.add(cmd);
	}

	public String getUserInput() {
		return myCommandEntry.getText();
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
}