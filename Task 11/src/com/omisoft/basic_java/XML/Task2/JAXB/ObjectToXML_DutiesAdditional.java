package com.omisoft.basic_java.XML.Task2.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Tests the program with JAXB parser(Marshall - for converting object to xml) for the Duties_Additional table
 * You can add attributes in the xml file
 * @author bkoprinski
 *
 */
public class ObjectToXML_DutiesAdditional {
    public static final String FILE_NAME = "Duties_Additionalinfo_Table (JAXB).xml";
    
    /**
     * Starts the program
     * @param args
     */
    public static void main(String[] args) {
	
	try 
	{
	    Marshaller marshaller = (JAXBContext.newInstance(DutiesAdditionalJAXB.class)).createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    
	    DutiesAdditionalJAXB da = new DutiesAdditionalJAXB();
	    da.setNameDoctor("Grigor Dimitrov");
	    da.setWorkingPosition("junior doctor");
	    da.setEducation("bachelor");
	    da.setPayCheck(1100);
	    da.setIdNumber(11230);
	    da.setDutieNumber(112);
	    da.setExperience(1);
	    da.setBonus(30);
	    da.setDaysOff(23);
	    da.setInfoNumber(8);
	    
	    marshaller.marshal(da, new File(FILE_NAME));
	} 
	catch (JAXBException e) 
	{
	    e.printStackTrace();
	}
	 

    }

}
