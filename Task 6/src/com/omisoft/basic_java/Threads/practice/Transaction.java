package com.omisoft.basic_java.Threads.practice;

public class Transaction {
	
	private TransactionType type;
	private Account account;
	private int amount;

	public Transaction(int amount, Account account, TransactionType type)
	{
		this.setAccount(account);
		this.setType(type);
		this.setAmount(amount);
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the type
	 */
	public TransactionType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TransactionType type) {
		this.type = type;
	}
	
	public String toString()
	{
		return type + "Account: " + account + " : $ "+ amount;
	}
	
}
