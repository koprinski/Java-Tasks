package com.omisoft.basic_java.exceptions.task2;


public class ReadFromConsole {
	/**
	 * Reads a number from the console
	 * @return - the numbers value
	 * @throws MyException - custom exception if the number is bigger than 100 or smaller than 0
	 */
	public static String read(String a) throws MyException
	{
		
		int x=Integer.parseInt(a);
		
		if (x>100)
		{
			throw new MyException("The number " + x + " is bigger than 100 !\n");
		}
		else if (x<0)
		{
			throw new MyException("The number " + x + " is smaller than 0 !\n");
		}	
		return a;		
		}	
	}
	
	
 

