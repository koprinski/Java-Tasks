package com.omisoft.basic_java.Threads.practice;

public class Bank {

	public void doTransaction(Transaction transaction)
	{
		int balance;
		switch(transaction.getType())
		{
		case CREDIT:
			synchronized(transaction.getAccount())
			{
				balance = transaction.getAccount().getBalance();
			}
			try
			{
				Thread.sleep(100);
				
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			balance += transaction.getAmount();
			transaction.getAccount().setBalance(balance);
			break;
		
		case DEBIT:
			synchronized (transaction.getAccount()) {
				balance = transaction.getAccount().getBalance();
			}
			try
			{
				Thread.sleep(150);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			balance -= transaction.getAmount();
			transaction.getAccount().setBalance(balance);
			break;
			
		default:
			System.out.println("Invalid transaction");
			System.exit(1);
		}
	}
}
