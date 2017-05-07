package com.omisoft.basic_java.Threads.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The main menu of the program
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		TimeoutHashtable obj = new TimeoutHashtable(1);
		String value;
		String key;
		int ch = 0;
	
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			System.out.println();
			System.out.println("Please choose an option:");
			System.out.println("1 - add value and key in the hashtable");
			System.out.println("2 - get the value of the hashtable");
			System.out.println("3 - remove element from the hashtable");
			System.out.println("4 - print all the elements of the hashtable");
			System.out.println("5 - exit");
			
			try
			{
				ch = Integer.parseInt(input.readLine());
				
				switch(ch)
				{
					case 1:
						System.out.println("---Adding elements in the hashtable---");
						System.out.println("Enter value: ");
						value = input.readLine();
						System.out.println("Enter key: ");
						key = input.readLine();
						obj.put(key, value);
						break;
					case 2:
						System.out.println("---Get the value of the hashtable---");
						System.out.println("Enter key: ");
						key = input.readLine();
						obj.get(key);
						break;
					case 3:
						System.out.println("---Remove element from the hashtable---");
						System.out.println("Enter key: ");
						key = input.readLine();
						obj.remove(key);
						break;
					case 4:
						System.out.println("---All the elements in the hashtable---");
						obj.printTable();
						break;
					case 5: break;
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
		while(ch != 5);
		
		try {
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
