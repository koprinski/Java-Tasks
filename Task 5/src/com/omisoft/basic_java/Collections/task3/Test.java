package com.omisoft.basic_java.Collections.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Tests the exception message manager
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String mes1 = null; 
		String mes2 = null;
		
			try 
			{
				System.out.println("Add exception message using code: ");
				mes1 = input.readLine();
				ExceptionsMessageManager.addExceptionMessageUsingCode(mes1);
				System.out.println("Add exception message: ");
				mes2 = input.readLine();
				ExceptionsMessageManager.addExceptionMessage(mes2);
				System.out.println("Message: ");
				ExceptionsMessageManager.getMessage();
				System.out.println("Message collection: ");
				System.out.println(ExceptionsMessageManager.getMessages());
			} 
			catch (IOException e)
			{
	
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if (input != null)
					{
						input.close();
					}
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			
	}

}
