package com.omisoft.basic_java.Threads.practice;

import java.util.Random;

public class BankOperationsTest {

	public static void main(String[] args) {
		
		int[] initialBalance = {500, 800};
		int[] totalCredits = new int[initialBalance.length];
		int[] totalDebits = new int[initialBalance.length];
		int transactionCount = 20;
		
		// Creating the bank, the clerks and the account
		
		Bank theBank = new Bank();
		Clerk clerk1 = new Clerk(theBank);
		Clerk clerk2 = new Clerk(theBank);
		
		Account[] accounts = new Account[initialBalance.length];
		for (int i = 0; i < initialBalance.length; i++) {
			accounts[i] = new Account(i+1, initialBalance[i]);
			totalCredits[i] = totalDebits[i] = 0;
		}
		
		
		// Creating threads for clerk
		
		Thread clerk1Thread = new Thread(clerk1);
		Thread clerk2Thread = new Thread(clerk2);
		clerk1Thread.setDaemon(true);
		clerk2Thread.setDaemon(true);
		clerk1Thread.start();
		clerk2Thread.start();
		
		
		// Generate transactions of each type and pass to the clerks
		
		Random rand = new Random();
		Transaction transaction;
		int amount = 0;
		int select = 0;
		for(int i = 1 ; i <= transactionCount ; ++i) 
		{
			select = rand.nextInt(accounts.length);
			amount = 50 + rand.nextInt(26);
			transaction = new Transaction(amount, accounts[select], TransactionType.CREDIT);
			totalCredits[select] += amount;
			
			// Wait until the first clerk is free
			while(clerk1.isBusy()) 
			{
				try 
				{
					Thread.sleep(25);
				} 
				catch(InterruptedException e) 
				{
					System.out.println(e);
				}
			}
			
			clerk1.doTransaction(transaction);
			
			select = rand.nextInt(accounts.length);
			amount = 30 +rand.nextInt(31);
			transaction = new Transaction(amount, accounts[select], TransactionType.DEBIT);
			
			totalDebits[select] += amount;
			
			// Wait until the second clerk is free
			
			while(clerk2.isBusy()) 
			{
				try
				{
					Thread.sleep(25);
				}
				catch(InterruptedException e) 
				{
					System.out.println(e);
				}
			}
			clerk2.doTransaction(transaction);
		}
		
		//Wait until both clerks are done
		
		while(clerk1.isBusy() || clerk2.isBusy())
		{
			try
			{
				Thread.sleep(25);
			}
			catch(InterruptedException e) 
			{
				System.out.println(e);
			}
		}
		
		// Outputting the result
		for (int i = 0; i < accounts.length; i++) 
		{
			System.out.println("Account number: " + accounts[i].getAccountNumber());
			System.out.println("Original balance: $ " + initialBalance[i]);
			System.out.println("Total credits: $ " + totalCredits[i]);
			System.out.println("Total debits: $ " + totalDebits[i]);
			System.out.println("Final balance: $ " + accounts[i].getBalance());
			System.out.println("Should be: $ " + (initialBalance[i] + totalCredits[i] - totalDebits[i]));
		}
		
		
	}

}
