package frontend;

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
	
	
	//private ResourceBundle myResources;
	//private Properties property;
	//private FileInputStream fs;
	
	public ExceptionListener(Exception e){
		receiveAndDisplayError(e);
		//myResources = ResourceBundle.getBundle("resources/ExceptionListener.properties");
	}
	public ExceptionListener(){
	}

	public void receiveAndDisplayError(Exception e){
	/*	try {
			//fs=new FileInputStream(System.getProperty("user.dir")+"\\ExceptionListener.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//property.load(fs);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		Alert alert = new Alert(AlertType.ERROR);
		//alert.setTitle(property.getProperty("name"));
		//alert.setHeaderText(property.getProperty("header"));
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
