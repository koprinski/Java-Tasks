package com.omisoft.basic_java.XML.Task2.SAX;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Tests the SAX parser for the Duties Additional table
 * @author bkoprinski
 *
 */
public class TestDutiesAdditional {

    /**
     * Starts the program
     * @param args
     */
    public static void main(String[] args) {
	SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	try
	{
	    SAXParser saxParser = saxParserFactory.newSAXParser();
	    DutiesAdditionalSAX sax = new DutiesAdditionalSAX();
	    saxParser.parse("Duties_Additionalinfo_Table.xml", sax);
	    List<DutiesAdditional> daList = sax.getDaList();
	    for (DutiesAdditional dutiesAdditional : daList) 
	    {
		System.out.println(dutiesAdditional);
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
