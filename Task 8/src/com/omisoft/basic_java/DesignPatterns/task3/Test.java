package com.omisoft.basic_java.DesignPatterns.task3;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		IntegerFactory integer = new Proxy("Real Proxy");
		
		integer.createInstance();
		System.out.println();
		integer.createInstance();

	}

}
