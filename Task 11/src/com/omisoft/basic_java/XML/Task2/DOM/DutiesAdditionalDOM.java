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

public class DutiesAdditionalDOM {
  
    /**
     * Method for reading the xml table Duties_Additional with DOM parser
     */
    public static void getDutiesAdditional()
    {
	try 
	{
	    File fXmlFile = new File("Duties_Additionalinfo_Table.xml");
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
		    System.out.println("Experience : " + element.getElementsByTagName("Experience").item(0).getTextContent());
		    System.out.println("Bonus : " + element.getElementsByTagName("Bonus").item(0).getTextContent());
		    System.out.println("DaysOff : " + element.getElementsByTagName("DaysOff").item(0).getTextContent());
		    System.out.println("InfoNumber : " + element.getElementsByTagName("InfoNumber").item(0).getTextContent());
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
