package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CommandPromptView extends BorderPane{
    /** We use this class to store everything relating to what is happening in the command prompt and send it to the backend
    *   via the controller. Using this class allows us to separate what is happening in the command prompt from 
    *   everything else in the screen.
    */
    
		public void createUI(Group parent){
			BorderPane pane=new BorderPane();
			TextField commandEntry=new TextField("enter command here:");
			pane.setLeft(commandEntry);
			Button execute=new Button("execute command");
			pane.setRight(execute);
			parent.getChildren().add(pane);
		}
	
    //public String getCurrentCommand(); //back end uses this to get last command input **EXTERNAL**
    //public Node getCommandPromptViewNode(); //Controller uses this to add listener 
    //public void displayHistory(); // brings up the history of commands
    //public String sendHistoryItem(); // sends the selected history item to the back end and then they create a turtleInfo object and send it back
  }