package com.omisoft.basic_java.DesignPatterns.task1;

/**
 * City Transportation factory
 * @author bkoprinski
 *
 */
public class CityTransportationFactory extends SpecFactory{
    /**
     * Defining the two city transportation factories
     */
    @Override
    public Vehicle getVehicle(String type) {
	if("bus".equals(type))
	{
	    return new Bus();
	}
	else
	{
	    return new Bicycle();
	}
    }

}
