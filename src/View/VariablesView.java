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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VariablesView{
    /** This class allows us to update the variables from the backend (controller will launch this), create a new variable and send this info to 
    *   the backend via the controller, and update the value of the variables by clicking (which will trigger the controller and update the variables
    *   in the backend. Everything relating to variables takes place in this class.
    */
	
	private List<Variable> currentVars;
	private GridPane variableGrid;
	private Group root;
	
	private VBox myVBox;
	
	public VariablesView() {
		myVBox = new VBox();
		currentVars = new ArrayList<Variable>();
		currentVars.add(new Variable("x", "20"));
		currentVars.add(new Variable("y", "40"));
		updateVariableDisplay();
	}
	
    
    
    public void updateVariableDisplay(){
    	//changes value of variable on screen if modified by backend
    	for (Variable var : currentVars) displayVariable(var);
    }
    
    public void displayVariable(Variable var) {
    	HBox variableDisplay = new HBox();
    	Text variableName = new Text(var.getName());
    	TextField variableValue = new TextField(var.getValue());
    	variableDisplay.getChildren().addAll(variableName, variableValue);
    	myVBox.getChildren().add(variableDisplay);
    	
    }
    
    public VBox getNode() {
    	return myVBox;
    }
    //public Variable createNewVariable(); //create new variable, send it to the controller
    //public String updateVariable(); //updates a variable if the user inputs a different value for it
    //will also need a private void displayVariables();
    
//    public List<Variable> sendUpdatedVariables(){
//    	return currentVars;
//    }
//    
//    
//	public VariablesView(Group parent){
//		root=parent;
//		//create test list of variables
//		currentVars=new ArrayList<Variable>();
//
//		BorderPane pane=new BorderPane();
//		initializeVariables(root);
//		root.getChildren().add(pane);
//		
//	}
//	
//	private void initializeVariables(Group parent){
//		variableGrid= new GridPane();
//	    variableGrid.setHgap(10);
//	    variableGrid.setVgap(10);
//	    variableGrid.setPadding(new Insets(0, 10, 0, 10));
//		for (int v=0; v<currentVars.size(); v++){
//			Variable myVar=currentVars.get(v);
//			Label t=new Label(myVar.getName());
//			//this.getChildren().add(t);
//			TextField t2=new TextField(myVar.getValue());
//			//this.getChildren().add(t2);
//			t2.setOnKeyReleased(event -> {
//	            if (event.getCode().equals(KeyCode.ENTER))
//	            {
//	                currentVars.get(currentVars.indexOf(myVar)).updateValue(t2.getText());
//	                Alert alert = new Alert(AlertType.INFORMATION);
//	                alert.setTitle("Variable update");
//	                alert.setHeaderText(null);
//	                alert.setContentText("You changed the value of the variable");
//	                alert.showAndWait();
//            }
//		});
//			variableGrid.add(t, 1, v);
//			variableGrid.add(t2, 2, v);
//		}
//		parent.getChildren().add(variableGrid);
//	}
//	
//	public void setCoordinates(int x, int y){
//		variableGrid.setLayoutX(x);
//		variableGrid.setLayoutY(y);
//	}
    
  }