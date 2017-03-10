package screenElements;

import constants.Constants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * @author Daniel
 *
 */
public class LanguageSelector extends Stage{
	private ChoiceBox<String> myChoiceBox;
	
	public LanguageSelector(){
		 myChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(Constants.LANGUAGE_RESOURCE_BUNDLE.keySet()));
		 myChoiceBox.setTooltip(new Tooltip(Constants.DEFAULT_RESOURCE_BUNDLE.getString("languagePrompt")));
		 myChoiceBox.getSelectionModel().select(Constants.DEFAULT_RESOURCE_BUNDLE.getString("DefaultLanguage"));
		 BorderPane myBorderPane = new BorderPane(myChoiceBox);
	     Scene s = new Scene(myBorderPane);
	     this.setScene(s);
	}
	
	public ChoiceBox<String> getChoiceBox(){
		return myChoiceBox;
	}
	
}
