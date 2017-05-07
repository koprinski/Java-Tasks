package com.omisoft.basic_java.exceptions.task3;

import java.util.ArrayList;


public class ListOfElements {

	private ArrayList<Object> arr = new ArrayList<Object>();

	/**
	 * Checks if the array list is empty
	 * @return - null
	 */
	private boolean isEmpty() 
	{
        return arr == null;
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
	 * Removes the last element of the array list
	 * @throws AlreadyEmptyException
	 */
	public Object remove() throws AlreadyEmptyException
	{
		if(arr.size() == 0)
		{
			throw new AlreadyEmptyException("");
		}
		else
		{
			String a = (String) arr.get(arr.size() -1);
			arr.remove(a);
			
		}
		return arr;
		
	}
	
	/**
	 * Adds 5 elements to the array list
	 * @param obj - element from the keyboard
	 */
	public void add(Object obj) throws AlreadyFullException
	{
		
		if (notFull())
		{
			arr.add(obj);
		}	
		else
		{
			throw new AlreadyFullException("List = "+arr);
		}
	
	}
	/**
	 * Prints all the elements of the array list
	 */
	public void printAllElements()
	{
		System.out.println(arr);
	}

}
