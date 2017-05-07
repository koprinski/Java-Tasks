package com.omisoft.basic_java.Threads.task5;

/**
 * Thread that adds object to the list
 * @author bkoprinski
 *
 */
public class AddObject implements Runnable{
	private Object obj;
	private ListOfElements list;
	
	public AddObject(ListOfElements list, Object obj)
	{
		this.obj=obj;
		this.list=list;
		new Thread(this).start();
	}
	
	
	@Override
	public void run() 
	{
		list.addElement(obj);
	}
	
}
