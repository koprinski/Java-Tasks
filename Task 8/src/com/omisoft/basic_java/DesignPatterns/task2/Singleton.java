package com.omisoft.basic_java.DesignPatterns.task2;
/**
 * Creating a Singleton class
 * @author bkoprinski
 *
 */
public class Singleton {
	private static Singleton instance = new Singleton();
	
	/**
	 * Constructor
	 */
	private Singleton()
	{
		System.out.println("Singleton created");
	}

	/**
	 * @return the instance
	 */
	public static Singleton getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}
	
}
