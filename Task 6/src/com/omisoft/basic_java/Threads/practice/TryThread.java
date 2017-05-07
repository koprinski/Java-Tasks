package com.omisoft.basic_java.Threads.practice;

public class TryThread implements Runnable{
	private String firstName;
	private String secondName;
	private long aWhile;
	
	public TryThread(String firstName, String secondName, long delay)
	{
		this.firstName=firstName;
		this.secondName = secondName;
		this.aWhile=delay;
		//setDaemon(true);
	}
	
	public void run() {
		try {
			while(true) 
			{
			System.out.print(firstName);
			Thread.sleep(aWhile);
			System.out.print(secondName + "\n");
			}
		}
		catch(InterruptedException e) 
		{
			System.out.println(firstName + secondName + e);
		}
	}
}
