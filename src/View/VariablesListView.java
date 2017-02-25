package View;

public class VariablesView{
    /** This class allows us to update the variables from the backend (controller will launch this), create a new variable and send this info to 
    *   the backend via the controller, and update the value of the variables by clicking (which will trigger the controller and update the variables
    *   in the backend. Everything relating to variables takes place in this class.
    */
    public Node getVariablesViewNode(); //controller uses this to add listener
    public void updateVariableDisplay(List<Variable> listOfVariables); //changes value of variable on screen if modified by backend
    public Variable createNewVariable(); //create new variable, send it to the controller
    public String updateVariable(); //updates a variable if the user inputs a different value for it
    //will also need a private void displayVariables();
    
  }