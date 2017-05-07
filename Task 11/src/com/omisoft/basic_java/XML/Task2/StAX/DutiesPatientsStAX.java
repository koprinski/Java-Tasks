package com.omisoft.basic_java.XML.Task2.StAX;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.omisoft.basic_java.XML.Task2.SAX.DutiesPatients;

/**
 * Reading data from the DutiesPatients xml file by using StAX parser
 * @author bkoprinski
 *
 */
public class DutiesPatientsStAX {
    
    /**
     * Method for reading the data from Duties Patients table and writing it in an ArrayList
     * @return
     */
    public static List<String> getDutiesPatientsStAX()
    {
	List<String> dpList = new ArrayList<>();
	try
	{

	    XMLInputFactory inputFactory = XMLInputFactory.newFactory();
	    InputStream input = new FileInputStream("Duties_Patients_Table.xml");
	    XMLEventReader inputEventReader = inputFactory.createXMLEventReader(input);
	    
	    DutiesPatients dutiespatients = new DutiesPatients();
	    
	    while(inputEventReader.hasNext())
	    { 
		XMLEvent event = inputEventReader.nextEvent();  
		 if (event.isStartElement()) 
		 {  
		     StartElement startElement = event.asStartElement();  
		     String startElementName = startElement.getName().getLocalPart();
		     if(startElementName.equals("ROW")) 
		     {  
			 dutiespatients = new DutiesPatients();
			 @SuppressWarnings("unchecked")
			 Iterator<Attribute> attributes = startElement.getAttributes();  
			 while(attributes.hasNext())
			 {  
			     Attribute attribute = attributes.next();  
			     String attributeName = attribute.getName().getLocalPart();   
			     if(attributeName.equals("Name"))
			     {  
				 dutiespatients.setNameDoctor(attribute.getValue());
			     }
			 }
		     }
		     if(startElementName.equals("Name"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setNameDoctor(event.asCharacters().getData());  
                     }  
		     if(startElementName.equals("WorkingPosition"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setWorkingPosition(event.asCharacters().getData());  
                     }
		     if(startElementName.equals("Education"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setEducation(event.asCharacters().getData());  
                     }
		     if(startElementName.equals("PayCheck"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setPayCheck(Float.parseFloat(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("IdNumber"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setIdNumber(Integer.parseInt(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("DutieNumber"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setDutieNumber(Integer.parseInt(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("NamePatient"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setNamePatient(event.asCharacters().getData());  
                     }
		     if(startElementName.equals("Age"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setAge(Integer.parseInt(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("ID"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutiespatients.setId(event.asCharacters().getData());  
                     }
		 }
		 if(event.isEndElement())  
                 {
		     EndElement endElement = event.asEndElement();  
		     String endElementName = endElement.asEndElement().getName().getLocalPart();
		     if(endElementName.equals("ROW"))
		     {  
			 dpList.add("\n"+dutiespatients.toString());
		     }
                 }
	    }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return dpList;

    }
}