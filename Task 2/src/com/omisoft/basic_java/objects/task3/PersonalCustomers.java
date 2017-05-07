package com.omisoft.basic_java.objects.task3;

/**
 * Creates class PersonalCustomers which extends Customers and implements
 * the interface CustomerSubscript
 * @author bkoprinski
 *
 */
public class PersonalCustomers extends Customers implements CustomerSubscript {
	private String giftCard;
	private String userName;
	public PersonalCustomers(String identNumber,int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}
	public String getGiftCard() {
		return giftCard;
	}
	public void setGiftCard(String giftcard) {
		giftCard = giftcard;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		userName = username;
	}
	
	public void giftExp()
	{
		System.out.println("The gift card expires in 30 days!");
	}

}
