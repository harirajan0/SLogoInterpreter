package frontend;

import java.util.ArrayList;
import java.util.List;

import backend.Variable;
import constants.Constants;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 * @author Daniel
 * @author Hari
 * This class contains the display of variables.
 * It allows the user to display variables that they can
 * initialize and or modify through the command line. It also
 * allows them to update their values on the screen directly
 * in the display.
 */

public class VariablesView{
	
	private List<Variable> currentVars;
	private Button myUpdateButton;
	private VBox myVBox;
	
	protected VariablesView() {
		myVBox = new VBox();
		myVBox.setAlignment(Pos.TOP_CENTER);
		Text title = new Text(Constants.VARIABLES_VIEW_TITLE);
		title.setFont(new Font(Constants.DEFAULT_FONT, Constants.DEFAULT_FONT_SIZE));
		myVBox.getChildren().add(title);
		myVBox.setPrefWidth(Constants.TURTLE_WINDOW_SIZE / 2);
		currentVars = new ArrayList<Variable>();
		myUpdateButton = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("updateButtonLabel"));
		myVBox.getChildren().add(myUpdateButton);
		updateVariableDisplay();
	}
	
	protected void setVariables(List<Variable> newVariables) {
		myVBox.getChildren().remove(2, myVBox.getChildren().size());
		currentVars = newVariables;
		updateVariableDisplay();
	}
    
    private void updateVariableDisplay(){
    	for (Variable var : currentVars) displayVariable(var);
    }
    
    private void displayVariable(Variable var) {
    	HBox variableDisplay = new HBox();
    	variableDisplay.setPrefWidth(175);
    	variableDisplay.setAlignment(Pos.BASELINE_RIGHT);
    	Text variableName = new Text(var.getName());
    	TextField variableValue = new TextField(String.valueOf(var.getValue()));
    	variableValue.setPrefWidth(75);
    	variableDisplay.getChildren().addAll(variableName, variableValue);
    	myVBox.getChildren().add(variableDisplay);
    	
    }
    
    protected VBox getNode() {
    	return myVBox;
    }
    
    protected Button getUpdateButton() {
    	return myUpdateButton;
    }
    
    public void updateVariables() {
    	List<Variable> newVars = new ArrayList<>();
    	for (Node node : myVBox.getChildren()) {
    		if (node.getClass().isInstance(new HBox())) {
    			HBox hb = (HBox) node;
    			String varName = ((Text) hb.getChildren().get(0)).getText();
    			try {
    				double varValue = Double.parseDouble(((TextField) hb.getChildren().get(1)).getText());
    				newVars.add(new Variable(varName, varValue));
    			} catch (Exception e) {
    				new ExceptionAlert(e);
    			}
    		}
    	}
    	setVariables(newVars);
    }
    
    public List<Variable> getVariables() {
    	return currentVars;
    }
  }