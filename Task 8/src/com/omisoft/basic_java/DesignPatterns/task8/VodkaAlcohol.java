package com.omisoft.basic_java.DesignPatterns.task8;

/**
 * Creating a new alcohol(vodka)
 * @author bkoprinski
 *
 */
public class VodkaAlcohol extends AlcoholTemplate {

    /**
     * Overriding the distilation method
     */
    @Override
    public void distilation() 
    {
	System.out.println("Vodka is made from fermented grains and popatoes.");
    }

    /**
     * Overriding the aging method
     */
    @Override
    public void aging() 
    {
	System.out.println("When the vodka is aging the taste is not improving");
    }

}
