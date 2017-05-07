package com.omisoft.basic_java.Threads.practice;

public class Clerk implements Runnable {
	private Transaction inTray;
	private Bank theBank;
	

	public Clerk(Bank theBank)
	{
		this.theBank=theBank;
		this.inTray = null;
	}
	
	public void doTransaction(Transaction transaction)
	{
		inTray = transaction;
	}

	@Override
	public void run() {
		
		while(true)
		{
			while(inTray == null)
			{
				try
				{
					Thread.sleep(150);
				}
				catch(InterruptedException e) 
				{
					System.out.println(e);
				}
			}
			theBank.doTransaction(inTray);
			inTray = null;	
		}
	}
	
	public boolean isBusy()
	{
		return inTray != null;
	}
	
}
