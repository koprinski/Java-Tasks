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

import com.omisoft.basic_java.XML.Task2.SAX.DutiesAdditional;

/**
 * Reading data from the DutiesAdditional xml file by using StAX parser
 * @author bkoprinski
 *
 */
public class DutiesAdditionalStAX {
    
    /**
     * Method for reading the data from Duties Additional table and writing it in an ArrayList
     * @return
     */
    public static List<String> getDutiesAdditionalStAX()
    {
	List<String> daList = new ArrayList<>();
	try
	{

	    XMLInputFactory inputFactory = XMLInputFactory.newFactory();
	    InputStream input = new FileInputStream("Duties_Additionalinfo_Table.xml");
	    XMLEventReader inputEventReader = inputFactory.createXMLEventReader(input);
	    
	    DutiesAdditional dutieasadditional = new DutiesAdditional();
	    
	    while(inputEventReader.hasNext())
	    { 
		XMLEvent event = inputEventReader.nextEvent();  
		 if (event.isStartElement()) 
		 {  
		     StartElement startElement = event.asStartElement();  
		     String startElementName = startElement.getName().getLocalPart();
		     if(startElementName.equals("ROW")) 
		     {  
			 dutieasadditional = new DutiesAdditional();
			 @SuppressWarnings("unchecked")
			 Iterator<Attribute> attributes = startElement.getAttributes();  
			 while(attributes.hasNext())
			 {  
			     Attribute attribute = attributes.next();  
			     String attributeName = attribute.getName().getLocalPart();   
			     if(attributeName.equals("Name"))
			     {  
				 dutieasadditional.setNameDoctor(attribute.getValue());
			     }
			 }
		     }
		     if(startElementName.equals("Name"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setNameDoctor(event.asCharacters().getData());  
                     }  
		     if(startElementName.equals("WorkingPosition"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setWorkingPosition(event.asCharacters().getData());  
                     }
		     if(startElementName.equals("Education"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setEducation(event.asCharacters().getData());  
                     }
		     if(startElementName.equals("PayCheck"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setPayCheck(Float.parseFloat(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("IdNumber"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setIdNumber(Integer.parseInt(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("DutieNumber"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setDutieNumber(Integer.parseInt(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("Experience"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setExperience(Integer.parseInt(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("Bonus"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setBonus(Float.parseFloat(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("DaysOff"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setDaysOff(Integer.parseInt(event.asCharacters().getData()));  
                     }
		     if(startElementName.equals("InfoNumber"))  
                     {  
                         event = inputEventReader.nextEvent();  
                         dutieasadditional.setInfoNumber(Integer.parseInt(event.asCharacters().getData()));  
                     }
		 }
		 if(event.isEndElement())  
                 {
		     EndElement endElement = event.asEndElement();  
		     String endElementName = endElement.asEndElement().getName().getLocalPart();
		     if(endElementName.equals("ROW"))
		     {  
			 daList.add("\n"+dutieasadditional.toString());
		     }
                 }
	    }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return daList;

    }
}
