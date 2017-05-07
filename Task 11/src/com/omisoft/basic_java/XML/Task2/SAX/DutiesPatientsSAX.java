package com.omisoft.basic_java.XML.Task2.SAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Reading data from the DutiesPatients xml file by using SAX parser
 * @author bkoprinski
 *
 */
public class DutiesPatientsSAX extends DefaultHandler 
{

    private List<DutiesPatients> dpList ;
    private DutiesPatients dp;
    private boolean bName = false;
    private boolean bWorkingPosition = false;
    private boolean bEducation = false;
    private boolean bPayCheck = false;
    private boolean bDutieNumber = false;
    private boolean bNamePatient = false;
    private boolean bAge = false;
    private boolean bID = false;
    private boolean bIdNumber = false;
    /**
     * @return the dpList
     */
    public List<DutiesPatients> getDpList() {
        return dpList;
    }

    /**
     * @param dpList the dpList to set
     */
    public void setDpList(List<DutiesPatients> dpList) {
        this.dpList = dpList;
    }


    /* (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    /**
     * Overriding the method startElement of the xml file
     * This is the first element of the table
     * When this method is executed it creates an arraylist with the table data
     */
    @Override
    public void startElement(String uri, String localName, String qName,
	    Attributes attributes) throws SAXException
    {
	if(qName.equalsIgnoreCase("ROW"))
	{
	    String name = attributes.getValue("name");
	    dp = new DutiesPatients();
	    dp.setNameDoctor(name);
	    if(dpList == null)
	    {
		dpList = new ArrayList<DutiesPatients>();
	    }
	}
	else if(qName.equalsIgnoreCase("Name"))
	{
	    bName = true;
	}
	else if(qName.equalsIgnoreCase("WorkingPosition"))
	{
	    bWorkingPosition = true;
	}
	else if(qName.equalsIgnoreCase("Education"))
	{
	    bEducation = true;
	}
	else if(qName.equalsIgnoreCase("PayCheck"))
	{
	    bPayCheck = true;
	}
	else if(qName.equalsIgnoreCase("DutieNumber"))
	{
	    bDutieNumber = true;
	}
	else if(qName.equalsIgnoreCase("NamePatient"))
	{
	    bNamePatient = true;
	}
	else if(qName.equalsIgnoreCase("Age"))
	{
	    bAge = true;
	}
	else if(qName.equalsIgnoreCase("ID"))
	{
	    bID = true;
	}
	else if(qName.equalsIgnoreCase("IdNumber"))
	{
	    bIdNumber = true;
	}
    }

    /* (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
    /**
     * Overrides the endElement method
     * When it is executed it adds in the list the object with the DutiesPatients data
     */
    @Override
    public void endElement(String uri, String localName, String qName)
	    throws SAXException 
    {
	if(qName.equalsIgnoreCase("ROW"))
	{
	    dpList.add(dp);
	}
    }

    /* (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    /**
     * Overriding the characters method
     * When it is executed it basically sets the information in the DutiesPatients object
     */
    @Override
    public void characters(char[] ch, int start, int length)
	    throws SAXException 
    {
	if(bName)
	{
	    dp.setNameDoctor(new String(ch,start,length));
	    bName = false;
	}
	else if(bWorkingPosition)
	{
	    dp.setWorkingPosition(new String(ch,start,length));
	    bWorkingPosition = false;
	}
	else if(bEducation)
	{
	    dp.setEducation(new String(ch,start,length));
	    bEducation= false;
	}
	else if(bPayCheck)
	{
	    dp.setPayCheck(Float.parseFloat(new String(ch, start, length)));
	    bPayCheck = false;
	}
	else if(bDutieNumber)
	{
	    dp.setDutieNumber(Integer.parseInt(new String(ch, start, length)));
	    bDutieNumber = false;
	}
	else if(bNamePatient)
	{
	    dp.setNamePatient(new String(ch,start,length));
	    bNamePatient = false;
	}
	else if(bAge)
	{
	    dp.setAge(Integer.parseInt(new String(ch, start, length)));
	    bAge = false;
	}
	else if(bID)
	{
	    dp.setId(new String(ch, start, length));
	    bID = false;
	}
	else if(bIdNumber)
	{
	    dp.setIdNumber(Integer.parseInt(new String(ch, start, length)));
	    bIdNumber = false;
	}
    }
    
}
