package com.omisoft.basic_java.DesignPatterns.task8;

/**
 * Creating a new alcohol(whiskey)
 * @author bkoprinski
 *
 */
public class WhiskeyAlcohol extends AlcoholTemplate{

    /**
     * Overriding the distilation method
     */
    @Override
    public void distilation() 
    {
	System.out.println("Whiskey is made from fermented corn and wheat.");	
    }

    /**
     * Overriding the aging method
     */
    @Override
    public void aging()
    {
	System.out.println("When the whiskey is aging the taste is improving");
    }

}
