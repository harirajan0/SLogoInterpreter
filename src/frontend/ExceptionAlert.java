package frontend;
import java.util.Arrays;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import resources.Constants;


public class ExceptionAlert {
	
	public ExceptionAlert(Exception e){
		receiveAndDisplayError(e);
	}

	public void receiveAndDisplayError(Exception e){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(e.toString());
		Label label = new Label(Constants.DEFAULT_RESOURCE_BUNDLE.getString("exceptionStackTrace"));
		TextArea textArea = new TextArea(Arrays.toString(e.getStackTrace()));
		textArea.setEditable(false);
		textArea.setWrapText(true);
		GridPane labelAndException = new GridPane();
		labelAndException.add(label, 0, 0);
		labelAndException.add(textArea, 0, 1);		
		alert.getDialogPane().setExpandableContent(labelAndException);
		alert.showAndWait();
	}
	
}