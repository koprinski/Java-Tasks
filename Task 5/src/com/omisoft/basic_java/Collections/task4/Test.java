package com.omisoft.basic_java.Collections.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Tests ID validator
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		IdValidator obj = new IdValidator();
		
		try 
		{
			System.out.println("Enter your ID: ");
			String in = input.readLine();
			obj.validator(in);
			
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
