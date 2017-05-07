package com.omisoft.basic_java.objects.task3;

/**
 * Creates class Staff which extends Store
 * @author bkoprinski
 *
 */
public class Staff extends Store{
	private String firstName;
	private String lastName;
	private int paycheck;
	
	public Staff(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstName()
	{
		//System.out.println(firstName);
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName() {
		//System.out.println(lastName);
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPaycheck() {
		return paycheck;
	}

	public void setPaycheck(int paycheck) {
		this.paycheck = paycheck;
	}
	
}
