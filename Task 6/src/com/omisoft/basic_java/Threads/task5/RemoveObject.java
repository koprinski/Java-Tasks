package com.omisoft.basic_java.Threads.task5;

/**
 * Thread that removes the last element from the list
 * @author bkoprinski
 *
 */
public class RemoveObject implements Runnable{

	private ListOfElements list;
	
	public RemoveObject(ListOfElements list)
	{
		this.list=list;
		new Thread(this).start();
	}
	
	@Override
	public void run() {

		list.removeElement();
		
	}
	
}
