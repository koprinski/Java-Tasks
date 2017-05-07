package com.omisoft.basic_java.DesignPatterns.task1;

/**
 * Tests the AbstractFactory program
 * @author bkoprinski
 *
 */
public class Test {

    public static void main(String[] args) {
	AbstractFactory abstractFactory = new AbstractFactory();
	
	SpecFactory speciesFactory1 = abstractFactory.getSpecFactory("City Transportation");
	Vehicle veh1 = speciesFactory1.getVehicle("bus");
	System.out.println("vehicle 1 is a : " + veh1.type());
	Vehicle veh2 = speciesFactory1.getVehicle("bicycle");
	System.out.println("vehicle 2 is a : " + veh2.type());
	
	
	SpecFactory speciesFactory2 = abstractFactory.getSpecFactory("Load Transportation");
	Vehicle veh3 = speciesFactory2.getVehicle("car");
	System.out.println("vehicle 3 is a : " + veh3.type());
	Vehicle veh4 = speciesFactory2.getVehicle("truck");
	System.out.println("vehicle 4 is a : " + veh4.type());
    }

}
