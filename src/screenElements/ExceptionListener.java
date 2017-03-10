package screenElements;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;
import constants.Constants;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;


public class ExceptionListener {
	
	/**
	 * Use this class to display exceptions graphically to the user.
	 * 
	 * @author Daniel
	 * 
	 */
	
	public ExceptionListener(Exception e){
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
		//make the stacktrace expandable
		alert.getDialogPane().setExpandableContent(labelAndException);
		alert.showAndWait();
	}
	
}