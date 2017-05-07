package com.omisoft.basic_java.Threads.practice;

public class Account {
	private int accountNumber;
	private int balance;
	
	public Account(int accountNumber, int balance)
	{
		this.setAccountNumber(accountNumber);
		this.setBalance(balance);
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String toString()
	{
		return "Account number: " + accountNumber + " : $" + balance;
	}
}
