package com.omisoft.basic_java.Threads.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
		ListOfElements list = new ListOfElements();
		int ch = 0;
		Object p;
		
		do
		{
			System.out.println("Please choose an option:");
			System.out.println("1 - add elements in the arraylist");
			System.out.println("2 - remove elements from the arraylist");
			System.out.println("3 - print all the elements from the arraylist");
			System.out.println("4 - exit");
			
			try 
			{
				ch = Integer.parseInt(input.readLine());
			
				switch(ch)
				{
				
					case 1:
						System.out.println("Enter element : ");
						p = input.readLine();
						list.add(p); break;
					case 2:list.remove();break;
					case 3:list.printAllElements(); break;
					case 4: break;
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
			catch (NumberFormatException e)
			{
				System.err.println("Wrong format!");
			}
			
		}
		while(ch != 4);
	
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
