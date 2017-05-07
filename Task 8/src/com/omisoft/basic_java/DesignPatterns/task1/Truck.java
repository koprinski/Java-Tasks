package com.omisoft.basic_java.DesignPatterns.task1;

/**
 * Truck class
 * @author bkoprinski
 *
 */
public class Truck extends Vehicle {

    /**
     * Type of the Vehicle
     */
    @Override
    public String type() {
	return "freight";
    }

}
