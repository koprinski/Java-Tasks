package com.omisoft.basic_java.DesignPatterns.task8;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

    public static void main(String[] args) {
	AlcoholTemplate alcohol = new WhiskeyAlcohol();
	
	alcohol.makeAlcohol();
	System.out.println("------------------------------------------------------------");
	
	alcohol = new VodkaAlcohol();
	alcohol.makeAlcohol();

    }

}
