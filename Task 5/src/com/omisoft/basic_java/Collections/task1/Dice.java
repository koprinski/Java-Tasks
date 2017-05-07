package com.omisoft.basic_java.Collections.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dice {

    private static ArrayList<String> position = new ArrayList<String>();
 
    private static HashMap<String, ArrayList<String>> combinations = new HashMap<String, ArrayList<String>>(100);
	
    private static Scanner input = null;
    
    /**
     * Method for randomly throwing dice
     * @param firstThrow - randomly generates a first number from 1 to 6
     * @param secondThrow - randomly generates a second number from 1 to 6 
     * @param combinationThrow - concats the two numbers in a string
     */
	public static void DiceThrow()
	{
		int firstThrow;
		int secondThrow;
		String combinationThrow;

		
		for (int i = 0; i < 2; i++) 
		{
			firstThrow = 1+ (int)(Math.random() *6);
			secondThrow = 1+ (int)(Math.random() *6);

		
			combinationThrow = String.valueOf(firstThrow) + String.valueOf(secondThrow);
			
		
			if(!combinations.containsKey(combinationThrow))
			{
				ArrayList<String> newPos  = new ArrayList<String>();
				newPos.add(String.valueOf(i));
				combinations.put(combinationThrow, newPos);

			}
			else
			{
				position = (ArrayList<String>) combinations.get(combinationThrow);
				position.add(String.valueOf(i));
				combinations.put(combinationThrow, position);  
			}
		}
	}

	/**
	 * Method for returning a checked combination
	 * @param combCheck - the two numbers given from the user
	 * @return - object
	 */
	public static Object getCombination(String combCheck) {
        return combinations.get(combCheck);
	}
	
	/**
	 * Method for checking if the two numbers are in the statistic
	 */
	@SuppressWarnings("unchecked")
	public static void DiceCheck()
	{
		int first = 0;
		int second = 0;
		ArrayList<Object> checkPos = new ArrayList<Object>();  
		
		DiceThrow();
		
		try
		{
			System.out.println("Enter dice combination.");
			input = new Scanner(System.in);
			System.out.println("First dice : ");
			int dice1 = input.nextInt();
			System.out.println("Second dice : ");
			int dice2 = input.nextInt();
			first = dice1;
			second = dice2;
		}
		catch(InputMismatchException j)
		{
			System.err.println("Please write an integer number from 1 to 6!");
		}
		
	
		String combCheck = String.valueOf(first) + String.valueOf(second);
			
			
		try
		{
			if ( (checkPos = (ArrayList<Object>)getCombination(combCheck)).isEmpty() != true )
			{
				System.out.println("The combination ["+first+","+second+"] are thrown at positions: "+checkPos);
			}
			else
			{
				System.out.println("This combinaton is not in the statistic!");
			}
		}
		catch(NullPointerException e)
		{
			System.err.println("This combinaton is not in the statistic!");
			DiceCheck();	
		}
		
	}
	
	/**
	 * Method for closing the scanner
	 */
	public static void closeScanner()
	{
		if (input != null)
		{
			input.close();
		}
	}

}
