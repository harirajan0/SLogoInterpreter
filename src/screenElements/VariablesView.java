package screenElements;

import java.util.ArrayList;
import java.util.List;

import backend.Variable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VariablesView{
    /**      
    * This class allows us to update the variables from the backend (controller will launch this), create a new variable and send this info to 
    *   the backend via the controller, and update the value of the variables by clicking (which will trigger the controller and update the variables
    *   in the backend. Everything relating to variables takes place in this class.
    *   
    *   @author Daniel
    *   
    */
	
	private List<Variable> currentVars;
	
	private VBox myVBox;
	
	public VariablesView() {
		myVBox = new VBox();
		currentVars = new ArrayList<Variable>();
		updateVariableDisplay();
	}
	
	public void setVariables(List<Variable> newVariables) {
		currentVars = newVariables;
	}
    
    
    public void updateVariableDisplay(){
    	//changes value of variable on screen if modified by backend
    	for (Variable var : currentVars) displayVariable(var);
    }
    
    public void displayVariable(Variable var) {
    	HBox variableDisplay = new HBox();
    	Text variableName = new Text(var.getName());
    	TextField variableValue = new TextField(String.valueOf(var.getValue()));
    	variableDisplay.getChildren().addAll(variableName, variableValue);
    	myVBox.getChildren().add(variableDisplay);
    	
    }
    
    public VBox getNode() {
    	return myVBox;
    }
    
  }