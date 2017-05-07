package com.omisoft.basic_java.XML.Task2.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Tests the program with JAXB parser(Unmarshall - for converting xml to object) for the Duties_Additional table
 * You can print the attributes from the xml file
 * @author bkoprinski
 *
 */
public class XMLToObject_DutiesAdditional {
    public static final String FILE_NAME = "Duties_Additionalinfo_Table (JAXB).xml";
    
    /**
     * Starts the program
     * @param args
     */
    public static void main(String[] args) {
	
	try
	{
	    DutiesAdditionalJAXB da = (DutiesAdditionalJAXB) ((JAXBContext.newInstance(DutiesAdditionalJAXB.class)).createUnmarshaller()).unmarshal(new File(FILE_NAME));
	    
	    System.out.println(da);
	} 
	catch (JAXBException e) 
	{
	    e.printStackTrace();
	}

    }

}
