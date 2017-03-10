/**
 * 
 */
package backend;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import main.SLogoData;

/**
 * @author harirajan
 *
 */
public class XMLGenerator {
	
	private int xmlCreationNumber;
	
	public XMLGenerator() {
		xmlCreationNumber = 0;
	}
	
	public void createXML(SLogoData slogoData) {
		xmlCreationNumber++;
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element myFunctionsElement = doc.createElement("FUNCTIONS");
			doc.appendChild(myFunctionsElement);
			
			for (int i = 0; i < slogoData.getFunctions().size(); i++) {
				Element functionElement = (Element) myFunctionsElement.appendChild(doc.createTextNode("function" + i));
				addASTNodeElement(slogoData.getFunctions().get(i), doc, functionElement);
			}
			
		} catch (Exception e) {
			
		}
	}
	
	private void addASTNodeElement(ASTNode node, Document doc, Element rootElement) {
		addElement("myCommand", node.getCommand().getClass().getSimpleName(), doc, rootElement);
		addElement("myVariableName", node.getVariableName(), doc, rootElement);
		addElement("myFunctionName", node.getFunctionName(), doc, rootElement);
		addElement("myValue", String.valueOf(node.getValue()), doc, rootElement);
		addElement("isBlock", String.valueOf(node.isBlock()), doc, rootElement);
		Element myArgumentsElement = doc.createElement("myArguments");
		for (int i = 0; i < node.getArguments().size(); i++) {
			Element argElement = (Element) myArgumentsElement.appendChild(doc.createTextNode("arg" + i));
			addASTNodeElement(node.getArguments().get(i), doc, argElement);
		}
	}
	
	private void addElement(String elementTitle, String elementData, Document doc, Element rootElement) {
		Element newElement = doc.createElement(elementTitle);
		newElement.appendChild(doc.createTextNode(elementData));
		rootElement.appendChild(newElement);
	}
	
	private void addElement(String elementTitle, Node elementData, Document doc, Element rootElement) {
		
	}

}
