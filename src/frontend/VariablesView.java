package frontend;

import java.util.ArrayList;
import java.util.List;

import backend.Variable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import resources.Constants;

public class VariablesView{
    /** This class allows us to update the variables from the backend (controller will launch this), create a new variable and send this info to 
    *   the backend via the controller, and update the value of the variables by clicking (which will trigger the controller and update the variables
    *   in the backend. Everything relating to variables takes place in this class.
    */
	
	private List<Variable> currentVars;
	private Button myUpdateButton;
	private VBox myVBox;
	
	public VariablesView() {
		myVBox = new VBox();
		myVBox.setAlignment(Pos.TOP_CENTER);
		Text title = new Text("Your Variables");
		title.setFont(new Font("Verdana", 20));
		myVBox.getChildren().add(title);
		myVBox.setPrefWidth(200);
		currentVars = new ArrayList<Variable>();
		myUpdateButton = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("updateButtonLabel"));
		myVBox.getChildren().add(myUpdateButton);
		updateVariableDisplay();
	}
	
	public void setVariables(List<Variable> newVariables) {
		myVBox.getChildren().remove(2, myVBox.getChildren().size());
		currentVars = newVariables;
		updateVariableDisplay();
	}
    
    public void updateVariableDisplay(){
    	//changes value of variable on screen if modified by backend
    	for (Variable var : currentVars) displayVariable(var);
    }
    
    public void displayVariable(Variable var) {
    	HBox variableDisplay = new HBox();
    	variableDisplay.setPrefWidth(175);
    	variableDisplay.setAlignment(Pos.BASELINE_RIGHT);
    	Text variableName = new Text(var.getName());
    	TextField variableValue = new TextField(String.valueOf(var.getValue()));
    	variableValue.setPrefWidth(75);
    	variableDisplay.getChildren().addAll(variableName, variableValue);
    	myVBox.getChildren().add(variableDisplay);
    	
    }
    
    public VBox getNode() {
    	return myVBox;
    }
    
    public Button getUpdateButton() {
    	return myUpdateButton;
    }
    
    public void updateVariables() {
    	List<Variable> newVars = new ArrayList<>();
    	for (Node node : myVBox.getChildren()) {
    		if (node.getClass().isInstance(new HBox())) {
    			System.out.println("YAY");
    			HBox hb = (HBox) node;
    			String varName = ((Text) hb.getChildren().get(0)).getText();
    			try {
    				double varValue = Double.parseDouble(((TextField) hb.getChildren().get(1)).getText());
    				newVars.add(new Variable(varName, varValue));
    			} catch (Exception e) {
    				//throw exception
    				System.out.println(e);
    			}
    		}
    	}
    	setVariables(newVars);
    }
    
    public List<Variable> getVariables() {
    	return currentVars;
    }
  }