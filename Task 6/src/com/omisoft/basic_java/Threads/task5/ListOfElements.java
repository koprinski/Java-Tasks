package com.omisoft.basic_java.Threads.task5;

import java.util.ArrayList;

/**
 * Class that adds, removes and prints elements of an array list.
 * @author bkoprinski
 *
 */
public class ListOfElements {

	private ArrayList<Object> arr = new ArrayList<Object>();
	@SuppressWarnings("unused")
	private AddObject thread2;
	@SuppressWarnings("unused")
	private RemoveObject thread1;
	/**
	 * Checks if the array list is empty
	 * @return - null
	 */
	private boolean isEmpty() 
	{
        return arr.size() == 0;
	}

	/**
	 * Checks if the list is full
	 * @return
	 */
	public boolean notFull() 
	{
         if ( isEmpty() )
         {
        	 return true;
         }
         else if (arr.size()<5)
         {
        	 return true;
         }
         else
         {
        	 return false;
         }
	}
	
	/**
	 * Removes the last element of the ArrayList
	 * If the list is empty the thread is waiting for the add method to be executed
	 * @throws AlreadyEmptyException
	 */
	public synchronized void removeElement()
	{
	
		while (isEmpty())
		{
			
			try 
			{
				System.out.println("The thread is waiting for the add method to add elements in the array list...");
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}	
		notifyAll();
		Object a = arr.get(arr.size()-1);
		arr.remove(a);
		
	}
	
	/**
	 * Adds object to the array list
	 * If the list is full the thread is waiting for the remove method to be executed
	 * @param obj - element from the keyboard
	 */
	public synchronized void addElement(Object obj)
	{

		while(notFull() == false)
		{
			try 
			{
				System.out.println("The thread is waiting for the remove method to remove elements in the array list...");
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		notifyAll();
		arr.add(obj);

	}
	/**
	 * Prints all the elements of the ArrayList
	 */
	public void printAllElements()
	{
		System.out.println(arr);
	}
	
	/**
	 * Creates new adding thread
	 * @param obj
	 */
	public void add(Object obj) 
	{
		thread2 = new AddObject(this, obj);
	}

	/**
	 * Creates new removing thread
	 */
	public void remove() 
	{
		thread1 = new RemoveObject(this);
	}

}
