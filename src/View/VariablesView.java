package View;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class VariablesView{
    /** This class allows us to update the variables from the backend (controller will launch this), create a new variable and send this info to 
    *   the backend via the controller, and update the value of the variables by clicking (which will trigger the controller and update the variables
    *   in the backend. Everything relating to variables takes place in this class.
    */
	
	private List<Variable> currentVars;
	private GridPane variableGrid;
	private Group root;
	
	
    public VariablesView getVariablesViewNode(){
    	//controller uses this to add listener
    	return this;
    }
    
    
    public void updateVariableDisplay(List<Variable> listOfVariables){
    	//changes value of variable on screen if modified by backend
    	currentVars=listOfVariables;
    	initializeVariables(root);
    }
    //public Variable createNewVariable(); //create new variable, send it to the controller
    //public String updateVariable(); //updates a variable if the user inputs a different value for it
    //will also need a private void displayVariables();
    
    public List<Variable> sendUpdatedVariables(){
    	return currentVars;
    }
    
    
    
	public void createUI(Group parent){
		root=parent;
		//create test list of variables
		currentVars=new ArrayList<Variable>();
		Variable var1=new Variable("x", "20");
		Variable var2=new Variable("y", "30.4");
		currentVars.add(var1);
		currentVars.add(var2);
		BorderPane pane=new BorderPane();
		initializeVariables(root);
		root.getChildren().add(pane);
		
	}
	
	private void initializeVariables(Group parent){
		variableGrid= new GridPane();
	    variableGrid.setHgap(10);
	    variableGrid.setVgap(10);
	    variableGrid.setPadding(new Insets(0, 10, 0, 10));
		for (int v=0; v<currentVars.size(); v++){
			Variable myVar=currentVars.get(v);
			Label t=new Label(myVar.getName());
			//this.getChildren().add(t);
			TextField t2=new TextField(myVar.getValue());
			//this.getChildren().add(t2);
			t2.setOnKeyReleased(event -> {
	            if (event.getCode().equals(KeyCode.ENTER))
	            {
	                currentVars.get(currentVars.indexOf(myVar)).updateValue(t2.getText());
	                Alert alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Variable update");
	                alert.setHeaderText(null);
	                alert.setContentText("You successfully changed the value of the variable");
	                alert.showAndWait();
            }
		});
			variableGrid.add(t, 1, v);
			variableGrid.add(t2, 2, v);
		}
		variableGrid.setLayoutX(500);
		parent.getChildren().add(variableGrid);
	}
    
  }