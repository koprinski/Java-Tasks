package com.omisoft.basic_java.Threads.task8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Creates a menu for the program
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		String element;
		int ch = 0;
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ListOperations obj = new ListOperations();
		
		do
		{
			System.out.println();
			System.out.println("Please choose an option:");
			System.out.println("1 - add element in the list");
			System.out.println("2 - remove element from the list");
			System.out.println("3 - print all the elements in the list");
			System.out.println("4 - exit");
		
			try
			{
				ch = Integer.parseInt(input.readLine());
				
				switch(ch)
				{
					case 1: 
						System.out.println("Enter element in the list: ");
						element = input.readLine();
						obj.addElement(element);
						break;
					case 2:
						obj.removeElement();
						break;
					case 3:
						System.out.println("---All the elements in the list---");
						obj.printAllElements();
						break;
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
		while (ch != 4);

	}

}
