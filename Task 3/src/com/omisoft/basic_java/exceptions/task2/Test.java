package com.omisoft.basic_java.exceptions.task2;

import java.util.Scanner;

/**
 * Tests the reading from console and throws a custom exception
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner input = null;
		
		try{
			input = new Scanner(System.in);
			System.out.print("Write a number = " );
			String a = input.next();
			ReadFromConsole.read(a);
		}
		catch(MyException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException j)
		{
			System.err.println("The format is not valid. Please write integer value.");
		}
		finally
		{
			if (input != null)
			{
				input.close();
			}
		}	
		
	}
}
