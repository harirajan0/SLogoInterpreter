package View;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


public class CommandPromptView{
    /** We use this class to store everything relating to what is happening in the command prompt and send it to the backend
    *   via the controller. Using this class allows us to separate what is happening in the command prompt from 
    *   everything else in the screen.
    */
    private TextField commandEntry;
    private Button execute;
    private boolean textIsEntered;
    private String actualCommand="";
    private ComboBox<String> history;
	
		public void createUI(Group parent){
			BorderPane pane=new BorderPane();
			initializeCommandEntry(pane);
			initializeHistory(pane);
			execute=new Button("execute");
			execute.setOnAction(action -> {
				actualCommand=commandEntry.getText();
                history.getItems().add(actualCommand);
				initializeCommandEntry(pane);
			});
			//just clearing up the last command displayed
			pane.setRight(execute);
			parent.getChildren().add(pane);
			
		}
	
	private void initializeCommandEntry(BorderPane pane){
		commandEntry=new TextField();
		commandEntry.setPromptText("enter your command");
		commandEntry.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.ENTER))
            {
                actualCommand=commandEntry.getText();
                history.getItems().add(actualCommand);
                initializeCommandEntry(pane);
            }
		});

		pane.setLeft(commandEntry);
	}
	
	private void initializeHistory(BorderPane pane){
		ObservableList<String> listOfCommands = 
			    FXCollections.observableArrayList();
			history = new ComboBox<String>(listOfCommands);
			history.setPromptText("select a previous command");
			pane.setBottom(history);
			history.setOnAction((event) ->{
				commandEntry.setText(history.getSelectionModel().getSelectedItem());
			});
	}
		
    public String getCurrentCommand(){ //back end uses this to get last command input **EXTERNAL**
    	//actual command only changes after the user actually enters a new command (not while still typing)
    	return actualCommand;
    }
    
    
    public CommandPromptView getCommandPromptViewNode(){
    	//Controller uses this to add listener
    	return this;
    }
    //public void displayHistory(); // brings up the history of commands
    //public String sendHistoryItem(); // sends the selected history item to the back end and then they create a turtleInfo object and send it back
  }