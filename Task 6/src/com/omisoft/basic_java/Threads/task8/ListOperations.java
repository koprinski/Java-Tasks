package com.omisoft.basic_java.Threads.task8;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Creates an array list with some operations
 * @author bkoprinski
 *
 */
public class ListOperations {

	private ArrayList<String> list = new ArrayList<String>();
	private boolean expired;
	private boolean deleteElem;
	@SuppressWarnings("unused")
	private Timer timer;
	
	public ListOperations()
	{
		this.expired = false;
	}
	
	/**
	 * Adds a single element in the end of an array list
	 * @param a
	 */
	public void addElement(String a)
	{
		list.add(a);
	}
	
	/**
	 * Removes the first element of the array list
	 */
	public synchronized void removeElement()
	{
		if(list.size() != 0)
		{
		    	expired = false;
		    	deleteElem = false;
			timer = new Timer();
			try {
		
				System.in.read();
		
				expired = true;
				deleteElem = true;
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		else
		{
			System.out.println("The list is empty!");
		}
	}
	
	/**
	 * Prints all the elements in the array list
	 */
	public void printAllElements()
	{
		System.out.println(list);
	}


	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}


	/**
	 * @param expired the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
	
	/**
	 * Timer thread which waits for 30 seconds for the user to decide if the user really wants
	 * to remove the first element or not to do that.
	 * If the user enter a symbol he will delete the first element if not the element wont be deleted.
	 * @author bkoprinski
	 *
	 */
	public class Timer implements Runnable{
		
		private int count;
		
		public Timer() {
			this.count=0;
	        new Thread(this).start();
		}

	
		@Override
		public synchronized void run() 
		{	
	
			while(count < 30 && (expired == false))
			{
				try
				{
					count++;
					System.out.println("Are you sure you want to remove this element?   -   "+count);
					Thread.sleep(1000);
				
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
					
				}
				
			}
			if (deleteElem == true)
			{
				System.out.println("The element is removed.");
				list.remove(0);
			}
			else
			{
				System.out.println("Timer has expired. This element is not removed.");
				printAllElements();
			}
		
			return ;
		}
		
	}
}
