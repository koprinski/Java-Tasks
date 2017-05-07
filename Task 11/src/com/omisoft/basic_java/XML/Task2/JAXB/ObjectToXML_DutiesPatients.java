package com.omisoft.basic_java.XML.Task2.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Tests the program with JAXB parser(Marshall - for converting object to xml) for the Duties_Patients table
 * You can add attributes in the xml file
 * @author bkoprinski
 *
 */
public class ObjectToXML_DutiesPatients {
    public static final String FILE_NAME = "Duties_Patients_Table (JAXB).xml";
    
    /**
     * Starts the program
     * @param args
     */
    public static void main(String[] args) {
	
	try
	{
	    Marshaller marshaller = (JAXBContext.newInstance(DutiesPatientsJAXB.class)).createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    DutiesPatientsJAXB dp = new DutiesPatientsJAXB();
	    dp.setNameDoctor("Konstantin Filipov");
	    dp.setWorkingPosition("doctor");
	    dp.setEducation("bachelor");
	    dp.setPayCheck(1000);
	    dp.setIdNumber(11230);
	    dp.setDutieNumber(112);
	    dp.setNamePatient("Radoslav Hristov");
	    dp.setAge(27);
	    dp.setId("8301011202");
	    
	    marshaller.marshal(dp, new File(FILE_NAME));
	} 
	catch (JAXBException e) 
	{
	    e.printStackTrace();
	}

    }

}
