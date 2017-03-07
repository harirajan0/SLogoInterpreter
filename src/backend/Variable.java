package backend;
//class containing a variable and its value
public class Variable {
	private String name;
	private String value;
	
	//constructor
	public Variable(String n, String v){
		name=n;
		value=v;
	}
	
	public String getName(){
		return name;
	}
	
	public String getValue(){
		return value;
	}
	
	public void updateValue(String newVal){
		value=newVal;
	}
}