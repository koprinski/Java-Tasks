package com.omisoft.basic_java.XML.Task2.SAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Reading data from the DutiesAdditional xml file by using SAX parser
 * @author bkoprinski
 *
 */
public class DutiesAdditionalSAX extends DefaultHandler {
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
	    da = new DutiesAdditional();
	    da.setNameDoctor(name);
	    if(daList == null)
	    {
		daList = new ArrayList<DutiesAdditional>();
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
	else if(qName.equalsIgnoreCase("Experience"))
	{
	    bExperience = true;
	}
	else if(qName.equalsIgnoreCase("Bonus"))
	{
	    bBonus = true;
	}
	else if(qName.equalsIgnoreCase("DaysOff"))
	{
	    bDaysOff = true;
	}
	else if(qName.equalsIgnoreCase("InfoNumber"))
	{
	    bInfoNumber = true;
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
     * When it is executed it adds in the list the object with the DutiesAdditional data
     */
    @Override
    public void endElement(String uri, String localName, String qName)
	    throws SAXException 
    {
	if(qName.equalsIgnoreCase("ROW"))
	{
	    daList.add(da);
	}
    }
    /* (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    /**
     * Overriding the characters method
     * When it is executed it basically sets the information in the DutiesAdditional object
     */
    @Override
    public void characters(char[] ch, int start, int length)
	    throws SAXException
    {
	if(bName)
	{
	    da.setNameDoctor(new String(ch,start,length));
	    bName = false;
	}
	else if(bWorkingPosition)
	{
	    da.setWorkingPosition(new String(ch,start,length));
	    bWorkingPosition = false;
	}
	else if(bEducation)
	{
	    da.setEducation(new String(ch,start,length));
	    bEducation= false;
	}
	else if(bPayCheck)
	{
	    da.setPayCheck(Float.parseFloat(new String(ch, start, length)));
	    bPayCheck = false;
	}
	else if(bDutieNumber)
	{
	    da.setDutieNumber(Integer.parseInt(new String(ch, start, length)));
	    bDutieNumber = false;
	}
	else if(bExperience)
	{
	    da.setExperience(Integer.parseInt(new String(ch, start, length)));
	    bExperience = false;
	}
	else if(bBonus)
	{
	    da.setBonus(Float.parseFloat(new String(ch, start, length)));
	    bBonus = false;
	}
	else if(bDaysOff)
	{
	    da.setDaysOff(Integer.parseInt(new String(ch, start, length)));
	    bDaysOff = false;
	}
	else if(bInfoNumber)
	{
	    da.setInfoNumber(Integer.parseInt(new String(ch, start, length)));
	    bInfoNumber = false;
	}
	else if(bIdNumber)
	{
	    da.setIdNumber(Integer.parseInt(new String(ch, start, length)));
	    bIdNumber = false;
	}
    }
    private List<DutiesAdditional> daList ;
    /**
     * @return the daList
     */
    public List<DutiesAdditional> getDaList() {
        return daList;
    }
    /**
     * @param daList the daList to set
     */
    public void setDaList(List<DutiesAdditional> daList) {
        this.daList = daList;
    }
    private DutiesAdditional da;
    private boolean bName = false;
    private boolean bIdNumber = false;
    private boolean bWorkingPosition = false;
    private boolean bEducation = false;
    private boolean bPayCheck = false;
    private boolean bDutieNumber = false;
    private boolean bExperience = false;
    private boolean bBonus = false;
    private boolean bDaysOff = false;
    private boolean bInfoNumber = false;
}
