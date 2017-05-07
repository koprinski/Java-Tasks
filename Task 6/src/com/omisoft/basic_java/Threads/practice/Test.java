package com.omisoft.basic_java.Threads.practice;

import java.io.IOException;


public class Test {

	public static void main(String[] args) {
		Thread first =new Thread( new TryThread("Borislav", "Koprinski", 200L));
		Thread second =new Thread( new TryThread("Ivan", "Danev", 300L));
		Thread third = new Thread( new TryThread("Nikolai", "Nenchev", 500L));
		
		first.setDaemon(true);
		second.setDaemon(true);
		third.setDaemon(true);
		System.out.println("Press enter to stop the threads...");
		first.start();
		second.start();
		third.start();
		
		try 
		{
			System.in.read();
			System.out.println("Enter is pressed..");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		

		return;
		
	}

}
