package com.omisoft.basic_java.Threads.task1;

import java.io.IOException;
/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Thread first =new Thread(new ThreadFirst(0));
		
		first.start();
		System.out.println("Press enter to stop the thread...");
		try 
		{
			System.in.read();
			ThreadFirst.setFlag(false);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return ;
		
	}

}
