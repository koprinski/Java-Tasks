package com.omisoft.basic_java.DesignPatterns.task1;

/**
 * Load transportation factory
 * @author bkoprinski
 *
 */
public class LoadTransportationFactory extends SpecFactory{

    /**
     * Defining the two load transportation factories
     */
    @Override
    public Vehicle getVehicle(String type) {
	if("car".equals(type))
	{
	    return new Car();
	}
	else
	{
	    return new Truck();
	}
    }

}
