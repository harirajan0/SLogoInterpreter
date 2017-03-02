package View;

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
	

	public CommandPromptView() {
		myBorderPane = new BorderPane();
		setUpCommandEntry();
		setUpButtons();
		myBorderPane.setLeft(myCommandEntry);
		myBorderPane.setRight(myVBox);
	}
	
	private void setUpCommandEntry() {
		myCommandEntry = new TextArea();
		myCommandEntry.setMinWidth(600);	//fix magic values for size	
		myCommandEntry.setMinHeight(200); 	//fix magic values for size
	}
	
	private void setUpButtons() {
		myVBox = new VBox();
		myVBox.setPrefWidth(200);
		myExecuteButton = new Button("Execute");
		setUpCommandHistory();
		myExecuteButton.setMinWidth(myVBox.getPrefWidth());
		myCommandHistory.setMinWidth(myVBox.getPrefWidth());
		myVBox.getChildren().addAll(myExecuteButton, myCommandHistory);
	}
	
	private void setUpCommandHistory() {
		ObservableList<String> listOfCommands = FXCollections.observableArrayList();
		myCommandHistory = new ComboBox<String>(listOfCommands);
		myCommandHistory.setPromptText("Previous Commands");
		myCommandHistory.setOnAction((event) -> {
			myCommandEntry.setText(myCommandHistory.getSelectionModel().getSelectedItem());
		});
	}
	

	public void runExecute() {
		actualCommand = myCommandEntry.getText();
		myCommandHistory.getItems().add(actualCommand);
		myCommandEntry.setPromptText("enter command input here");
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
	
	public void setCommandPromptText(String text) {
		myCommandEntry.setText(text);
	}
	// public void displayHistory(); // brings up the history of commands
	// public String sendHistoryItem(); // sends the selected history item to
	// the back end and then they create a turtleInfo object and send it back
}