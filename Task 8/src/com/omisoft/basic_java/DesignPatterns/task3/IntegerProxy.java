package com.omisoft.basic_java.DesignPatterns.task3;

/**
 * Creates a Proxy which implements the interface and is seen from the client
 * @author bkoprinski
 *
 */
public class IntegerProxy implements IntegerFactory{
	
	private Proxy proxy;
	private String name;
	
	/**
	 * Constructor
	 * @param name
	 */
	public IntegerProxy(String name)
	{
		this.name=name;
	}

	/**
	 * Overriding the method for creating a new instance
	 */
	@Override
	public void createInstance() {
		if (proxy == null)
		{
			proxy = new Proxy(name);
		}
		proxy.createInstance();
	}
}
