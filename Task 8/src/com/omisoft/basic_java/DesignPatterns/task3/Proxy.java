package com.omisoft.basic_java.DesignPatterns.task3;

/**
 * Creates real class Proxy which implements the interface
 * the client doesnt see this class
 * @author bkoprinski
 *
 */
public class Proxy implements IntegerFactory{

	@SuppressWarnings("unused")
	private String name;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Proxy(String name)
	{
		this.name=name;
		load(name);
	}
	
	/**
	 * Overriding the method for creating a new instance
	 */
	@Override
	public void createInstance() {
		System.out.println("Instance created. ");
		
	}
	
	/**
	 * Method loading 
	 * @param name - which proxy is loaded
	 */
	private void load(String name)
	{
		System.out.println("Loading " + name);
	}
	
}
