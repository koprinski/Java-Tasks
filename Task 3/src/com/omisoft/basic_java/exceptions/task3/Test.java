package com.omisoft.basic_java.exceptions.task3;


/**
 * Tests the two custom exceptions
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {

		ListOfElements list = new ListOfElements();
		try
		{
			list.add("2");
			list.add("65");
			list.add("12");
			list.add("5");
			//list.add("6");
			list.add("19");
		}
		catch(AlreadyFullException afe)
		{
			afe.printStackTrace();
		}
		list.printAllElements();
		
		try
		{
			list.remove();
			list.remove();
			list.remove();
			list.remove();
			list.remove();
			list.remove();
	
		}
		catch(AlreadyEmptyException aee)
		{
			aee.printStackTrace();
		}
		list.printAllElements();
		
		
	}

}
