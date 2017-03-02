package View;

import java.util.Arrays;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ExceptionListener {
	public ExceptionListener(Exception e){
		receiveAndDisplayError(e);
	}
	public ExceptionListener(){
	}

	public void receiveAndDisplayError(Exception e){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception");
		alert.setHeaderText("Exception");
		alert.setContentText(e.toString());
		Label label = new Label("The exception stacktrace was:");
		TextArea textArea = new TextArea(Arrays.toString(e.getStackTrace()));
		textArea.setEditable(false);
		textArea.setWrapText(true);
		GridPane labelAndException = new GridPane();
		labelAndException.add(label, 0, 0);
		labelAndException.add(textArea, 0, 1);
		//make the stacktrace expandable
		alert.getDialogPane().setExpandableContent(labelAndException);
		alert.showAndWait();
	}
	

}
