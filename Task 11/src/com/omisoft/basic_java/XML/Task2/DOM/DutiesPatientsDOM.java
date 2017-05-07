package com.omisoft.basic_java.XML.Task2.DOM;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class DutiesPatientsDOM {
    
    /**
     * Method for reading the xml table Duties_Patients with DOM parser
     */
    public static void getDutiesPatients()
    {
	try 
	{
	    File fXmlFile = new File("Duties_Patients_Table.xml");
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();

	    NodeList nList = doc.getElementsByTagName("ROW");
	    
	    for (int i = 0; i < nList.getLength(); i++) 
	    {
		Node nNode = nList.item(i);

		if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		{
		    Element element = (Element) nNode;
		    System.out.println("Doctor Name : " + element.getElementsByTagName("Name").item(0).getTextContent());
		    System.out.println("Working Position : " + element.getElementsByTagName("WorkingPosition").item(0).getTextContent());
		    System.out.println("Education : " + element.getElementsByTagName("Education").item(0).getTextContent());
		    System.out.println("PayCheck : " + element.getElementsByTagName("PayCheck").item(0).getTextContent());
		    System.out.println("IdNumber : " + element.getElementsByTagName("IdNumber").item(0).getTextContent());
		    System.out.println("Dutie Number : " + element.getElementsByTagName("DutieNumber").item(0).getTextContent());
		    System.out.println("\nPatient Name : " + element.getElementsByTagName("NamePatient").item(0).getTextContent());
		    System.out.println("Patient Age : " + element.getElementsByTagName("Age").item(0).getTextContent());
		    System.out.println("Patient ID : " + element.getElementsByTagName("ID").item(0).getTextContent());
		    System.out.println("-----------------------------------------------------------------------------------------------------");
		}
	    }
	} 
	catch (ParserConfigurationException | SAXException | IOException e) 
	{
	    e.printStackTrace();
	}
    }
}
