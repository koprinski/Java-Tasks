package com.omisoft.basic_java.DesignPatterns.task1;

/**
 * Abstract factory class
 * @author bkoprinski
 *
 */
public class AbstractFactory {
    /**
     * Method for getting the specifications of the two factories 
     * @param type
     * @return
     */
    public SpecFactory getSpecFactory(String type) 
    {
	if("City Transportation".equalsIgnoreCase(type))
	{
	    return new CityTransportationFactory();
	}
	else
	{
	    return new LoadTransportationFactory();
	}
    }
}
