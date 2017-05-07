package com.omisoft.basic_java.XML.Task2.SAX;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Tests the SAX parser for the Duties Patients table
 * @author bkoprinski
 *
 */
public class TestDutiesPatients {

    /**
     * Starts the program
     * @param args
     */
    public static void main(String[] args) {
	SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	try
	{
	    SAXParser saxParser = saxParserFactory.newSAXParser();
	    DutiesPatientsSAX sax = new DutiesPatientsSAX();
	    saxParser.parse("Duties_Patients_Table.xml", sax);
	    List<DutiesPatients> dpList = sax.getDpList();
	    for (DutiesPatients dutiesPatients : dpList) 
	    {
		System.out.println(dutiesPatients);
	    }
	}
	catch (ParserConfigurationException e)
	{
	    e.printStackTrace();
	} 
	catch (SAXException e)
	{
	    e.printStackTrace();
	} catch (IOException e) 
	{
	    e.printStackTrace();
	}
	

    }

}
