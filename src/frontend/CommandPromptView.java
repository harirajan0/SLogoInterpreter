package frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import constants.Constants;

public class CommandPromptView {
	/**
	 * We use this class to store everything relating to what is happening in
	 * the command prompt and send it to the backend via the controller. Using
	 * this class allows us to separate what is happening in the command prompt
	 * from everything else in the screen.
	 * 
	 * @author Daniel
	 * 
	 */
	
	private Button myExecuteButton;
	private ComboBox<String> myCommandHistory;
	private BorderPane myBorderPane;
	private VBox myVBox;
	private TextArea myCommandEntry;
	
	private HBox turtleMovers;
	private Button forwardButton;
	private Button rightButton;
	private Button leftButton;
	private Button backButton;
	private Button myTurtleImageSelectionButton;
	private CheckBox showSelectedTurtlesButton;
	
	ObservableList<String> listOfCommands;
	

	protected CommandPromptView() {
		myBorderPane = new BorderPane();
		setUpCommandEntry();
		setUpButtons();
		myBorderPane.setLeft(myCommandEntry);
		myBorderPane.setRight(myVBox);
	}
	
	private void setUpCommandEntry() {
		myCommandEntry = new TextArea();
		myCommandEntry.setMinWidth(Constants.COMMAND_WINDOW_WIDTH);
		myCommandEntry.setMinHeight(Constants.COMMAND_WINDOW_HEIGHT);
	}
	
	private void setUpButtons() {
		myVBox = new VBox();
		myVBox.setPrefWidth(Constants.BIG_BUTTON_WIDTH);
		myExecuteButton = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("executeCommandLabel"));
		setUpCommandHistory();
		myExecuteButton.setMinWidth(myVBox.getPrefWidth());
		myCommandHistory.setMinWidth(myVBox.getPrefWidth());
		createMovingButtons();
		myTurtleImageSelectionButton = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("fileLoaderLabel"));
		myTurtleImageSelectionButton.setPrefWidth(Constants.BIG_BUTTON_WIDTH);
		showSelectedTurtlesButton = new CheckBox(Constants.DEFAULT_RESOURCE_BUNDLE.getString("selectedTurtlesButton"));
		myVBox.getChildren().addAll(myExecuteButton, myCommandHistory, turtleMovers, myTurtleImageSelectionButton, showSelectedTurtlesButton);
	}
	
	private void createMovingButtons(){
		turtleMovers = new HBox();
		backButton = createButtonWithImage(Constants.BACK_IMAGE);
		forwardButton = createButtonWithImage(Constants.FORWARD_IMAGE);
		leftButton = createButtonWithImage(Constants.LEFT_ROTATE_IMAGE);
		rightButton = createButtonWithImage(Constants.RIGHT_ROTATE_IMAGE);
		turtleMovers.getChildren().addAll(backButton, forwardButton, leftButton, rightButton);
	}
	
	private Button createButtonWithImage(String source) {
		Button button = new Button();
		ImageView buttonImage = new ImageView(new Image(source));
		buttonImage.setFitHeight(Constants.SMALL_BUTTON_SIZE);
		buttonImage.setFitWidth(Constants.SMALL_BUTTON_SIZE);
		button.setGraphic(buttonImage);
		return button;
	}
	
	private void setUpCommandHistory() {
		listOfCommands = FXCollections.observableArrayList();
		myCommandHistory = new ComboBox<String>(listOfCommands);
		myCommandHistory.setPromptText("Previous Commands");
		myCommandHistory.setOnAction((event) -> {
			myCommandEntry.setText(myCommandHistory.getSelectionModel().getSelectedItem());
		});
	}
	
	public void setForwards(EventHandler<ActionEvent> handler) {
		forwardButton.setOnAction(handler);
	}
	public void setBackwards(EventHandler<ActionEvent> handler) {
		backButton.setOnAction(handler);
	}
	public void setRotateLeft(EventHandler<ActionEvent> handler) {
		leftButton.setOnAction(handler);
	}
	public void setRotateRight(EventHandler<ActionEvent> handler) {
		rightButton.setOnAction(handler);
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
	
	public Button getFileLoader(){
		return myTurtleImageSelectionButton;
	}
	
	public CheckBox getGraphicalDisplayButton(){
		return showSelectedTurtlesButton;
	}
	
	public void setCommandPromptText(String text) {
		myCommandEntry.setText(text);
	}
	
	protected Button getTurtleImageSelectionButton() {
		return myTurtleImageSelectionButton;
	}
	
}