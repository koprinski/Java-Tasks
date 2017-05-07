package com.omisoft.basic_java.Threads.task2;

import java.io.IOException;
/**
 * Tests the 2 counter threads
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Thread first =new Thread(new TwoThreads(0,5));
		Thread second =new Thread(new TwoThreads(0,20));
		
		first.start();
		second.start();
		System.out.println("Press enter to stop the thread...");
		
		try 
		{	
			System.in.read();
			TwoThreads.setFlag(true);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return ;

	}

}
